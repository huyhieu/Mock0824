<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<div id="sidebar" class="sidebar">
	<div class="sidebar-menu nav-collapse">
		<div class="divide-20"></div>
		<!-- Language -->
		<div id="search-bar">
			<h3 class="" style="margin-top: -15px; margin-bottom: 0px; width: 280px !important;">Viettel AppStore</h3>
			<jsp:include page="/Form/Common/Language.jsp"></jsp:include>
		</div>
		<!-- /Language -->

		<!-- SIDEBAR MENU -->
		<ul>
			<s:if test="#session.listPlatform!= null">
				<s:iterator value="#session.listPlatform" id="itemPlatform">
					<s:if test="#itemPlatform.platformId == #session.platform">
						<li class="active">
					</s:if>
					<s:else>
						<li class="">
					</s:else>

					<a href="#" onclick="setPlatForm(<s:property value="#itemPlatform.platformId"/>);">
						<img style="width: 25px; margin-left: -5px;" src="<s:property value="#itemPlatform.platformIcon"/>">
						<span class="menu-text">
							<s:property value="#itemPlatform.platformName" />
						</span>
						<span class="selected"></span>
					</a>
					</li>
				</s:iterator>
			</s:if>
		</ul>
		<!-- /SIDEBAR MENU -->
	</div>
</div>