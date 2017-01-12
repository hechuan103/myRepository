<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人密码管理系统</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" href="resource/layui/css/layui.css">
	<link rel="stylesheet" href="resource/css/index.css">
	
  </head>
  <body>
<div id="loginWindow"  class="mini-window" title="用户登录" style="width:400px;height:165px;" >

    <div id="loginForm" style="padding:15px;padding-top:10px;">
    	<form  class="layui-form" >
  <div class="layui-form-item">
    <label class="layui-form-label">用户名：</label>
    <div class="layui-input-block">
      <input type="text" name="userName"    placeholder="请输入用户名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密&nbsp;码：</label>
    <div class="layui-input-inline">
      <input type="password" name="password"   placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux"></div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="go">登录</button>
      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="registered"  >注册</button>
    </div>
  </div>
  </form>   
    </div>

</div>
  </body>
  <script type="text/javascript" src="resource/scripts/jquery-1.6.2.min.js"></script>
   <script type="text/javascript" src="resource/scripts/jQuery.md5.js"></script>
  <script src="resource/layui/layui.js"></script>
  <script>
  layui.use('form', function(){
  var form = layui.form();
  var layer = layui.layer;
	  form.on('submit(go)', function(data){
	  if(data.field.userName == ""){
	  layer.msg("请填写用户名！", {
	    icon: 5
	    ,time: 3*1000 //6s后自动消失
	    ,offset: ['17%','42%'] //定义位置
	  });	  
	  }else if(data.field.password == ""){
	  layer.msg("请填写密码！", {
	    icon: 5
	    ,time: 3*1000 //6s后自动消失
	    ,offset: ['17%','42%'] //定义位置
	  });	  
	  }else{
	  	//加密
	  	data.field.password = $.md5(data.field.password).toUpperCase();
	  	var filed = JSON.stringify(data.field);
		     $.ajax({
		      url:"index/check.do",
		      type: 'POST',
		      contentType:"application/json; charset=utf-8",
		      data:filed,
		      success: function (data) {
		          if (data.flag) {
		             window.location = "index/welcome.do";
		          }else {
		                //向世界问个好
					  layer.msg(data.message, {
					    icon: 5
					    ,time: 3*1000 //6s后自动消失
					    ,offset: ['17%','42%'] //定义位置
					  });
		          }
		      }
		  });	  
	  }
	  return false;
	}); 
	
	 form.on('submit(registered)', function(){
	   		window.location = "registerApply/register.do";
	   		return false;
	   });
 });
  
  </script>
  
</html>
