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
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
				
				$("input:button").button();
				
				$("#form").validationEngine({
					validationEventTriggers:"blur",
					inlineValidation:true,
					success:false,
					promptPosition:"topRight"
				});
				
				$( "#success-message" ).dialog({
					autoOpen: false,
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                    location.href="UserAccount.action";
		                }
		            }
		        });
				
				$("#recharge").click(function() {
					$.post(
							"GetBalance!recharge.action",
							{rechargeAmount : $("input#input").attr("value")},
							function(data, textStatus) {
								if(textStatus == "success") {
									$( "#success-message" ).dialog("open");
								}else {
									
								}
							}
						);
				});
				
			});
</script>
<title>Ads Deliver Account Recharge</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<!-- content/left -->
		
		<!-- 对话框 -->
		<div id="success-message" title="充值成功">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			恭喜你，你的充值操作已经成功！
    		</p>
		</div>
		
		
		<%@ include file="/jsp/left_nav.jsp" %>
		<!-- content/right -->
		<div id="right">
			<!-- forms -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>账户充值</h5>
				</div>
				<!-- end box/title -->
				<form id="form" action="" method="post">
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input">请输入你要充值的数目:</label>
								</div>
								<div class="input">
									<input type="text" id="input" name="input" class="medium validate[required,min[1],max[1000]]" />
									<div class="button highlight">
										<input type="button" value="充值" name="submit" id="recharge"/>
									</div>
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