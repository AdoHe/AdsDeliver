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
	$(document).ready(function() {
		style_path = "css";
		
		$("#date-picker").datepicker();
		$("input:button").button();
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
							"CancelAdmin.action",
							{
								str : str
							},
							function(data, textStatus) {
								if(textStatus == "success")
								{
									location.href = "AdminCancelPage.action";
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
				$.get("AdminCancel.action",
						{
							start : 0,
							length : 10,
						},
						function(data, textStatus) {
							if(textStatus == "success")
							{
								adCount = data.count;
								var ad = data.admins;
								
								if(adCount != 0)
								{
									$.each(ad, function(index, a) {
										
										var tbody = "";
										tbody += "<tr><td class='name'>" + a.id + "</td>"
										+ "<td class='time'>" + a.adName + "</td>"
										+ "<td class='address'>" + a.adLevel + "</td>"
										+ "<td class='selected last'><input type='checkbox' class='check' value='" + a.id + "'/></td>" + "</tr>";
										
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
						                                               "AdminCancel.action",
						                                               {
						                                                   start: (page-1) * 10,
						                                                   length: 10
						                                               },
						                                               function(data, textStatus){
						                                            	   
						                                                   if(textStatus == "success") {  
						                                                        $("#table_body").empty();
						                                                        
						                                                        var ad = data.admins;
						                                        				
						                                        				$.each(ad, function(index, a) {
						                                        					var tbody = "";
						                    										tbody += "<tr><td class='name'>" + a.id + "</td>"
																					+ "<td class='time'>" + a.adName + "</td>"
																					+ "<td class='address'>" + a.adLevel + "</td>"
																					+ "<td class='selected last'><input type='checkbox' class='check' value='" + a.id + "'/></td>" + "</tr>";
						                    										
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
<title>AdsDeliver Delete Administrator</title>
</head>
<body>
	<%@ include file="/admin/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/admin/left_nav.jsp" %>
		
		<!-- 对话框 -->
		<div id="success-message" title="提醒">
    		<p>
        		<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
        			你还没有选中任何管理员哦!。
    		</p>
		</div>
		
		<!-- content/right -->
		<div id="right">
			<!-- table -->
			<div class="box">
				<!-- box/title -->
				<div class="title">
					<h5>删除管理员</h5>
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
							<span>OHOH,暂时还没有其他管理员哦!</span>
						</div>
						<div class="dismiss">
							<a href="#message-notice"></a>
						</div>
					</div>
				</div>
				<!-- end notice message -->
				<div class="table">
					<form id="form" action="" method="post">
						<table>
							<thead>
								<tr>
									<th>管理员编号</th>
									<th>管理员名称</th>
									<th>管理员等级</th>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
								</tr>
							</thead>
							<tbody id="table_body"></tbody>
						</table>
						<div id="picpagenate"></div>
						<!-- table/action -->
						<div class="action">
							<select name="action">
								<option value="" class="unlocked">删除管理员</option>
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