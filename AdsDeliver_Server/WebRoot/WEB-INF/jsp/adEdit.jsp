<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen"/>
<link id="color" rel="stylesheet" type="text/css" href="css/green.css" />
<link rel="stylesheet" type="text/css" href="css/uploadify.css" />
<style type="text/css">
.uploadify-button
{
	background-color: transparent;
	border: none;
	padding: 0;
}
.uploadify:hover .uploadify-button
{
	background-color: transparent;
}
</style>
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="js/jquery.uploadify.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript" src="js/smooth.table.js"></script>
<script type="text/javascript" src="js/smooth.form.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		style_path = "css";
		$("#date-picker").datepicker();
		$("input:button").button();
		
		$("#success-message").dialog({
			autoOpen : false,
			modal : true,
			buttons : {
				OK : function() {
					$(this).dialog("close");
				}
			}
		});
		
		$("#fail-message").dialog({
			autoOpen : false,
			modal : true,
			buttons : {
				OK : function() {
					$(this).dialog("close");
				}
			}
		});
		
		$("input#save").click(function() {
			$.post(
				'SaveAdInfo.action',
				$("form#form").serialize(),
				function(data, textStatus) {
					if(textStatus == "success")
					{
						$("#success-message").dialog("open");
					}else
					{
						$("#fail-message").dialog("open");
					}
				}
			);
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#image").uploadify({
			'swf' : '<%=path%>/images/uploadify.swf',
			'cancelImg' : '<%=path%>/images/uploadify-cancel.png',
			'uploader' : 'UploadImage.action',
			'method' : 'post',
			'fileObjName' : 'image',
			'buttonText'     : '选择图片',
			'auto' : true,
			'multi' : false,
			'height' : 28,
			'width' : 92,
			'fileTypeDesc' : '支持图片格式/png/jpg/jpeg/bmp/gif',
			'fileTypeExts' : '*.png;*.jpg;*.jpeg;*.bmp;*.gif',
			'onUploadSuccess'    : function(file, data, response) { 
                   var result = eval("(" + data + ")");  
                   $("#bannerPic").attr("value", result.imageFilePath);
	         }
			
			});
			
			$("#contentImage").uploadify({
				'swf' : '<%=path%>/images/uploadify.swf',
				'cancelImg' : '<%=path%> /images/uploadify-cancel.png',
				'uploader' : 'UploadImage.action',
				'method' : 'post',
				'fileObjName' : 'image',
				'buttonText'     : '选择图片',
				'auto' : true,
				'multi' : false,
				'height' : 28,
				'width' : 92,
				'fileTypeDesc' : '支持图片格式/png/jpg/jpeg/bmp/gif',
				'fileTypeExts' : '*.png;*.jpg;*.jpeg;*.bmp;*.gif',
				'onUploadSuccess'    : function(file, data, response) { 
						var result = eval("(" + data + ")");  
	                   $("#contentPic").attr("value", result.imageFilePath);
		         }
				});
	});
</script>

<title>AdsDeliver Edit Advertisement</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/left_nav.jsp" %>
		
		<!-- dialog -->
		<div id="success-message" title="编辑成功">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			恭喜你，你的操作已经成功！
    		</p>
		</div>
		<div id="fail-message" title="编辑失败">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			对不起，你的操作没有成功，请重试！
    		</p>
		</div>
		
		<!-- content/right -->
		<div id="right">
			<!-- forms -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>广告编辑</h5>
				</div>
				<!-- end box/title -->
				<form id="form" action="" method="post">
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="bannerTitleOne">广告Banner大标题:</label>
								</div>
								<div class="input">
									<input type="text" id="bannerTitleOne" name="bannerTitleOne" value="${bannerTitleOne}" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="bannerTitleTwo">广告Banner小标题:</label>
								</div>
								<div class="input">
									<input type="text" name="bannerTitleTwo" id="bannerTitleTwo" value="${bannerTitleTwo}" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="bannerPic">广告Banner图片:</label>
								</div>
								<div class="chooseFile">
									<input type="text" id="bannerPic" name="bannerPic" value="${bannerPic}" style="height:23px;width:33%;"/>
									<input type="file" name="image" id="image"/>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="contentPic">广告内容图片:</label>
								</div>
								<div class="chooseFile">
									<input type="text" id="contentPic" name="contentPic" value="${contentPic}" style="height: 23px;width: 33%;"/>
									<input type="file" name="contentImage" id="contentImage" size="40" />
								</div>
							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">广告文字内容:</label>
								</div>
								<div class="textarea textarea-editor">
									<textarea id="textarea" name="content" rows="12" cols="50" class="editor">${content}</textarea>
								</div>
							</div>
							
							<div class="buttons">
								<div class="highlight">
									<input type="button" id="save" value="保存修改" />
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>