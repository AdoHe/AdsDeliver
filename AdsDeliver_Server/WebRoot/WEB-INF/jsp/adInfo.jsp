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
<script type="text/javascript" src="js/jQuery.textSlider.js"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
				
				$("#scrollDiv").textSlider({line: 1, speed: 800, timer: 3000});
			});
</script>
<style type="text/css">
.up{ margin-left:310px; width:50px; height:50px; background:#F90}
.down{ margin:0 0 0 310px; zoom:1; width:50px; height:50px; background:#960}
</style>

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
					<h5>广告详情</h5>
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
								<div style="padding-left: 250px;">
									<div class="ban" style="background: url(./images/banner_background.jpg) no-repeat; height: 44px;">
										<img alt="bannerPic" src="${ad.adverinfo.afBannerPic}" style="padding: 7px 0 0 7px; float:left; width: 32px; height: 32px;">
										<div id="scrollDiv" style="overflow: auto;">
											<div id="scroll" style="padding: 5px 0 0 20px; height: 25px; line-height: 25px; overflow: hidden;">
												<ul class="list">
													<li style="padding-left: 14px; height: 25px; font-size: 15px;">${ad.adverinfo.afBannerWordOne}</li>
													<li style="padding-left: 14px; height: 25px; font-size: 15px;">${ad.adverinfo.afBannerWordTwo}</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="content">广告主体部份:</label>
								</div>
								<div style="padding-left: 250px;">
									<div class="con" style="background: url(./images/content_background.png) no-repeat; 
									padding:20px 0 0 20px; height: 480px;">
										<img alt="contentPic" src="${ad.adverinfo.afContentPic}" style="width:200px; height: 200px;">
										<div class="cont" style="margin-top: 20px;">
											<span style="font-size: 18px;">
												${ad.adverinfo.afContents}
											</span>
										</div> 
									</div>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="time">广告投放地点:</label>
								</div>
								<div class="input" style="padding-left: 50px;">
									<span id="title" class="title">
										${ad.avAddress}
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