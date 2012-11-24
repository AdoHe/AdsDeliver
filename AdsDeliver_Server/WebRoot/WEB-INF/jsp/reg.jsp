<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register To AdsDeliver</title>
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/reg.css" media="screen"/>
<link id="color" rel="stylesheet" type="text/css" href="css/brown.css" />
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/juqery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery.tinymce.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/tiny_mce.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.form.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		style_path = "css";
	});
</script>
</head>
<body>
	<div id="content">
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
									<label for="username">用户名：</label>
								</div>
								<div class="input">
									<input type="text" name="username" id="username" class="small error" />
									<span class="error">This means a required field!</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="password">密码：</label>
								</div>
								<div class="input">
									<input type="password" name="password" id="password" class="small error" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="passwordAck">确认密码：</label>
								</div>
								<div class="input">
									<input type="password" name="passwordAck" id="passwordAck" class="small error" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="realname">真实姓名：</label>
								</div>
								<div class="input">
									<input type="text" name="realname" id="realname" class="small error" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="company">公司：</label>
								</div>
								<div class="input">
									<input type="text" name="company" id="company" class="small error" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="mobile">手机号：</label>
								</div>
								<div class="input">
									<input type="text" name="mobile" id="mobile" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="telephone">固定电话：</label>
								</div>
								<div class="input">
									<input type="text" name="telephone" id="telephone" class="small"/>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="address">地址：</label>
								</div>
								<div class="input">
									<input type="text" name="address" id="address" class="small" />
								</div>
							</div>
							<div class="buttons">
								<input type="submit" value="Submit" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>