package com.os.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.os.base.controller.BaseController;
import com.os.vo.User;
/**
 * 
 * @title 后台管理 类 
 * @author HC
 * @date 2016-12-29下午5:07:43
 * @class ManageMentController
 * @package com.os.controller
 * @project SPOS
 * @describe 
 *
 */
@Controller
@RequestMapping("/manageMent")
public class ManageMentController extends BaseController {
	private static String VIEW_PATH = "management";
	

	@Override
	public String getBaseViewPath() {
		return VIEW_PATH;
	}
	
	//后台管理首页
	@RequestMapping("/first")
	public String manageMentFirst(HttpServletRequest request, HttpServletResponse response){
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("userName");
		request.setAttribute("user", user.getUserName());
		
		return getViewPath("main");
	}

}
