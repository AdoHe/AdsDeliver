<%@ page pageEncoding="utf-8"%>

<!-- content/left -->
<div id="left">
	<div id="menu">
		<h6 id="h-menu-ads" class="selected"><a href="#ads"><span>广告</span></a></h6>
		<ul id="menu-ads" class="opened">
			<li><a href="AdminIndex.action">审核广告</a></li>
			<li><a href="AdminAdsShowPage.action">查看广告</a></li>
			<li class="last"><a href="AdminAdsCancelPage.action">撤销广告</a></li>
		</ul>
		<h6 id="h-menu-accounts"><a href="#accounts"><span>账户</span></a></h6>
		<ul id="menu-accounts" class="closed">
			<li><a href="AdminAddPage.action">添加管理员</a></li>
			<li><a href="AdminAdsCancelPage.action">删除管理员</a></li>
			<li class="last"><a href="#">管理员权限管理</a></li>
		</ul>
		<h6 id="h-menu-settings"><a href="#settings"><span>设置</span></a></h6>
		<ul id="menu-settings" class="closed">
			<li class="collapsible">
				<a href="#" class="plus">广告单价设置</a>
				<ul class="collapsed">
					<li><a href="#">Banner单价</a></li>
					<li class="last"><a href="UserPwd.action">Content单价</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div id="date-picker"></div>
</div>
<!-- end content/left -->