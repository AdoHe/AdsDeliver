<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- stylesheets -->
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
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
			});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$.get("GetRecords.action", function(data,textStatus) {
			if(textStatus == "success")
			{
				var re = data.records;
				var page = data.totalPage;
				
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
		},"json");
	});
</script>

<title>AdsDeliver Account Records</title>
</head>
<body>
	<%@ include file="/jsp/header.jsp" %>
	<!-- content -->
	<div id="content">
		<%@ include file="/jsp/right_nav.jsp" %>
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
						<!-- pagination -->
						<div class="pagination pagination-left">
							<ul class="pager" id="pages">
							</ul>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- end content/right -->
	</div>
	<!-- end content -->
</body>
</html>