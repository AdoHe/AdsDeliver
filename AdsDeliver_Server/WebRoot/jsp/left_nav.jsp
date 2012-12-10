<%@ page pageEncoding="utf-8"%>

<!-- content/left -->
<div id="left">
	<div id="menu">
		<h6 id="h-menu-ads" class="selected"><a href="#ads"><span>广告</span></a></h6>
		<ul id="menu-ads" class="opened">
			<li><a href="AdNew.action">投放广告</a></li>
			<li><a href="AdList.action">查看广告</a></li>
			<li class="last"><a href="AdCancel.action">撤销广告</a></li>
		</ul>
		<h6 id="h-menu-accounts"><a href="#accounts"><span>账户</span></a></h6>
		<ul id="menu-accounts" class="closed">
			<li><a href="UserAccount.action">查看账户余额</a></li>
			<li><a href="AccountRecord.action">查看交易记录</a></li>
			<li class="last"><a href="AccountRecharge.action">账户充值</a></li>
		</ul>
		<h6 id="h-menu-settings"><a href="#settings"><span>设置</span></a></h6>
		<ul id="menu-settings" class="closed">
			<li class="collapsible">
				<a href="#" class="plus">账户设置</a>
				<ul class="collapsed">
					<li><a href="UserInfo.action">修改用户资料</a></li>
					<li class="last"><a href="UserPwd.action">修改用户密码</a></li>
				</ul>
			</li>
			<li class="last"><a href="#">广告设置</a></li>
		</ul>
	</div>
	<div id="date-picker"></div>
</div>
<!-- end content/left -->