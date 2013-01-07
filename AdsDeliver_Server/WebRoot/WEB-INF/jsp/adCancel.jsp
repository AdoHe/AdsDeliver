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
<link id="color" rel="stylesheet" type="text/css" href="css/green.css" />
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
				$("input:button").button();
				$("input:submit").button();
				$("div.messages").hide();
				
				$("#success-message").dialog({
					autoOpen: false,
		            modal: true,
		            buttons: {
		                Ok: function() {
		                    $( this ).dialog( "close" );
		                }
		            }
		        });
		        
				$("input#cancel").click(function() {
					var str = "";
					
					if($("input.checkall").attr("checked"))
					{
						$("input.check").each(function() {
							str += $(this).val() + ",";
						});
						alert(str);
					}else
					{
						$("input.check").each(function() {
							if($(this).attr("checked"))
							{
								str += $(this).val() + ",";
							}
						});
					}
					
					if(str != "")
					{
						$.post(
							"CancelAds.action",
							{
								str : str
							},
							function(data, textStatus) {
								if(textStatus == "success")
								{
									location.href = "AdCancel.action";
								}
							});
					}else
					{
						$("#success-message").dialog("open");
					}
				});
			});
</script>
<script type="text/javascript">
			$(document).ready(function() {
				var adCount;
				$.get("GetPagedAdsForCancel.action",
						{
							start : 0,
							length : 10,
						},
						function(data, textStatus) {
							if(textStatus == "success")
							{
								adCount = data.all_count;
								var ad = data.aAds;
								
								if(adCount != 0)
								{
									$.each(ad, function(index, a) {
										
										var tbody = "";
										tbody += "<tr><td class='name'>" + a.avName + "</td>"
										+ "<td class='time'>" + a.avPublishTime.replace("T","  ") + "</td>"
										+ "<td class='address'>" + a.avAddress + "</td>"
										+ "<td class='status'>" + (a.avStatus > 1 ? "是" : "否") + "</td>"
										+ "<td class='selected last'><input type='checkbox' class='check' value='" + a.id + "'/>"+ "</td>" + "</tr>";
										
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
						                                               "GetPagedAdsForCancel.action",
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
						                    										tbody += "<tr><td class='name'>" + a.avName + "</td>"
																					+ "<td class='time'>" + a.avPublishTime.replace("T","  ") + "</td>"
																					+ "<td class='address'>" + a.avAddress + "</td>"
																					+ "<td class='status'>" + (a.avStatus > 1 ? "是" : "否") + "</td>"
																					+ "<td class='selected last'><input type='checkbox' class='check' value='"+ a.id +　"'/></td>" + "</tr>";
						                    										
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
<script type="text/javascript" src="js/smooth.form.js"></script>
<title>AdsDeliver Ads List</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/left_nav.jsp" %>
		
		<!-- 对话框 -->
		<div id="success-message" title="提醒">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			你还没有选中任何广告哦!。
    		</p>
		</div>
		
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
							<span>你还没有正在运行中的广告哦.</span>
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
									<th>广告名称</th>
									<th>投放时间</th>
									<th>投放地点</th>
									<th>状态</th>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
								</tr>
							</thead>
							<tbody id="table_body">
							</tbody>
						</table>
						<div id="picpagenate"></div>
						<!-- table/action -->
						<div class="action">
							<select name="action">
								<option value="" class="unlocked">撤销广告</option>
							</select>
							<div class="button">
								<input type="button" name="submit" id="cancel" value="Apply to selected" />
							</div>
						</div>
						<!-- end table/action -->
					</form>
				</div>
			</div>
		</div>
		<!-- end content/right -->
	</div>
	<!-- end content -->
</body>
</html>