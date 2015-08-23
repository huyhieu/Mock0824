<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<ul class="nav navbar-nav pull-right">
	<c:if test="${!empty param.language}">
		<f:setLocale value="${param.language}" scope="session" />
	</c:if>
	<f:setBundle basename="GlobalDefine.Language" scope="session" />
	<!-- BEGIN USER LOGIN DROPDOWN -->
	<li class="dropdown user" id="header-user"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
		style="min-width: 250px; height: 50px;"> <img alt="" src="./PAGE-STYLE/images/no-avatar.jpg" style="float: left;" />
			<span class="username hidden-xs"
				style="display: block !important; width: 100%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis; max-width: 190px; float: left; padding-top: 5px;">
				HieuPh
			</span>
	</a>
		<ul class="dropdown-menu">
			<li><a onclick="onClickMenu('4');"> <i class="fa fa-user"></i> MyProfile
			</a></li>
			<li><a  href="./"> <i class="fa fa-power-off"></i>SignOut
			</a></li>
		</ul></li>
	<!-- END USER LOGIN DROPDOWN -->
</ul>
  