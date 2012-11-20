<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AdsDeliver Admin</title>
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
			<div class="form">
			<!-- fields -->
				<div class="fields">
				</div>
				<div class="fields">
				</div>
			</div>
		</div>
	</div>
	<s:form action="LoginIn" method="post">
		<s:textfield name="name" label="Name" required="true"></s:textfield>
		<s:password name="password" label="Password" required="true"></s:password>
		<s:submit value="Login"></s:submit>
	</s:form>
</body>
</html>