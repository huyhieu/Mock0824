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
<!-- BOOTSTRAP -->
<script src="./PAGE-STYLE/bootstrap/js/dist/js/framework/bootstrap.js"></script>
<script
	src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="col-xs-12 col-md-12">
		<div class="header"
			style="height: 150px !important; padding-bottom: 0px !important;">
			<tiles:insertAttribute name="header" />
		</div>

		<div class="container" style="height: 450px !important;">

			<div class="row" style="height: 100% !important;">

				<div class="col-xs-3 col-md-3"
					style="height: 100% !important; border-right: 1px solid #cccccc;">
					<tiles:insertAttribute name="menu" />
				</div>

				<div class="col-xs-9 col-md-9" style="height: 100% !important;">
					<tiles:insertAttribute name="body" />
				</div>

			</div>

		</div>

		<div style="height: 150px !important; padding-bottom: 0px !important;">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

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


	<!-- BOOTSTRAP DIALOG -->
	<script src="./PAGE-STYLE/bootstrap/js/dialog/bootstrap-dialog.min.js"></script>
	<script src="./PAGE-STYLE/bootstrap/js/dialog/bootstrap-dialog.js"></script>


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
	<script
		src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/bootstrap.min.js"></script>
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
