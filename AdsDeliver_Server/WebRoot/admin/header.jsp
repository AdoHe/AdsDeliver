<%@ page pageEncoding="utf-8"%>

<!-- header -->
<div id="header">
	<!-- logo -->
	<div id="logo">
		<h1><a href="" title="AdsDeliver"><img src="images/logo.png" alt="Ads Deliver" /></a></h1>
	</div>
	<!-- end logo -->
	<!-- user -->
	<ul id="user">
		<li class="first"><a href="">账户</a></li>
		<li><a href="UserLogout.action">注销</a></li>
		<li class="highlight last"><a href="">回到首页</a></li>
	</ul>
	<!-- end user -->
	<div id="header-inner">
		<div id="home">
			<a href="" title="Home"></a>
		</div>
		<!-- quick -->
		<ul id="quick">
			<li>
				<a href="" title="广告"><span class="icon"><img src="images/application_double.png" alt="广告管理" /></span>
				<span>广告管理</span></a>
				<ul>
					<li><a href="AdminIndex.action">审核广告</a></li>
					<li><a href="AdminAdsShowPage.action">查看广告</a></li>
					<li class="last"><a href="AdminAdsCancelPage.action">撤销广告</a></li>
				</ul>
			</li>
			<li>
				<a href="#" title="账户"><span class="icon"><img src="images/account.png" alt="管理员管理" /></span>
				<span>管理员管理</span></a>
				<ul>
					<li><a href="AdminAddPage.action">添加管理员</a></li>
					<li><a href="AdminAdsCancelPage.action">删除管理员</a></li>
				</ul>
			</li>
			<li>
				<a href="#" title="设置"><span class="icon"><img src="images/cog.png" alt="设置" /></span>
				<span>常用设置</span></a>
				<ul>
					<li>
						<a href="#" class="childs">广告单价设置</a>
						<ul>
							<li><a href="AdminChaBanPriPage.action">Banner单价</a></li>
							<li class="last"><a href="AdminChaConPriPage.action">Content单价</a></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
		<!-- end quick -->
		<div class="corner tl"></div>
		<div class="corner tr"></div>
	</div>
</div>
<!-- end header -->