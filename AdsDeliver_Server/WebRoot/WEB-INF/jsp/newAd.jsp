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
<link id="color" rel="stylesheet" type="text/css" href="css/brown.css" />
<link rel="stylesheet" type="text/css" href="css/uploadify.css" />
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
				
				
				
				$("input:button").click(function() {
					$("#map").dialog("open");
				});
			});
</script>
<script type="text/javascript">
		$(function() {
			$("#bannerPic").uploadify({
			'swf' : '<%=path%>/images/uploadify.swf',
			'cancelImg' : '<%=path%>/images/uploadify-cancel.png',
			'uploader' : '',
			'method' : 'post',
			'fileObjName' : 'bannerPic',
			'auto' : false,
			'multi' : false,
			'fileTypeDesc' : '支持图片格式/png/jpg/jpeg/bmp/gif',
			'fileTypeExts' : '*.png;*.jpg;*.jpeg;*.bmp;*.gif'
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
									<input type="file" name="bannerPic" id="bannerPic" size="40" />
									<a href="javascript:$('bannerPic').uploadify('upload','*')" ><input type="button" value="submit" /></a>
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