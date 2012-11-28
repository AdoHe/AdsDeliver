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
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript" src="js/smooth.form.js"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				//$("#date-picker").datepicker();
				
				//$("input:button").button();
				
				$( "#success-message" ).dialog({
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                }
		            }
		        });
				
				$("#recharge").click(function() {
					alert("");
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
	<!-- header -->
	<div id="header">
		<!-- logo -->
		<div id="logo">
			<h1><a href="" title="SmoothAdmin"><img src="images/logo.png" alt="Smooth Adimn" /></a></h1>
		</div>
		<!-- end logo -->
		<!-- user -->
		<ul id="user">
			<li class="first"><a href="">账户</a></li>
			<li><a href="">注销</a></li>
			<li class="highlight last"><a href="">回到首页</a></li>
		</ul>
		<!-- end user -->
		<div id="header-inner">
			<div id="home">
				<a href="" title="Home"></a>
			</div>
			<!-- quick -->
			<ul id="quick">
				<li>
					<a href="" title="广告"><span class="icon"><img src="images/application_double.png" alt="广告" /></span>
					<span>广告管理</span></a>
					<ul>
						<li><a href="#">投放广告</a></li>
						<li><a href="#">查看广告</a></li>
						<li class="last"><a href="#">撤销广告</a></li>
					</ul>
				</li>
				<li>
					<a href="#" title="账户"><span class="icon"><img src="images/calendar.png" alt="账户" /></span>
					<span>账户管理</span></a>
					<ul>
						<li><a href="#">查看账户余额</a></li>
						<li class="last"><a href="#">账户充值</a></li>
					</ul>
				</li>
				<li>
					<a href="#" title="设置"><span class="icon"><img src="images/cog.png" alt="设置" /></span>
					<span>常用设置</span></a>
					<ul>
						<li><a href="#">账户设置</a></li>
						<li class="last"><a href="#">广告设置</a></li>
					</ul>
				</li>
			</ul>
			<!-- end quick -->
			<div class="corner tl"></div>
			<div class="corner tr"></div>
		</div>
	</div>
	<!-- end header -->
	<!-- content -->
	<div id="content">
		<!-- content/left -->
		
		<!-- 对话框 -->
		<div id="success-message" title="充值成功">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			Your files have downloaded successfully into the My Downloads folder.
    		</p>
    		<p>
       			Currently using <b>36% of your storage space</b>.
    		</p>
		</div>
		
		
		<div id="left">
			<div id="menu">
				<h6 id="h-menu-ads" class="selected"><a href="#ads"><span>广告</span></a></h6>
				<ul id="menu-ads" class="opened">
					<li><a href="#">投放广告</a></li>
					<li><a href="#">查看广告</a></li>
					<li class="last"><a href="">撤销广告</a></li>
				</ul>
				<h6 id="h-menu-accounts"><a href="#accounts"><span>账户</span></a></h6>
				<ul id="menu-accounts" class="closed">
					<li><a href="#">查看账户余额</a></li>
					<li class="last"><a href="#">账户充值</a></li>
				</ul>
				<h6 id="h-menu-settings"><a href="#settings"><span>设置</span></a></h6>
				<ul id="menu-settings" class="closed">
					<li><a href="#">账户设置</a></li>
					<li class="last"><a href="#">广告设置</a></li>
				</ul>
			</div>
			<div id="date-picker"></div>
		</div>
		<!-- end content/left -->
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
									<input type="text" id="input" name="input" class="small" />
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