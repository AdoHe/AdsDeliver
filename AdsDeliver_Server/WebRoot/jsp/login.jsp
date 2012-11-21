<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AdsDeliver Admin</title>
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/colors/brown.css" />
<!-- scripts -->
<script type="text/javascript" src="/WebRoot/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="/WebRoot/js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="/WebRoot/js/smooth.js"></script>
</head>
<body>
	<div id="login">
		<!-- login -->
		<div class="title">
			<h5>Sign In to AdsDeliver</h5>
			<div class="corner tl"></div>
			<div class="corner tr"></div>
		</div>
		<div class="inner">
			<form action="LoginIn.action" method="post">
				<div class="form">
					<!-- fields -->
					<div class="fields">
						<div class="field">
							<div class="label">
								<label for="name">Username:</label>
							</div>
							<div class="input">
								<input type="text" name="name" id="username" size="40" class="focus" />
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
								<label for="remember">Remember me!</label>
							</div>
						</div>
						<div class="buttons">
							<input type="submit" value="Sign in" />
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