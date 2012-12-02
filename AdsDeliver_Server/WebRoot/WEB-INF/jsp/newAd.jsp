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
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript">
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
				
			});
</script>
<script type="text/javascript" src="js/smooth.form.js"></script>
<title>AdsDeliver New Advertisement</title>
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
					<h5>广告制作</h5>
				</div>
				<!-- end box/title -->
				<form id="form" action="" method="post">
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="title">广告名称:</label>
								</div>
								<div class="input">
									<input type="text" id="title" name="title" class="medium error" />
									<span class="error">This means a required field!</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="address">广告投放地址:</label>
								</div>
								<div class="input">
									<input type="text" id="address" name="address" class="medium error" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="time">广告开始时间:</label>
								</div>
								<div class="input">
									<input type="text" id="time" name="time" class="date" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="banner">广告Banner制作:</label>
								</div>
								<div class="input">
									<span class="error">请选择你喜欢的Banner模板！</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="select">广告内容模板选择:</label>
								</div>
								<div class="select">
									<select id="select" name="select">
										<option value="1">图文模板</option>
									</select>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="edition">排版方式:</label>
								</div>
								<div class="select">
									<select id="edition" name="edition">
										<option value="1">上图下文</option>
										<option value="2">左图右文</option>
										<option value="3">右图左文</option>
									</select>
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