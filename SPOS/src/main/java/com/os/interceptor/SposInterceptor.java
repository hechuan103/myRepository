package com.os.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.os.vo.User;

/**
 * 登陆认证拦截器
 * @title 
 * @author HC
 * @date 2016-12-15下午2:48:02
 * @class SposInterceptor
 * @package com.os.interceptor
 * @project SPOS
 * @describe 
 *
 */
public class SposInterceptor implements HandlerInterceptor {


	/** 
     * Handler执行完成之后调用这个方法 
     */ 
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exc)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	/** 
     * Handler执行之后，ModelAndView返回之前调用这个方法 
     */  
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/** 
     * Handler执行之前调用这个方法 
     */  
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
	       //获取请求的URL  
        String url = request.getRequestURI();  
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制  
        if(url.indexOf("check.do")>=0||url.indexOf("registerApply")>=0){  
            return true;  
        }  
        //获取Session  
        HttpSession session = request.getSession();  
        User user = (User)session.getAttribute("userName");  
        if(user != null){  
            return true;  
        }
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("/index.jsp").forward(request, response);  
          
        return false;  
	}

}