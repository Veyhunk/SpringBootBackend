package com.yj.server.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yj.server.service.VrcodeService;
import com.yj.server.util.UUIDUtil;

/**
 * 
 * 
 * 功能描述： 首页(登录页面) 创建人：Administrator 创建时间：2018年9月15日 下午1:14:18
 * 
 * @version
 *
 */
@Controller
public class HomePageController {
	@Autowired
	private VrcodeService vrcodeService;

	/**
	 * 获取下图片验证码
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws Exception
	 */
	@RequestMapping("/vrcode")
	public void defaultKaptcha(String id, HttpServletResponse httpServletResponse) {
		vrcodeService.createVrcode(id, httpServletResponse);
	}

	/**
	 * 首页
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/")
	public String login(ModelMap map) {
		map.put("id", UUIDUtil.createUUID());
		return "login";
	}

}
