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
<!-- scripts(custom) -->
<script type="text/javascript" src="js/smooth.js"></script>
<script type="text/javascript" src="js/smooth.menu.js"></script>
<script type="text/javascript" src="js/smooth.table.js"></script>
<script type="text/javascript">
			
			$(document).ready(function () {
				style_path = "css";

				$("#date-picker").datepicker();
				
				$("input:submit").button();
				
			});
</script>

<title>AdsDeliver Administer Page</title>
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
					<h5>广告</h5>
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
				<div class="table">
					<form action="" method="post">
						<table>
							<thead>
								<tr>
									<th class="left">Title</th>
									<th>Price</th>
									<th>Added</th>
									<th>Status</th>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="title">shit</td>
									<td class="price">fuck</td>
									<td class="date">gan</td>
									<td class="category">ri</td>
									<td class="selected last"><input type="checkbox" /></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
		<!-- end content/right -->
	</div>
	<!-- end content -->
</body>
</html>