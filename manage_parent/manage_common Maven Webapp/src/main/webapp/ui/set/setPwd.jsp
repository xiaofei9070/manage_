<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta charset="utf-8">
	  <title>set password</title>
	  <meta name="renderer" content="webkit">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	  <link rel="stylesheet" href="statics/layui/css/layui.css" media="all">
	  <style>
	  	.layui-input{margin-bottom: 30px;}
	  	.layui-form-item{position: relative;}
	  	.layadmin-user-login-icon{position: absolute;left: 1px;top: 1px;width: 35px;line-height: 36px;text-align: center;color: #d2d2d2;}
	  </style>
	</head>
	<body>
		<div class="" style="margin:100px auto 0;width:340px;height:400px;">
			<form action="" class="layui-form">
				<div class="layui-form-item">
				     <input type="password" name="oldPwd" lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
				</div>
				<div class="layui-form-item">
				    <input type="password" name="pwd" lay-verify="required" autocomplete="off" placeholder="请输入新密码" class="layui-input">
				</div>
				<div class="layui-form-item">
				    <input type="password" name="confirmPwd" lay-verify="required" autocomplete="off" placeholder="请输入新密码" class="layui-input">
				</div>
				<button class="layui-btn layui-btn-fluid" lay-submit lay-filter="login">确定</button>
			</form>
		</div>
	</body>
	<script src="statics/layui/layui.all.js" type="text/javascript"></script>
  <script>
  layui.config({
    base: 'statics/' //静态资源所在路径
  }).extend({
    set:'modules/set'
  }).use(['set']);
  </script>
</html>
