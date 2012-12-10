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
<link id="color" rel="stylesheet" type="text/css" href="css/green.css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/tiny_mce/jquery.tinymce.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		style_path = "css";
		
		$("input:button").button();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login_form").validationEngine({
			validationEventTriggers:"blur",  //触发的事件  validationEventTriggers:"keyup blur",
			inlineValidation: true,//是否即时验证，false为提交表单时验证,默认true
			success :  false,//为true时即使有不符合的也提交表单,false表示只有全部通过验证了才能提交表单,默认false
			promptPosition: "topRight",//提示所在的位置，topLeft, topRight, bottomLeft,  centerRight, bottomRight
			//failure : function() { alert("验证失败，请检查。");  }//验证失败时调用的函数
			//success : function() { $("#submit").attr("disabled", false); },//验证通过时调用的函数
			});
		
		
		$("div.messages").hide();	
		
		/* select styling */
    	$("select").selectmenu({
        	style: 'dropdown',
        	width: 190,
        	menuWidth: 190,
        	icons: [
		    	{ find: '.locked', icon: 'ui-icon-locked' },
		    	{ find: '.unlocked', icon: 'ui-icon-unlocked' },
		    	{ find: '.folder-open', icon: 'ui-icon-folder-open' }
	    		]
    		});
    		
		$("#signin").click(function() {
			// 检查是否为空
			if($("input#username").attr("value") == "") {
				return false;
			}
			if($("input#password").attr("value") == "") {
				return false;
			}
			// 先把错误提示隐藏			
			$("div.messages").hide();			
			// 登录请求
			$.post(
					"UserLogin!login.action",
					{
						loginname : $("input#username").attr("value"),
						password : $("input#password").attr("value"),
						remember : $("input#remember").attr("checked")
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
						<img src="images/error.png" alt="Error" height="32" />
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
								<label for="loginname">用户名:</label>
							</div>
							<div class="input">
								<input type="text" name="loginname" id="username" size="40" class="focus validate[required]" />
							</div>
						</div>
						<div class="field">
							<div class="label">
								<label for="password">密码:</label>
							</div>
							<div class="input">
								<input type="password" name="password" id="password" size="40" class="focus validate[required]" />
							</div>
						</div>
						<div class="field field-select">
							<div class="label">
								<label for="select">身份:</label>
							</div>
							<div class="select">
								<select id="select" name="select">
									<option value="1">管理员</option>
									<option value="2">广告商</option>
								</select>
							</div>
						</div>
						<div class="field">
							<div class="checkbox">
								<input type="checkbox" id="remember" name="remember" />
								<label for="remember">记住我</label>
							</div>
						</div>
						<div class="buttons">
							<input type="button" value="Sign in" id="signin"/>
						</div>
					</div>
					<!-- end fields -->
					<!-- links -->
					<div class="links">
						<a href="">忘记密码?</a>
					</div>
					<!-- end links -->
				</div>
			</form>
		</div>
	</div>
</body>
</html>