<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/records.css" media="screen"/>
<link id="color" rel="stylesheet" type="text/css" href="css/brown.css" />
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.tinymce.js"></script>
<script type="text/javascript" src="js/tiny_mce.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript" src="js/smooth.autocomplete.js"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
			});
</script>
<title>AdsDeliver Account Records</title>
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
						<li><a href="">查看交易记录</a></li>
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
		<div id="left">
			<div id="menu">
				<h6 id="h-menu-products" class="selected"><a href="#"><span>广告</span></a></h6>
				<ul id="menu-products" class="opened">
					<li><a href="#">投放广告</a></li>
					<li><a href="#">查看广告</a></li>
					<li class="last"><a href="">撤销广告</a></li>
				</ul>
				<h6 id="h-menu-events" class="selected"><a href="#"><span>账户</span></a></h6>
				<ul id="menu-events" class="opened">
					<li><a href="#">查看账户余额</a></li>
					<li><a href="#">查看交易记录</a></li>
					<li class="last"><a href="#">账户充值</a></li>
				</ul>
				<h6 id="h-menu-settings" class="selected"><a href="#"><span>设置</span></a></h6>
				<ul id="menu-settings" class="opened">
					<li><a href="#">账户设置</a></li>
					<li class="last"><a href="#">广告设置</a></li>
				</ul>
			</div>
			<div id="date-picker"></div>
		</div>
		<!-- end content/left -->
		<!-- content/right -->
		<div id="right">
			<!-- table -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>你的账户:</h5>
				</div>
				<!-- end box/title -->
				<div class="table">
					<form action="" method="post">
						<table>
							<thead>
								<tr>
									<th class="left">交易时间</th>
									<th>收入金额</th>
									<th>支出金额</th>
									<th>当前余额</th>
									<th class="last">交易类别</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="title">2012-12-12 12:12:12</td>
									<td class="price">1000</td>
									<td class="price">1000</td>
									<td class="date">2000</td>
									<td class="category">银行转账</td>
								</tr>
								<tr>
									<td class="title">2012-12-12 12:12:12</td>
									<td class="price">1000</td>
									<td class="price">1000</td>
									<td class="date">2000</td>
									<td class="category">银行转账</td>
								</tr>
								<tr>
									<td class="title">2012-12-12 12:12:12</td>
									<td class="price">1000</td>
									<td class="price">1000</td>
									<td class="date">2000</td>
									<td class="category">银行转账</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
		<!-- end content/right -->
	</div>
	<!-- end content -->
</body>
</html>