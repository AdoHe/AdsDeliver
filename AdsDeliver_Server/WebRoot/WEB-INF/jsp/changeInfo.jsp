<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen"/>
<link id="color" rel="stylesheet" type="text/css" href="css/brown.css" />
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
				$("input:reset").button();
				
				$("#form").validationEngine({
					validationEventTriggers:"blur", 
					inlineValidation: true,
					success :  false,
					promptPosition: "topRight",
					});
				
			});
</script>
<script type="text/javascript">
			$(document).ready(function () {
				$.get(
						"GetUserInfo.action",		
						function(data, textStatus) {
							if(textStatus == "success") {
								//设置页面的数据
								
								$("input#userName").attr("value", data.userName);
								$("input#realName").attr("value", data.realName);
								$("input#company").attr("value", data.corperation);
								$("input#mobile").attr("value", data.mobilePhone);
								$("input#telephone").attr("value", data.telePhone);
								$("input#address").attr("value", data.address);
							}
						}
					);
				
			});
</script>
<title>Ads Deliver Change UserInfo</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/right_nav.jsp" %>
		<!-- content/right -->
		<div id="right">
			<!-- forms -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>修改个人资料</h5>
				</div>
				<!-- end box/title -->
				<form id="form" action="SaveUserInfo.action" method="post">
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="userName">用户名:</label>
								</div>
								<div class="input">
									<input type="text" id="userName"  class="medium" readonly="true"/>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="realName">真实姓名:</label>
								</div>
								<div class="input">
									<input type="text" id="realName" name="realName" class="medium validate[required,length[0,50]]"/>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="company">公司:</label>
								</div>
								<div class="input">
									<input type="text" id="company" name="company" class="medium validate[required,length[0,50]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="mobile">手机号:</label>
								</div>
								<div class="input">
									<input type="text" id="mobile" name="mobilePhone" class="medium validate[required,custom[mobilephone]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="telephone">固定电话:</label>
								</div>
								<div class="input">
									<input type="text" id="telephone" name="telePhone" class="medium validate[required,custom[telephone]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="address">地址:</label>
								</div>
								<div class="input">
									<input type="text" id="address" name="address" class="medium validate[required,length[0,50]]" />
								</div>
							</div>
							<div class="buttons">
								<div class="highlight">
									<input type="submit" name="submit" value="保存修改" />
								</div>
								<!-- input type="reset" name="reset" value="取消" / -->
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

