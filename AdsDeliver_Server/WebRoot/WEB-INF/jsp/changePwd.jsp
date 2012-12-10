<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen"/>
<link id="color" rel="stylesheet" type="text/css" href="css/green.css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript" src="js/smooth.table.js"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
				
				$("input:submit").button();
				
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
<title>Ads Deliver Change Password</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/left_nav.jsp" %>
		<!-- content/right -->
		<div id="right">
			<!-- forms -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>修改用户密码</h5>
				</div>
				<!-- end box/title -->
				<form id="form" action="SaveUserPwd.action" method="post">
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="oldPwd">请输入你现在的密码:</label>
								</div>
								<div class="input">
									<input type="password" id="oldPwd" name="oldPwd" class="medium validate[required,length[6,20]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="newPwd">请输入新密码:</label>
								</div>
								<div class="input">
									<input type="password" id="newPwd" name="newPwd" class="medium validate[required,length[6,20]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="newPwdAck">请确认新密码:</label>
								</div>
								<div class="input">
									<input type="password" id="newPwdAck" name="newPwdAck" class="medium validate[required,confirm[newPwd]]" />
								</div>
							</div>
							<div class="buttons">
								<div class="highlight">
									<input type="submit" name="submit" value="完成" />
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<!-- end forms -->
		</div>
		<!-- end content/right -->
	</div>
	<!-- end content -->
</body>
</html>


