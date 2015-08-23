<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<header class="navbar clearfix" id="header">

	<div class="container" style="padding-right: 0px !important;">
		<div class="navbar-brand">
			<!-- COMPANY LOGO -->
			<a href="./"> <img src="./PAGE-STYLE/images/Masterpage/ic_viettelstore.png"
					alt="ViettelAppStore Logo" class="img-responsive" height="30" width="120">
			</a>
			<!-- /COMPANY LOGO -->
			<!-- TEAM STATUS FOR MOBILE -->
			<div class="visible-xs">
				<a href="#" class="team-status-toggle switcher btn dropdown-toggle"> <i class="fa fa-users"></i>
				</a>
			</div>
			<!-- /TEAM STATUS FOR MOBILE -->
			<!-- SIDEBAR COLLAPSE -->
			<div id="sidebar-collapse" class="sidebar-collapse btn" style="border: 0px; font-size: 18px;">
				<i class="fa fa-bars" data-icon1="fa fa-bars" data-icon2="fa fa-bars"></i>
			</div>
			<!-- /SIDEBAR COLLAPSE -->
		</div>
		<!-- NAVBAR LEFT -->
		<ul class="nav navbar-nav pull-right hidden-xs" id="navbar-left">
			<li class="dropdown"><a href="#" class="team-status-toggle dropdown-toggle tip-bottom" data-toggle="tooltip">
					<i class="fa fa-users"></i> <span class="name">Team</span> <i class="fa fa-angle-down"></i>
			</a></li>
		</ul>
		
		<!-- /NAVBAR LEFT -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<jsp:include page="/Form/MasterPageV2/NavigationMenu.jsp"></jsp:include>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- TEAM STATUS -->
	<jsp:include page="/Form/MasterPageV2/TeamStatus.jsp"></jsp:include>
	<!-- /TEAM STATUS -->
</header>
