<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!-- Bootstrap Core CSS -->
<link href="statics/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="statics/css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="statics/css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="statics/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<!-- chart -->
<script src="statics/js/Chart.js"></script>
<!-- //chart -->
<!--animate-->
<link href="statics/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="statics/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!----webfonts--->
<!--<link href='http://fonts.useso.com/css?family=Cabin:400,400italic,500,500italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>-->
<!---//webfonts---> 
 <!-- Meters graphs -->
<script src="statics/js/jquery-1.10.2.min.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->
  </head>
  
  <body>
    <section>
			<div id="page-wrapper" class="sign-in-wrapper">
				<div class="graphs">
					<div class="sign-in-form">
						<div class="sign-in-form-top">
							<p><span>Sign In to</span> <a href="home">Admin</a></p>
						</div>
						<div class="signin">
							<div class="signin-rit">
								<span class="checkbox1">
									 <label class="checkbox"><input type="checkbox" name="checkbox" checked="">Forgot Password ?</label>
								</span>
								<p><a href="#">Click Here</a> </p>
								<div class="clearfix"> </div>
							</div>
							<form method="post" action="toLogin" id="dataInfo">
							<div class="log-input">
								<div class="log-input-left">
								   <input type="text" class="user" name="name" value="Yourname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email address:';}"/>
								</div>
								<span class="checkbox2">
									 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i></label>
								</span>
								<div class="clearfix"> </div>
							</div>
							<div class="log-input">
								<div class="log-input-left">
								   <input type="password" class="lock" name="pwd" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email address:';}"/>
								</div>
								<span class="checkbox2">
									 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i></label>
								</span>
								<div class="clearfix"> </div>
							</div>
							<input type="submit" value="Login to your account" id="loginBtn">
						</form>	 
						</div>
						<div class="new_people">
							<a href="sign-up.html">Register Now!</a>
						</div>
					</div>
				</div>
			</div>
	</section>
	
<script src="statics/js/jquery.nicescroll.js"></script>
<script src="statics/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="statics/js/bootstrap.min.js"></script>
   <script type="text/javascript">
   	window.onload = function(){
   		var dataInfo = document.getElementById('dataInfo');
   		dataInfo.onsubmit = function(){
   			return false;
   		};
   	};
   	$(function(){
   		$('#loginBtn').bind('click',function(){
   			$.ajax({
   				url:$('#loginBtn').parents('form').attr('action'),
   				data:$('#loginBtn').parents('form').serialize(),
   				type:'POST',
   				dataType:'json',
   				beforeSend:function(){
   					$('#loginBtn').popover('destroy');
   				},
   				success:function(data){
   					if(data.status == 200){
   						
   					}else{
   						$('#loginBtn').popover({
   							content:data.msg,
   							placement:'top'
   						});
   	   					$('#loginBtn').popover('show');
   					}
   				},
   				complete:function(){
   					setTimeout(function(){
   						$('#loginBtn').popover('destroy');
   					}, 2000);
   				}
   			});
   		});
   	});
   </script>
</body>
</html>
