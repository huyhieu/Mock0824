<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!-- PAGE HEADER-->
<style>
<!--
div#right {
	background: #fff;
}

button.btn.btn-primary.pull-right {
	margin: 20px;
}

div.testers {
	margin: 20px 0px 20px 0px;
	width: 100%;
	padding: 10px;
	height: 70px;
	margin-bottom: 50px;
	line-height: 25px;
	color: #1bb3ca;
	background: #f1f1f1;
	font-weight: normal;
}

p.testers {
	color: #1bb3ca;
	font-weight: normal;
	text-decoration: underline;
	cursor: pointer;
	font-size: 14px;
	width: 150px;
}

button.btn.btn-light-grey.dropdown-toggle {
	border-radius: 5px !important;
}

h6.hidden-xs {
	margin: 3px 0px 0px 0px;
}
-->
</style>
<div class="row" style="margin-right: 0px;">
	<div class="col-sm-12" id="appStatusDiv" style="display: none;">
	==This is header content==
	</div>
</div>
<!-- /PAGE HEADER -->
<div id="right" style="min-height: 580px !important;">
	<div class="row" style="margin-left: 0px; margin-right: 0px;">
		<div id="list-toggle" class="col-md-3" style="padding: 0px;">
			<div id="sub_left_content">
				<jsp:include page="/Form/PartPage/ListProject.jsp"></jsp:include>
			</div>
		</div>
		<div class="col-md-9" style="border-left: solid #eee 1px; padding: 0px;">
			<div id="sub_right_content" class="detailApplicationContent" style="min-height: 550px;">
				<jsp:include page="/Form/PartPage/ApiDetail.jsp"></jsp:include>
			</div>
		</div>
	</div>
</div>
