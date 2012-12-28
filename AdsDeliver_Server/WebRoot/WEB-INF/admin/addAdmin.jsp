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
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.form.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		style_path = "css";
		
		$("input:button").button();
		$("#date-picker").datepicker();
		
		$( "#success-message" ).dialog({
					autoOpen: false,
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                }
		            }
		        });
		        
		$( "#fail-message" ).dialog({
					autoOpen: false,
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                }
		            }
		        });
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#addAdmin").click(function() {
		});
	});
</script>
<title>AdsDeliver Add Administrator</title>
</head>
<body>
	<%@ include file="/admin/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/admin/left_nav.jsp" %>
		
		<!-- 对话框 -->
		<div id="success-message" title="添加成功">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			恭喜你,成功添加一位新的管理员!
    		</p>
		</div>
		<div id="fail-message" title="添加失败">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			对不起,你没有添加管理员的权限!
    		</p>
		</div>
		
		<!-- content/right -->
		<div id="right">
			<!-- forms -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>添加管理员</h5>
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
									<label for="name">管理员名称:</label>
								</div>
								<div class="input">
									<input type="text" name="name" id="name" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="password">密码:</label>
								</div>
								<div class="input">
									<input type="password" name="password" id="password" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="passwordAck">确认密码:</label>
								</div>
								<div class="input">
									<input type="password" name="passwordAck" id="passwordAck" class="small" />
								</div>
							</div>
							<div class="field field-select">
								<div class="label">
									<label for="select">等级:</label>
								</div>
								<div class="select">
									<select id="select" name="select">
										<option value="1">1</option>
										<option value="2">2</option>
									</select>
								</div>
							</div>
							<div class="button highlight">
								<input type="button" value="添加" name="add" id="addAdmin" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- end content/right -->
	</div>
	<!-- end content -->
</body>
</html>