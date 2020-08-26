package com.echuang.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.CookieUtil;
import com.echuang.common.utils.IPUtils;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.Query;
import com.echuang.modules.sys.entity.SysLogEntity;
import com.echuang.modules.sys.mapper.SysLogMapper;
import com.echuang.modules.sys.service.SysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;


@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogEntity> implements SysLogService {
    /**
     * 未保存的日志队列
     */
    private static final ConcurrentLinkedQueue<SysLogEntity> SysLogsQueue = new ConcurrentLinkedQueue<>();

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");

        IPage<SysLogEntity> page = this.page(
            new Query<SysLogEntity>().getPage(params),
            new QueryWrapper<SysLogEntity>().like(StringUtils.isNotBlank(key), "username", key)
        );

        return new PageUtils(page);
    }

    /**
     * 添加系统日志到队列中，队列数据会定时批量插入到数据库
     * @param params
     */
    public void addLog(String method, String params) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String openid = CookieUtil.getCookieValue(request, "openid");
        String ip = IPUtils.getIpAddr(request);
        SysLogEntity sysLog = new SysLogEntity(openid, method, params, ip);
        SysLogsQueue.offer(sysLog);
    }

    /**
     * 定时将日志插入到数据库
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    synchronized void batchAddSysLog() {
        List<SysLogEntity> logs = new ArrayList<>();
        while (!SysLogsQueue.isEmpty()) {
            logs.add(SysLogsQueue.poll());
        }
        if (!logs.isEmpty()) {
            this.saveBatch(logs);
        }
    }
}
