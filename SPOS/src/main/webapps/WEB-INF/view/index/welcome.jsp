<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="resource/css/font_1466258017_0700355.css">
	<link rel="stylesheet" href="resource/layui/css/layui.css">
	<link rel="stylesheet" href="resource/css/navigate.css">
  </head>
  
  <body>
<div class="layui-layout layui-layout-admin "  >
<div class="layui-layout layui-layout-admin layui-bg-black" >
  <div class="layui-header header header-demo" style="height: 90px;">

        <img src="resource/images/logo.png"  style="padding-right:75px;">

  <div class="nav-user"><a class="unlogin" href="#">
  <i class="iconfont icon-touxiang"></i></a><span>${user }</span>
  <a href="index/logout.do" id="reg"><i class="iconfont icon-guanbi"></i></a><span><a href="index/logout.do">退出</a></span></div>
</div>
</div>
<!--左边树形菜单  -->
<div class="layui-side layui-bg-black" style="top: 90px" > 
 <div class="layui-side-scroll">
<ul class="layui-nav layui-nav-tree site-demo-nav " lay-filter="demo">
<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
  <li class="layui-nav-item layui-nav-itemed">
    <a href="javascript:;">基本信息</a>
    <dl class="layui-nav-child">
      <dd><a href="javascript:;">个人信息</a></dd>
      <dd><a href="javascript:;">密码管理</a></dd>
    </dl>
  </li>
  <li class="layui-nav-item">
    <a href="javascript:;">系统工具</a>
    <dl class="layui-nav-child">
      <dd><a href="">登陆查询</a></dd>
    </dl>
  </li>
</ul>
</div>
</div>
<!-- 中间部分  --> 
<div class="layui-tab layui-tab-brief">
<div class="layui-body layui-tab-content site-demo site-demo-body"   >
<div class="layui-tab" lay-filter="tab" lay-allowclose="true">
	<ul class="layui-tab-title">
		<li class="layui-this" id="admin-home"><i class="iconfont icon-nv"></i><em>后台首页</em></li>
	</ul>
  <div class="layui-tab-content">
		<div class="layui-tab-item layui-show">
			<iframe class="larry-iframe" data-id='0' style="height: 400px" src="manageMent/first.do" frameborder="0" style="width: 100%;"></iframe>
		
		</div>
  </div>
</div>
</div>  
  </div> 
<!-- 底部菜单 -->
<div class="layui-footer footer footer-demo " style="height:12%;">
<div style="margin-top:30px;" align="center">联系作者：hechuan@haiwaigo.cn</div>
	<div style="margin-top:15px; font-style: withlte" align="center">2016 © power by hc</div>
</div>  
  
</div>  

  </body>
  <script type="text/javascript" src="resource/scripts/jquery-1.6.2.min.js"></script>
  <script src="resource/layui/layui.js"></script>
  <script type="text/javascript" src="resource/scripts/navigate/navigateTree.js"></script>
  
  
</html>
