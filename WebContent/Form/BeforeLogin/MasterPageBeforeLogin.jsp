<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link id="siteIcon" rel="shortcut icon" type="image/gif" href="./PAGE-STYLE/images/ic_logo.png">
<title>
 <tiles:insertAttribute name="title" ignore="true" />
</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="./PAGE-STYLE/bootstrap/css/pages/signup.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="./PAGE-STYLE/bootstrap/js/dist/css/formValidation.css">
<link rel="stylesheet" href="./PAGE-STYLE/bootstrap/js/dist/css/datepicker.css">
<link href="./PAGE-STYLE/bootstrap/css/pages/common.css" rel="stylesheet" type="text/css">
</head>
<style>
.btn-facebook {
	font-size: 13px;
	font-weight: 400;
	background-color: #3d5998;
	color: #fff;
	padding: 4px 20px 1px 12px;
	border-radius: 15px;
	margin-right: 2px;
}

.btn-facebook:hover {
	opacity: .7;
}

.btn-google-plus {
	font-size: 13px;
	font-weight: 400;
	background-color: #dd6b6b;
	color: #fff;
	padding: 5px 25px 2px 14px;
	border-radius: 15px;
	margin-right: 2px;
}

.btn-google-plus:hover {
	opacity: .7;
}

.btn-linkedin {
	font-size: 13px;
	font-weight: 400;
	background-color: #0177b5;
	color: #fff;
	padding: 3px 19px 2px 14px;
	border-radius: 15px;
}

.btn-linkedin:hover {
	opacity: .7;
}

.btn-linkedin img {
	display: inline-block;
	width: auto;
	height: 24px;
	padding-right: 4px;
	padding-bottom: 2px;
}

img {
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0;
}

.login-socail-network {
	height: 40px;
	width: 340px;
	/* padding-top: 5px; */
}

.login-socail-network a {
	display: inline-block;
	cursor: pointer;
}

a {
	text-decoration: none;
}

.btn-large {
	font-size: 14px;
	font-weight: 600;
	border-radius: 3px;
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.75), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	padding: 11px 19px;
	display: inline-block;
	margin-bottom: 0;
	line-height: 20px;
	text-align: center;
	vertical-align: middle;
	cursor: pointer;
	color: #333;
	text-shadow: 0 1px 1px rgba(255, 255, 255, .75);
	background-color: #f5f5f5;
	background-image: linear-gradient(to bottom, #fff, #e6e6e6);
	background-repeat: repeat-x;
	border-color: rgba(0, 0, 0, .1) rgba(0, 0, 0, .1) rgba(0, 0, 0, .25);
	border: 1px solid #ccc;
	border-bottom-color: #b3b3b3;
}

.form-login {
	border: 1px solid #d5d5d5;
	display: block;
	border-radius: 5px;
	margin-right: 20px;
	margin-bottom: 20px;
	padding: 20px;
}
</style>
<body>
 <tiles:insertAttribute name="header" />
 <tiles:insertAttribute name="body" />
 <tiles:insertAttribute name="footer" />
 <!-- /account-container -->
 <!-- Text Under Box -->
 <!-- Placed at the end of the document so the pages load faster -->
 <script src="./PAGE-STYLE/bootstrap/js/vendor/jquery/jquery.min.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/bootstrap.min.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/dist/js/formValidation.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/dist/js/framework/bootstrap.js"></script>
 <!-- <script src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/globaldefine.js"></script> -->
 <script src="./PAGE-STYLE/bootstrap/js/dist/js/bootstrap-datepicker.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/pages/common.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/pages/signup.js"></script>
</body>
</html>