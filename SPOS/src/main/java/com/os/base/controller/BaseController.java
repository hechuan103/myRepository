package com.os.base.controller;

/**
 * 基础的controller类
 * @title 
 * @author HC
 * @date 2016-12-14上午10:41:27
 * @class BaseController
 * @package com.os.base
 * @project SPOS
 * @describe 
 *
 */
public abstract class BaseController {
	/**
	 * 获取视图所在模块文件
	 * @return
	 */
	public abstract String getBaseViewPath();
	/**
	 * 返回访问路径
	 * @param viewName
	 * @return
	 */
	public String getViewPath(String viewName){
		return getBaseViewPath()+"/"+viewName;
	}

}
 