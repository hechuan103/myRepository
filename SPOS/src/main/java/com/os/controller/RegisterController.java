package com.os.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.os.base.controller.BaseController;
import com.os.base.vo.UserInfo;
import com.os.service.intf.IUserInfoService;
import com.os.service.intf.IUserService;
import com.os.util.CheckAndMakeEncrypt;
import com.os.util.CopyBeanToBean;
import com.os.util.Message;
import com.os.vo.User;
import com.os.vo.bean.UserInfoBean;

/**
 * 
 * @title 用户申请注册类
 * @author HC
 * @date 2016-12-27下午3:11:46
 * @class RegisterController
 * @package com.os.controller
 * @project SPOS
 * @describe 
 *
 */
@Controller
@RequestMapping("/registerApply")
public class RegisterController extends BaseController {
	//视图模块文件夹
	private static String  VIEW_PATH="register";
	
	private Message message;
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserInfoService userInfoService;
	
	@Override
	public String getBaseViewPath() {
		return VIEW_PATH;
	}
	//跳转到注册页面
	@RequestMapping("/register")
	public String registered(){
		return getViewPath("register");
	}
	
	//注册id验证
	@RequestMapping("/checkLoignId")
	public @ResponseBody Message checkLoignId(String loginId){
		message = new Message(true,"");
		User user = userService.selectByLoginId(loginId);
		if(null != user){
			message = new Message(false,"此此账号已经被使用了！");
		}
		return message;
	}
	
	//注册资料保存
	@RequestMapping("/registed")
	public @ResponseBody Message registering(@RequestBody UserInfoBean users,
			HttpServletRequest request, HttpServletResponse response){
		try {
			if(null!=users){
				UserInfo  userInfo  = new UserInfo(); 
				User user = new User(); 
				CopyBeanToBean.copy(userInfo, users);
				userInfo.seteMail(users.geteMail());
				userInfo.setName(users.getUserName());
				userInfo.setCreatTm(new Date());
				CopyBeanToBean.copy(user, users);
				user.setPassword(CheckAndMakeEncrypt.encryptInfo(users.getPassword()));
				user.setUserName(users.getLoginId());
					int n = userInfoService.insertSelective(userInfo);
					int m = userService.insertSelective(user);
					if(m+n == 2){
						message = new Message(true,"处理成功，正在前往登陆页！");
					}
				}else{
					message = new Message(false,"处理失败，user无法解析！");
				}
		} catch (Exception e) {
			e.printStackTrace();
			 message = new Message(false, "注册异常了");
		}
		return  message;
	}



}
