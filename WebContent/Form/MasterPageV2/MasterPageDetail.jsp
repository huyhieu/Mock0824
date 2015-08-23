<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link id="siteIcon" rel="shortcut icon" type="image/gif"
	href="./PAGE-STYLE/images/ic_logo.png">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Vmock</title>

<link rel="stylesheet"
	href="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="./PAGE-STYLE/css/style.css" />
<link href="./PAGE-STYLE/bootstrap/dashboard/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="./PAGE-STYLE/bootstrap/dashboard/css/admin.css">
<link rel="stylesheet" type="text/css"
	href="./PAGE-STYLE/bootstrap/dashboard/css/themes/default.css"
	id="skin-switcher">
<link rel="stylesheet" type="text/css"
	href="./PAGE-STYLE/bootstrap/dashboard/css/responsive.css">

<!-- DATE RANGE PICKER -->
<link rel="stylesheet" type="text/css"
	href="./PAGE-STYLE/bootstrap/dashboard/js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<!-- ANIMATE -->
<link rel="stylesheet" type="text/css"
	href="./PAGE-STYLE/bootstrap/dashboard/css/animatecss/animate.min.css" />
<!-- SLIDENAV -->
<link rel="stylesheet" type="text/css"
	href="./PAGE-STYLE/bootstrap/dashboard/js/slidernav/slidernav.css" />
<!-- FONTS -->
<!-- Style form validation -->
<link rel="stylesheet"
	href="./PAGE-STYLE/bootstrap/js/dist/css/formValidation.css" />
<!-- DATE PICKER -->
<link rel="stylesheet"
	href="./PAGE-STYLE/bootstrap/js/dist/css/datepicker.css" />
<!-- POPUP -->
<link rel="stylesheet" href="./PAGE-STYLE/css/common/popup/style.css">
<link rel="stylesheet"
	href="./PAGE-SCRIPT/jquery/jquery-ui-1.11.1/jquery-ui.css">

<script
	src="./PAGE-STYLE/bootstrap/dashboard/js/jquery/jquery-2.0.3.min.js"></script>

<style type="text/css">
.dropdown-menu {
	position: absolute;
	top: 100%;
	left: 0;
	z-index: 1000;
	display: none;
	float: left;
	min-width: 160px;
	padding: 2px 0;
	padding-top: 0px;
	font-size: 14px;
	text-align: left;
	list-style: none;
	background-color: #fff;
	-webkit-background-clip: padding-box;
	background-clip: padding-box;
	border: 1px solid #ccc;
	border: 1px solid rgba(0, 0, 0, .15);
	border-radius: 4px;
	-webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
	box-shadow: 0 6px 12px rgba(0, 0, 0, .175)
}
</style>

</head>
<body>
	<!-- HEADER -->
	<jsp:include page="/Form/Common/PageLoading.jsp"></jsp:include>
	<tiles:insertAttribute name="header" />
	<!--/HEADER -->

	<!-- PAGE -->
	<section id="page" style="height: auto;">
		<!-- SIDEBAR -->
		<div id="sidebar" class="sidebar">
			<div class="sidebar-menu nav-collapse" style="border-right: 1px solid #ddd;">
				<div class="divide-20"></div>
				<!-- SEARCH BAR -->
				<jsp:include page="/Form/MasterPageV2/SearchTotal.jsp"></jsp:include>
				<!-- /SEARCH BAR -->

				<!-- SIDEBAR MENU -->
				<jsp:include page="/Form/MasterPageV2/MenuFollowRights.jsp"></jsp:include>
				<!-- /SIDEBAR MENU -->
			</div>
		</div>
		<!-- /SIDEBAR -->
		<div id="main-content">
			<!-- SAMPLE BOX CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="box-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Box Settings</h4>
						</div>
						<div class="modal-body">Here goes box setting content.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save changes</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /SAMPLE BOX CONFIGURATION MODAL FORM-->
			<div class="container">
				<div class="row">
					<div id="content"
						style="padding-left: 0px; padding-right: 0px; min-height: initial !important; padding-left: 0px !important; padding-right: 0px !important;">
						<tiles:insertAttribute name="content" />
					</div>
					<!-- /CONTENT-->
				</div>
			</div>
		</div>
	</section>
	<!-- Dialog add new project -->
	<div>
		<jsp:include page="/Form/Common/pagedialog.jsp"></jsp:include>
	</div>

	<!-- JAVASCRIPTS -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- globaldefine -->
	<!-- Common -->
	<script src="./PAGE-STYLE/bootstrap/js/pages/common.js"></script>
	<script
		src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/globaldefine.js"></script>

	<!-- Global Message -->
	<script src="./PAGE-SCRIPT/globalmessage/GlobalMessage.js"></script>

	<!-- JQUERY-->
	<script
		src="./PAGE-STYLE/bootstrap/dashboard/js/jquery/jquery-2.0.3.min.js"></script>

	<script
		src="./PAGE-STYLE/bootstrap/dashboard/js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"></script>

<script src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- BOOTSTRAP DIALOG -->
	<script src="./PAGE-STYLE/bootstrap/js/dialog/bootstrap-dialog.min.js"></script>
	<script src="./PAGE-STYLE/bootstrap/js/dialog/bootstrap-dialog.js"></script>

<!-- DATE RANGE PICKER -->


	<!-- DATE RANGE PICKER -->
	<script
		src="./PAGE-STYLE/bootstrap/dashboard/js/bootstrap-daterangepicker/moment.min.js"></script>

	<script
		src="./PAGE-STYLE/bootstrap/dashboard/js/bootstrap-daterangepicker/daterangepicker.min.js"></script>
	<!-- SLIMSCROLL -->
	<script type="text/javascript"
		src="./PAGE-STYLE/bootstrap/dashboard/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.min.js"></script>
	<script
		src="./PAGE-STYLE/bootstrap/dashboard/js/jQuery-slimScroll-1.3.0/slimScrollHorizontal.min.js"></script>
	<!-- BLOCK UI -->
	<script type="text/javascript"
		src="./PAGE-STYLE/bootstrap/dashboard/js/jQuery-BlockUI/jquery.blockUI.min.js"></script>
	<!-- SLIDENAV -->
	<script type="text/javascript"
		src="./PAGE-STYLE/bootstrap/dashboard/js/slidernav/slidernav.js"></script>
	<!-- COOKIE -->
	<script type="text/javascript"
		src="./PAGE-STYLE/bootstrap/dashboard/js/jQuery-Cookie/jquery.cookie.min.js"></script>
	<!-- CUSTOM SCRIPT -->
	<script src="./PAGE-STYLE/bootstrap/dashboard/js/script.js"></script>
	<!-- DATE PICKER -->
	<script src="./PAGE-STYLE/bootstrap/js/dist/js/bootstrap-datepicker.js"></script>
	<!-- POPUP -->

	<script src="./PAGE-STYLE/bootstrap/js/dist/js/formValidation.js"></script>
	<!-- BOOTSTRAP -->
	<script src="./PAGE-STYLE/bootstrap/js/dist/js/framework/bootstrap.js"></script>
	<script src="./PAGE-STYLE/bootstrap/js/pages/signin.js"></script>
	<!-- AppDetail -->
	<script>
		jQuery(document).ready(function() {
			App.setPage("address_book"); //Set current page 
			App.init(); //Initialise plugins and elements
		});
	</script>
	<!-- /JAVASCRIPTS -->
</body>
</html>
