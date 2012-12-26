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
<script type="text/javascript">
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
				
				$("#map").dialog({
					autoOpen:false,
					modal:true,
					height:500,
					width:800,
					buttons: {
						OK: function() {
							$(this).dialog("close");
						}
					}
				});
				
				$("input:button").button();
				
				$( "#success-message" ).dialog({
					autoOpen: false,
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                    location.href="AdList.action";
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
				
				$("input#submit").click(function() {
					$.post(
						'CreateAd.action',
						$("form#form").serialize(),
						function(data, textStatus) {
							if(textStatus == "success") {
								$( "#success-message" ).dialog("open");
							}else {
								$( "#fail-message" ).dialog("open");
							}
						}
						
					);
				});
				
				$("input#save").click(function() {
					$.post(
						'CreateAdForDraft.action',
						$("form#form").serialize(),
						function(data, textStatus) {
							if(textStatus == "success") {
								$( "#success-message" ).dialog("open");
							}else {
								$( "#fail-message" ).dialog("open");
							}
						}
						
					);
				});
				
				
				$("input.map").click(function() {
					$("#map").dialog("open");
				});
			});
</script>
<script type="text/javascript">
		$(function() {
			$("#image").uploadify({
			'swf' : '<%=path%>/images/uploadify.swf',
			'cancelImg' : '<%=path%>/images/uploadify-cancel.png',
			'uploader' : 'UploadImage.action',
			'formData' : {'type' : 'banner'},
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
				'formData' : {'type' : 'content'},
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
			
			
			//初始化地图
			var map = new BMap.Map("map");
			var point = new BMap.Point(116.404, 39.915);  // 创建点坐标
			map.centerAndZoom(point, 11);
			map.enableScrollWheelZoom();
			// 添加地图控件
			map.addControl(new BMap.NavigationControl());  
			map.addControl(new BMap.ScaleControl());  
			map.addControl(new BMap.OverviewMapControl());  
			map.addControl(new BMap.MapTypeControl()); 
			
			function myFun(result) {
	 				var cityName = result.name;
				map.setCenter(cityName);
				}
			var myCity = new BMap.LocalCity();
			myCity.get(myFun);

			var marker1;
			map.addEventListener("click",function(e) {
				
				map.removeOverlay(marker1);
				marker1 = new BMap.Marker(new BMap.Point(e.point.lng , e.point.lat));  // 创建标注
				var tMarker = marker1;
				map.addOverlay(tMarker);
				
				// 记录经纬度
				$("input#lng").attr("value", e.point.lng); 
				$("input#lat").attr("value", e.point.lat);
			});
			
			
		});
		
</script>
<script type="text/javascript" src="js/smooth.form.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>

<title>AdsDeliver New Advertisement</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/left_nav.jsp" %>
		
		<!-- 对话框 -->
		<div id="success-message" title="投放广告成功">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			恭喜你，你的操作已经成功！
    		</p>
		</div>
		<div id="fail-message" title="投放失败">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			对不起，你的操作没有成功，请重试！
    		</p>
		</div>
		
		<div id="map" title="Baidu Map" style="width:500px;height:250px;"></div>
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
									<input type="text" id="name" name="name" class="small error" />
									<span class="error" style="height:15px;">请输入一个有助于你识别该广告的名称!</span>
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
									<label for="address">地理信息:</label>
								</div>
								<div class="input">
									<input type="text" id="lng" name="longitude"  />
									<input type="text" id="lat" name="latitude"  />
									<div class="button highlight">
										<input type="button" name="submit" value="从地图标注" class="map" />
									</div>
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
									<label for="bannerPic">广告Banner图片:</label>
								</div>
								<div class="chooseFile">
									<input type="text" id="bannerPic" name="bannerPic" style="height:23px;width:30%;"/>
									<input type="file" name="image" id="image"/>
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
								<div class="chooseFile">
									<input type="text" id="contentPic" name="contentPic" style="height: 23px;width: 30%;"/>
									<input type="file" name="contentImage" id="contentImage" size="40" />
								</div>
							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">广告文字内容:</label>
								</div>
								<div class="textarea textarea-editor">
									<textarea id="textarea" name="contents" rows="12" cols="50" class="editor"></textarea>
								</div>
							</div>
							
							<div class="buttons">
								<input type="button" id="save" value="保存草稿" />
								<div class="highlight">
									<input type="button" id="submit" value="提交审核" />
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