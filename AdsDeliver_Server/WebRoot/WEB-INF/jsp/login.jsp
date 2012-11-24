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
		
		$("input:submit").button();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#signin").click(function() {
			$.post(
					"UserLogin.action",
					//$("#login_form").serialize(),
					{
						loginname : "11",
						password : "111"
					},
					function(data, textStatus) {
						alert("111");
						if(data.result == 1) {
							//location.href = "";
							alert("success data:" + data);
						}else {
							// 登录失败
							alert("error data:" + data);
						}
					});
					
		});
	});
	
	$("#signin").click(function() {
		alert("11");
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