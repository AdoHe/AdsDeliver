<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/jpagenation-style.css" />
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
<script type="text/javascript" src="js/smooth.table.js"></script>
<script type="text/javascript" src="js/jquery.paginate.js"></script>
<script type="text/javascript">
		$(document).ready(function () {
			style_path = "css";

			$("#date-picker").datepicker();
			$("input:submit").button();
			$("div.messages").hide();
		});
</script>
<script type="text/javascript">
		$(document).ready(function() {
			var adCount;
			$.get("GetPagedAdsForActive.action",
					{
						start : 0,
						length : 10
					},
					function(data, textStatus) {
						if(textStatus == "success")
						{
							adCount = data.active_count;
							var ad = data.pAds;
							
							if(adCount != 0)
							{
								$.each(ad, function(index, a) {
									var tbody = "";
									
									tbody += "<tr><td class='title'>" + a.avName + "</td>"
									+ "<td class='price'>" + a.avClickTimes + "</td>"
									+ "<td class='date'>" + a.avPublishTime.replace("T", "  ") + "</td>"
									+ "<td class='date'>" + a.avAddress + "</td>"
									+ "<td class='selected last'><input type='checkbox'/></td></tr>";
									
									$("#table_body").append(tbody);
								});
							}else
							{
								$("div.messages").show();
								$("div.table").hide();
							}
							
							//初始化分页组件
							$("#picpagenate").paginate({ 
					            count         : ((adCount % 10 == 0) ? parseInt(adCount / 10) :  parseInt(adCount / 10) + 1), 
					            start         : 1, 
					            display     : 6, 
					            border                    : false, 
					            text_color              : '#79B5E3', 
					            background_color        : 'none',     
					            text_hover_color          : '#2573AF', 
					            background_hover_color    : 'none',  
					            images                    : false, 
					            mouse                    : 'press',  
					            onChange                 : function(page){
					                                            $.post(
					                                               "GetPagedAdsForActive.action",
					                                               {
					                                                   start: (page-1) * 10,
					                                                   length: 10
					                                               },
					                                               function(data, textStatus){
					                                            	   
					                                                   if(textStatus == "success") {  
					                                                        $("#table_body").empty();
					                                                        
					                                                        var ad = data.aAds;
					                                        				
					                                        				$.each(ad, function(index, a) {
					                                        					var tbody = "";
					                                        					tbody += "<tr><td class='title'>" + a.avName + "</td>"
					                        									+ "<td class=\"price\">" + a.avClickTimes + "</td>"
					                        									+ "<td class='date'>" + a.avPublishTime.replace("T", "  ") + "</td>"
					                        									+ "<td class='date'>" + a.avAddress + "</td>"
					                        									+ "<td class='selected last'><input type='checkbox'/></td></tr>";
					                    										
					                    										$("#table_body").append(tbody);
					                                        				});
					                                                   }
					                                               }
					                                            );
					                                        } 
					            });
						}
					});
		});
</script>
<title>AdsDeliver User Page</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/left_nav.jsp" %>
		<!-- content/right -->
		<div id="right">
			<!-- table -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>广告列表</h5>
					<div class="search">
						<form action="#" method="post">
							<div class="input">
								<input type="text" id="search" name="search" />
							</div>
							<div class="button">
								<input type="submit" name="submit" value="搜索" />
							</div>
						</form>
					</div>
				</div>
				<!-- end box/title -->
				<!-- notice message -->
				<div class="messages">
					<div id="message-notice" class="message message-notice">
						<div class="image">
							<img src="images/notice.png" alt="Notice" height="32" />
						</div>
						<div class="text">
							<h6>Notice Message</h6>
							<span>你还没有投放任何广告哦.</span>
						</div>
						<div class="dismiss">
							<a href="#message-notice"></a>
						</div>
					</div>
					<div class="links" style="height:15px;">
						<a href="">Do you want to deliver an advertisement now?</a>
					</div>
				</div>
				<!-- end notice message -->
				<div class="table">
					<form action="" method="post">
						<table>
							<thead>
								<tr>
									<th class="left">广告名称</th>
									<th>广告价格</th>
									<th>投放时间</th>
									<th>投放地点</th>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
								</tr>
							</thead>
							<tbody id="table_body">
							</tbody>
						</table>
						<div id="picpagenate"></div>
					</form>
				</div>
			</div>
		</div>
		<!-- end content/right -->
	</div>
	<!-- end content -->
</body>
</html>