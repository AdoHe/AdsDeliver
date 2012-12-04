<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- stylesheets -->
<link rel="stylesheet" type="text/css" href="css/jpagenation-style.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/records.css" media="screen"/>
<link id="color" rel="stylesheet" type="text/css" href="css/brown.css" />
<!-- scripts(jquery) -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>
<script type="text/javascript" src="js/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript" src="js/smooth.table.js"></script>
<script type="text/javascript" src="js/jquery.paginate.js"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
			});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var recordCount;
		$.get("GetPagedRecords.action", 
				{
				start : 0,
				length : 10
				},
				function(data,textStatus) {
					if(textStatus == "success")
					{
						recordCount = data.count;
						var re = data.records;
						
						$.each(re,function(index, record) {
							var tbody = "";
							
							tbody += "<tr><td class='title'>" + record.reDate.replace("T","  ") + "</td>"
							+ "<td class='price'>" + record.reIncome + "</td>"
							+ "<td class='price'>" + record.reOutcome + "</td>"
							+ "<td class='date'>" + record.reBalance + "</td>"
							+ "<td class='category'>" + record.reCategory + "</td></tr>";
							
							$("#table_body").append(tbody);
						});
						
						//初始化分页组件
						
						$("#picpagenate").paginate({ 
				            count         : ((recordCount % 10 == 0) ? parseInt(recordCount / 10) :  parseInt(recordCount / 10) + 1), 
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
				                                               "GetPagedRecords.action",
				                                               {
				                                                   start: (page-1) * 10,
				                                                   length: 10
				                                               },
				                                               function(data, textStatus){
				                                            	   
				                                                   if(textStatus == "success") {  
				                                                        $("#table_body").empty();
				                                                        
				                                                        var re = data.records;
				                                        				
				                                        				$.each(re,function(index, record) {
				                                        					var tbody = "";
				                                        					
				                                        					tbody += "<tr><td class='title'>" + record.reDate.replace("T","  ") + "</td>"
				                                        					+ "<td class='price'>" + record.reIncome + "</td>"
				                                        					+ "<td class='price'>" + record.reOutcome + "</td>"
				                                        					+ "<td class='date'>" + record.reBalance + "</td>"
				                                        					+ "<td class='category'>" + record.reCategory + "</td></tr>";
				                                        					
				                                        					$("#table_body").append(tbody);
				                                        				});
				                                                   }
				                                               }
				                                            );
				                                        } 
				            });
					}
				},"json");
		
	});
</script>

<title>AdsDeliver Account Records</title>
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
					<h5>你的交易记录:</h5>
				</div>
				<!-- end box/title -->
				<div class="table">
					<form action="" method="post">
						<table>
							<thead>
								<tr>
									<th class="left">交易时间</th>
									<th>收入金额</th>
									<th>支出金额</th>
									<th>当前余额</th>
									<th class="last">交易类别</th>
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