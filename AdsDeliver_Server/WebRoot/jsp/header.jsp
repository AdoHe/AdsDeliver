<%@ page pageEncoding="utf-8"%>

<!-- header -->
<div id="header">
	<!-- logo -->
	<div id="logo">
		<h1><a href="UserIndex.action" title="SmoothAdmin"><img src="images/logo.png" alt="Smooth Adimn" /></a></h1>
	</div>
	<!-- end logo -->
	<!-- user -->
	<ul id="user">
		<li class="first"><a href="">账户</a></li>
		<li><a href="UserLogout.action">注销</a></li>
		<li class="highlight last"><a href="UserIndex.action">回到首页</a></li>
	</ul>
	<!-- end user -->
	<div id="header-inner">
		<div id="home">
			<a href="UserIndex.action" title="Home"></a>
		</div>
		<!-- quick -->
		<ul id="quick">
			<li>
				<a href="" title="广告"><span class="icon"><img src="images/application_double.png" alt="广告管理" /></span>
				<span>广告管理</span></a>
				<ul>
					<li><a href="AdNew.action">投放广告</a></li>
					<li><a href="AdList.action">查看广告</a></li>
					<li class="last"><a href="AdCancel.action">撤销广告</a></li>
				</ul>
			</li>
			<li>
				<a href="#" title="账户"><span class="icon"><img src="images/account.png" alt="账户管理" /></span>
				<span>账户管理</span></a>
				<ul>
					<li><a href="UserAccount.action">查看账户余额</a></li>
					<li><a href="AccountRecord.action">查看交易记录</a></li>
					<li class="last"><a href="AccountRecharge.action">账户充值</a></li>
				</ul>
			</li>
			<li>
				<a href="#" title="设置"><span class="icon"><img src="images/cog.png" alt="设置" /></span>
				<span>常用设置</span></a>
				<ul>
					<li>
						<a href="#" class="childs">账户设置</a>
						<ul>
							<li><a href="UserInfo.action">修改用户资料</a></li>
							<li class="last"><a href="UserPwd.action">修改用户密码</a></li>
						</ul>
					</li>
					<li class="last"><a href="#">广告设置</a></li>
				</ul>
			</li>
		</ul>
		<!-- end quick -->
		<div class="corner tl"></div>
		<div class="corner tr"></div>
	</div>
</div>
<!-- end header -->