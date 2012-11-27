<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login To AdsDeliver</title>
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen"/>
<link id="color" rel="stylesheet" type="text/css" href="css/brown.css" />
<!-- scripts -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		style_path = "css";
		
		$("input:button").button();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("div.messages").hide();	
		
		$("#signin").click(function() {
			// 先把错误提示隐藏
			$("div.messages").hide();			
			// 登录请求
			$.post(
					"UserLogin!login.action",
					{
						loginname : $("input#username").attr("value"),
						password : $("input#password").attr("value")
					},
					function(data, textStatus) {
						
						if(data.result == 1) {
							location.href = "UserIndex.action";
						}else if(data.result == 2){
							$("div.messages").show();
							$("#errorMsg").html("密码错误");
						}else if(data.result == 3) {
							$("div.messages").show();
							$("#errorMsg").html("用户名不存在");
						}
					});
					
		});

		
	});
</script>
</head>
<body>
	<div id="login">
		<!-- login -->
		<div class="title">
			<h5>Sign In To AdsDeliver</h5>
			<div class="corner tl"></div>
			<div class="corner tr"></div>
		</div>
		<div class="messages">
				<div id="message-error" class="message message-error">
					<div class="image">
						<img src="resources/images/icons/error.png" alt="Error" height="32" />
					</div>
					<div class="text">
						<h6>Error Message</h6>
						<span id="errorMsg"></span>
					</div>
					<div class="dismiss">
						<a href="#message-error"></a>
					</div>
				</div>
			</div>
				
		<div class="inner">
			<form id="login_form" method="post">
				<div class="form">
					<!-- fields -->
					<div class="fields">
						<div class="field">
							<div class="label">
								<label for="loginname">Username:</label>
							</div>
							<div class="input">
								<input type="text" name="loginname" id="username" size="40" class="focus" />
							</div>
						</div>
						<div class="field">
							<div class="label">
								<label for="password">Password:</label>
							</div>
							<div class="input">
								<input type="password" name="password" id="password" size="40" class="focus" />
							</div>
						</div>
						<div class="field">
							<div class="checkbox">
								<input type="checkbox" id="remember" name="remember" />
								<label for="remember">Remember me</label>
							</div>
						</div>
						<div class="buttons">
							<input type="button" value="Sign in" id="signin"/>
						</div>
					</div>
					<!-- end fields -->
					<!-- links -->
					<div class="links">
						<a href="">Forget your passwords?</a>
					</div>
					<!-- end links -->
				</div>
			</form>
		</div>
	</div>
</body>
</html>