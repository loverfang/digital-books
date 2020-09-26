package com.echuang.modules.sys.controller;

import com.echuang.common.utils.ResultResponse;
import com.echuang.common.web.AbstractController;
import com.echuang.modules.sys.entity.SysUserEntity;
import com.echuang.modules.sys.form.SysLoginVo;
import com.echuang.modules.sys.service.SysCaptchaService;
import com.echuang.modules.sys.service.SysUserService;
import com.echuang.modules.sys.service.SysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 登录相关
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class SysLoginController extends AbstractController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserTokenService sysUserTokenService;
    @Resource
    private SysCaptchaService sysCaptchaService;

    /**
     * 验证码
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        try(//try-with-resources 语法，自动关闭资源
            ServletOutputStream out = response.getOutputStream()
        ){
            ImageIO.write(image, "jpg", out);
        }
    }

    /**
     * 登录
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysLoginVo form) throws IOException {
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return ResultResponse.error("验证码不正确");
        }

        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUsername());

        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return ResultResponse.error("账号或密码不正确");
        }

        //账号锁定
        if (user.getStatus() == 0) {
            return ResultResponse.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        ResultResponse r = sysUserTokenService.createToken(user.getUsername(), user.getUserId());
        return r;
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public ResultResponse logout() {
        sysUserTokenService.logout(getUser().getUsername(), getUserId());
        return ResultResponse.ok();
    }

}
