<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="resource/layui/css/layui.css" media="all">

  </head>
  <body>
  <div id="registerWindow"  class="mini-window" title="用户注册" style="width:50%;height:165px; margin-top: 5%;margin-left: 25%;">
  <form  class="layui-form">
    <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>登陆名：</label>
    <div class="layui-input-block">
      <input type="text" name="loginId" required  lay-verify="loginName" placeholder="请输入登陆名" autocomplete="off" class="layui-input">
    </div>
  </div>
      <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>姓&nbsp;名：</label>
    <div class="layui-input-block">
      <input type="text" name="userName"   lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>密&nbsp;码：</label>
    <div class="layui-input-block">
      <input type="password" name="password"   lay-verify="password" placeholder="请输入6-16位密码" autocomplete="off" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>重复密码：</label>
    <div class="layui-input-block">
      <input type="password"   lay-verify="repassword" placeholder="请输入6-16位密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>性&nbsp;别：</label>
    <div class="layui-input-block">
      <input type="radio"  name="sex" value="男" title="男" checked="checked">
      <input type="radio"  name="sex" value="女" title="女">    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>邮&nbsp;箱：</label>
    <div class="layui-input-block">
 		<input type="text" name="eMail" required  lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>联系方式：</label>
    <div class="layui-input-block">
 		<input type="text" name="telePhone" required  lay-verify="phone" placeholder="请输入电话" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>地&nbsp;址：</label>
    <div class="layui-input-block">
 		<input type="text" name="address"  lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="reg">立即提交</button><!-- <i class="layui-icon">&#xe618;</i> -->
      <button type="reset" class="layui-btn layui-btn-primary"><i class="layui-icon">&#x1002;</i> 重置</button>
 
    </div>
  </div>
  </form>
  </div>
  </body>
   <script type="text/javascript" src="resource/scripts/jquery-1.6.2.min.js"></script>
   <script type="text/javascript" src="resource/scripts/jQuery.md5.js"></script>
   <script src="resource/layui/layui.js"></script>
   <script type="text/javascript">
		//我们强烈推荐你在代码最外层把需要用到的组件先加载
		layui.use(['layer', 'form', 'element'], function(){
		  var layer = layui.layer;
		  var passwordT = "";
		  var  form = layui.form();
		  element = layui.element();
		  //表单校验
		  form.verify({
			  loginName: function(value){
			    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
			      return '登陆名不能有特殊字符';
			    }
			    if(/(^\_)|(\__)|(\_+$)/.test(value)){
			      return '登陆名首尾不能出现下划线\'_\'';
			    }
			    if(/^\d+\d+\d$/.test(value)){
			      return '登陆名不能全为数字';
			    }			    
			  },
			  //我们既支持上述函数式的方式，也支持下述数组的形式
			  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
			  password: function(value){
			  	passwordT = value;
			  	if(!/^[\S]{6,16}$/.test(value)){
			  		return '密码必须6到16位，且不能出现空格';
			  	}
			  },
			  repassword:function(value){
			  	if(value != passwordT){
			  		return '两次输入的密码不一致';
			  	}
			  }
			});
		  //;//提交注册数据
		form.on('submit(reg)', function(data){
		  var message = save(data.field.loginId);
		  if(message !=""){
			  layer.msg(message, {
			    icon: 5
			    ,time: 3*1000 //6s后自动消失
			    ,offset: '100px' //定义位置
			  });
		  }else{
		  	//加密
		  	data.field.password = $.md5(data.field.password).toUpperCase();
		  	var filed = JSON.stringify(data.field);
             $.ajax({
                  type:"post",
                  url:"registerApply/registed.do",
                  dataType: 'json', 
                  contentType:"application/json; charset=utf-8",
                  data: filed,//表单数据
                  success:function(data){
                      if(data.flag){
						  layer.msg(data.message+"3秒后自动跳转", {
						    icon: 6
						    ,time: 3*1000 //6s后自动消失
						    ,offset: '100px' //定义位置
						    },function(layero, index){
							   window.location="";
							  });
						  
                      }else{
                      	layer.msg(data.message, {
						    icon: 5
						    ,time: 3*1000 //6s后自动消失
						    ,offset: '100px' //定义位置
						  });
                      }
                  }
              });		  
		  }
		  return false
		});	 
		//检查id是否有效
		function save(checkName){
			var message ="";
     		$.ajax({
                 type:"post",
                 url:"registerApply/checkLoignId.do",
                 data: {"loginId":checkName},//表单数据
                 async: false,
                 success:function(data){
                     message = data.message;
                     console.log(data.message);
                 }
             });
             return message;
              console.log("qqq"+data.message);
		}
		  //……
		  //你的代码都应该写在这里面
		});
   
   </script>
</html>
