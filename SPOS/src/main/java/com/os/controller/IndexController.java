package com.os.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.os.base.controller.BaseController;
import com.os.base.vo.Operate;
import com.os.service.intf.IOperateService;
import com.os.service.intf.IUserService;
import com.os.util.CheckAndMakeEncrypt;
import com.os.util.IPUtil;
import com.os.util.Message;
import com.os.vo.User;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
	private static String  VIEW_PATH="index";
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IOperateService operateService;
	
	private Message message;

	@Override
	public String getBaseViewPath() {
		return VIEW_PATH;
	}
	//用户验证
	@RequestMapping("/check")
	public @ResponseBody Message checkPass(@RequestBody User ruser,
			HttpServletRequest request, HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		try {
			User user = userService.selectByLoginId(ruser.getUserName());
			//校验密码
			if(user != null){
				if(CheckAndMakeEncrypt.checkPassword(ruser.getPassword(), user.getPassword())){
					message = new Message(true,"");
				}else{
					 message = new Message(false, "用户名或密码不正确");
				}
			}else{
				 message = new Message(false, "用户不存在");
			}
			//将用户放入session
			HttpSession session = request.getSession();
			session.setAttribute("userName", user);
		} catch (Exception e) {
			message = new Message(false, "用户名或密码不正确");
		}
		return message;
	}
	//跳转到登陆成功页面
	@RequestMapping("/welcome")
	public String welcomePage(HttpServletRequest request, HttpServletResponse response){
    	String ip = IPUtil.getIpAddress(request);
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("userName");
    	String  os = IPUtil.getOperateSystem(request);
        //记录登入帐号
    	Operate op = new Operate();
    	op.setDateTime(new Date());
    	op.setLoginId(user.getUserName());
    	op.setOperate("登陆系统");
    	op.setLoginIp(ip);
    	op.setOperateSystem(os);
    	operateService.insert(op);
    	request.setAttribute("user", user.getUserName());
    	
		return getViewPath("welcome");
	}
	
	//用户退出
	@RequestMapping("/logout")
	public String logoutSystem(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();
		return("../../index");
	}
	


}
