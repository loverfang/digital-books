package com.echuang.common.interceptor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.service.CmsCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * 网站栏目信息拦截器
 * 
 */
public class NavigaterInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(NavigaterInterceptor.class);

	@Resource
	private CmsCategoryService cmsCategoryService;
	
	/**
	 * 进入方法前
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {

		// 在这里判断访问来源是手机还是PC，然后存入request中，在接下来的方法中跳转不同的页面
		// boolean isMobile = DeviceUtils.isMobileDevice(request);
		// log.debug("the visit device isMobile?" + isMobile);
		// request.setAttribute("isMobile", isMobile);
		
		return true;
	}
	
	
	/**
	 * 出了方法到页面前
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
		
		//如果是ajax请求响应头会有x-requested-with
		if(!(request.getHeader("x-requested-with") != null && 
				request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))){
			
			// 构建网站导航树,放到每次的request中, 所有前台统一使用
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("parentId", 0);
			
			// 顶部导航, 这里可以用缓存来查
			List<CmsCategoryDTO> navigaterList = cmsCategoryService.webChannels( 0L );

			// 二级栏目的导航菜单
			model.addObject("channelList", navigaterList);

			// 构建面包屑导航
			Integer currentNavId = (Integer) model.getModel().get("currentNavId");
			if(currentNavId!=null){
				List<CmsCategoryDTO> navigateList = channelNav(currentNavId);
				model.addObject("navigateList",navigateList);
			}
		}
		
	}

	
	/**
	 * 获取栏目 面包屑导航
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 */
	private List<CmsCategoryDTO> channelNav(Integer categoryId){

		//获得当前频道
		CmsCategoryEntity categoryEntity = cmsCategoryService.getById( categoryId );

		List<CmsCategoryDTO> navList = new ArrayList<CmsCategoryDTO>();
		//若当前频道为空或者父ID为-1(即：当前频道为顶级目录)
		if(categoryEntity!=null){
			CmsCategoryDTO tempDTO = new CmsCategoryDTO();
			BeanUtils.copyProperties(categoryEntity, tempDTO);

			channelNav(navList, tempDTO);
		}
		
		return navList;
	}

	private void channelNav(List<CmsCategoryDTO> navList, CmsCategoryDTO categoryDTO){
		//获得当前频道
		CmsCategoryEntity categoryEntity = cmsCategoryService.getById( categoryDTO.getParentId() );

		if(categoryEntity!=null&& categoryEntity.getCategoryId()!=0){
			CmsCategoryDTO tempDTO = new CmsCategoryDTO();
			BeanUtils.copyProperties(categoryEntity, tempDTO);
			navList.add(tempDTO);
		}

	}
	
}