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
<link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery.tinymce.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/tiny_mce.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.form.js"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		style_path = "css";
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#form").validationEngine({
			validationEventTriggers:"blur",  //触发的事件  validationEventTriggers:"keyup blur",
			inlineValidation: true,//是否即时验证，false为提交表单时验证,默认true
			success :  false,//为true时即使有不符合的也提交表单,false表示只有全部通过验证了才能提交表单,默认false
			promptPosition: "topRight",//提示所在的位置，topLeft, topRight, bottomLeft,  centerRight, bottomRight
			//failure : function() { alert("验证失败，请检查。");  }//验证失败时调用的函数
			//success : function() { $("#submit").attr("disabled", false); },//验证通过时调用的函数
			});
		
		
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
				<form id="form" action="Register.action" method="post">
					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="username">用户名：</label>
								</div>
								<div class="input">
									<input type="text" name="userName" id="username" class="validate[required,custom[noSpecialCaracters],length[0,100]] small error" />
									<span class="error">红色为必填项</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="password">密码：</label>
								</div>
								<div class="input">
									<input type="password" name="password" id="password" class="small error validate[required,length[6,20]] text-input" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="passwordAck">确认密码：</label>
								</div>
								<div class="input">
									<input type="password" name="passwordAck" id="passwordAck" class="small error validate[required,confirm[password]] text-input" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="realname">真实姓名：</label>
								</div>
								<div class="input">
									<input type="text" name="realName" id="realname" class="small error validate[required,length[0,50]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="company">公司：</label>
								</div>
								<div class="input">
									<input type="text" name="corperation" id="company" class="small error validate[required,length[0,50]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="mobile">手机号：</label>
								</div>
								<div class="input">
									<input type="text" name="mobilePhone" id="mobile" class="small validate[required,custom[mobilephone]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="telephone">固定电话：</label>
								</div>
								<div class="input">
									<input type="text" name="telePhone" id="telephone" class="small validate[required,custom[telephone]]"/>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="address">地址：</label>
								</div>
								<div class="input">
									<input type="text" name="address" id="address" class="small validate[required,length[0,50]]" />
								</div>
							</div>  
							<div class="buttons">
								<input type="submit" id="submit" value="Submit" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>