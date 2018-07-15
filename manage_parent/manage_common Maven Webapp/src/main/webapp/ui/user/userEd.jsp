<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
	  <title>LoginPage</title>
	  <meta charset="utf-8">
	  <meta name="renderer" content="webkit">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  <link rel="stylesheet" href="statics/layui/css/layui.css"  media="all">
	  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	  <style>
	  	.layui-input{padding-left:35px;margin-bottom: 30px;}
	  	.layui-form-item{position: relative;}
	  	.layadmin-user-login-icon{position: absolute;left: 1px;top: 1px;width: 35px;line-height: 36px;text-align: center;color: #d2d2d2;}
	  </style>
	</head>
		<body>
		<div class="" style="margin:100px auto 0;width:340px;height:400px;">
			<form class="layui-form" method="post" onsubmit="return false">
				<div class="layui-form-item">
				    <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
				     <input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入账号" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
				    <input type="password" name="pwd" lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
				</div>
				<button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="form" >登录</button>
			</form>
		</div>
		
	</body>
	<script src="statics/layui/layui.all.js" type="text/javascript"></script>
	<script>
		layui.use(['form','jquery'],function(){
			var form = layui.form,$ = layui.jquery;
			
			//监听提交
			form.on('submit(form)', function(data){
			    $.ajax({
			    	url:'toLogin',
			    	data:data.field,
			    	type:'POST',
			    	dataType:'json',
			    	beforeSend:function(){
			    		layer.load();
			    	},
			    	success:function(data){
			    		if(data != null && data.status == 200){
			    			location.href = 'home';
			    		}else{
			    			layer.tips(data.msg,'[lay-filter="form"]', {
			    				  tips: [3, 'red'],
			    				  time: 2000
			    				});
			    		}
			    	},
			    	complete:function(){
			    		layer.closeAll('loading');
			    	}
			    });
			});
		})
		
	</script>
</html>