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
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
				
				$("input:button").button();
				
				$("div.messages").hide();
				
				$( "#success-message" ).dialog({
					autoOpen: false,
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                    location.href="AdminPriceInfoPage.action";
		                }
		            }
		        });
				
				$("#change").click(function() {
					if($("input#input").attr("value") == "")
					{
						$("div.messages").show();
						$("#errorMsg").html("请输入一个合适的banner单价");
						return false;
					}
					
					$.post(
							"AdminChaBanPri.action",
							{bannerPrice : $("input#input").attr("value")},
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
<title>AdsDeliver Change BannerPrice</title>
</head>
<body>
	<%@ include file="/admin/header.jsp" %>
	<!-- content -->
	<div id="content">
		<!-- content/left -->
		
		<!-- 对话框 -->
		<div id="success-message" title="修改成功">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			恭喜你，你的操作已经成功！
    		</p>
		</div>
		
		
		<%@ include file="/admin/left_nav.jsp" %>
		<!-- content/right -->
		<div id="right">
			<!-- forms -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>Banner单价设置</h5>
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
				
				<!-- end box/title -->
				<form id="form" action="" method="post">
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input">请输入合适的Banner单价:</label>
								</div>
								<div class="input">
									<input type="text" id="input" name="input" class="medium" />
									<div class="button highlight">
										<input type="button" value="确定" name="submit" id="change"/>
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