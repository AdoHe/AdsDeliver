<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register To AdsDeliver</title>
</head>
<body>
	<!-- header -->
	<div id="header"></div>
	<div id="content">
		<div id="left"></div>
		<div id="right">
			<!-- forms -->
			<div class="box">
				<!-- box title -->
				<div class="title">
					<h5>注册</h5>
				</div>
				<!-- end box title -->
				<form id="form" action="" method="post">
					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="username">用户名</label>
								</div>
								<div class="input">
									<input type="text" name="username" id="username" class="small error" />
									<span class="error">This means a required field!</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="password">密码</label>
								</div>
								<div class="input">
									<input type="password" name="password" id="password" class="small error" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="passwordAck">确认密码</label>
								</div>
								<div class="input">
									<input type="password" name="passwordAck" id="passwordAck" class="small error" />
								</div>
							</div>
							<div class="field">
								<div class="label"></div>
								<div class="input"></div>
							</div>
							<div class="field">
								<div class="label"></div>
								<div class="input"></div>
							</div>
							<div class="field">
								<div class="label"></div>
								<div class="input"></div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>