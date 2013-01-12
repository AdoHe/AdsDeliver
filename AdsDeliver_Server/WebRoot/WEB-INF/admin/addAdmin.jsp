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
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		style_path = "css";
		
		$("input:button").button();
		$("#date-picker").datepicker();
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
    		
		$( "#success-message" ).dialog({
					autoOpen: false,
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                    location.href="";
		                }
		            }
		        });
		
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#addAdmin").click(function() {
			if($("input#name").attr("value")=="")
			{
				return false;
			}
			if($("input#password").attr("value")=="")
			{
				return false;
			}
			
			$.post(
					"AdminAdd.action",
					{
						name : $("input#name").attr("value"),
						password : $("input#password").attr("value"),
						level : $("#select").val()
					},
					function(data, textStatus) {
						if(textStatus == "success")
						{
							if(data.result == 1)
							{
								$("#success-message").dialog("open");
							}else if(data.result == 3)
							{
								$("div.messages").show();
								$("#errorMsg").html("对不起，你没有添加管理员的权限!");
							}else
							{
								$("div.messages").show();
								$("#errorMsg").html("对不起，该管理员已经存在!");
							}
						}
					});
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
									<input type="text" name="name" id="name" class="medium validate[required,custom[noSpecialCaracters],length[0,100]]" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="password">密码:</label>
								</div>
								<div class="input">
									<input type="password" name="password" id="password" class="medium validate[required,length[5,20]] text-input" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="passwordAck">确认密码:</label>
								</div>
								<div class="input">
									<input type="password" name="passwordAck" id="passwordAck" class="medium validate[required,confirm[password]] text-input" />
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
							<div class="buttons">
								<div class="highlight">
									<input type="button" value="添加" name="add" id="addAdmin" style="width: 80px;"/>
								</div>
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