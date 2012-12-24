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
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		style_path = "css";

		$("input:button").button();
		$("#date-picker").datepicker();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("input#check").click(function() {
		});
	});
</script>
<title>AdsDeliver New Advertisement</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/left_nav.jsp" %>
		<!-- content/right -->
		<div id="right">
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>广告审核</h5>
				</div>
				<!-- end box/title -->
				<form action="" method="post">
					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="title">广告标题:</label>
								</div>
								<div class="input" style="padding-left: 50px;">
									<span id="title" class="title">
										${ad.avName}
									</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="banner">广告banner部份:</label>
								</div>
								<div class="input" style="padding-left: 50px;">
									<img alt="pic" src="${ad.adverinfo.afBannerPic}" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="content">广告主体部份:</label>
								</div>
								<div class="input" style="padding-left: 50px;">
									<img alt="pic" src="${ad.adverinfo.afContentPic}" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="time">广告正式投放时间:</label>
								</div>
								<div class="input" style="padding-left: 50px;">
									<span id="title" class="title">
										${ad.avName}
									</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="time">广告显示次数:</label>
								</div>
								<div class="input" style="padding-left: 50px;">
									<span id="title" class="title">
										${ad.avClickTimes}
									</span>
								</div>
							</div>
							<div class="buttons">
								<div class="highlight">
									<input type="button" id="check" value="审核通过" style="margin-left:50px;"/>
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