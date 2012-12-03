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
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/tiny_mce/jquery.tinymce.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript" src="js/smooth.table.js"></script>
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
									<input type="text" id="title" name="title" class="small error" />
									<span class="error">请输入一个有助于你识别该广告的名称!</span>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="address">广告投放地址:</label>
								</div>
								<div class="input">
									<input type="text" id="address" name="address" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="bannerWordOne">广告Banner大标题:</label>
								</div>
								<div class="input">
									<input type="text" name="bannerWordOne" id="bannerWordOne" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="bannerWordTwo">广告Banner小标题:</label>
								</div>
								<div class="input">
									<input type="text" name="bannerWordTwo" id="bannerWordTwo" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="bannerPic">广告Banner图片上传:</label>
								</div>
								<div class="input input-file">
									<input type="file" id="bannerPic" name="bannerPic" size="40" />
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
									<label for="contentPic">广告内容图片上传:</label>
								</div>
								<div class="input input-file">
									<input type="file" id="contetPic" name="contentPic" size="40" />
								</div>
							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">广告文字内容:</label>
								</div>
								<div class="textarea textarea-editor">
									<textarea id="textarea" name="textarea" rows="12" cols="50" class="editor"></textarea>
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