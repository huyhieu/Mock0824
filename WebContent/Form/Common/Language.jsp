<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<div class="lang">
	<a href="?language=vi_VN" onclick="changeLanguage('VI');"
		title="Tiếng Việt"> <img class="flagNational" alt="Tiếng Việt"
		title="Tiếng Việt" src="./PAGE-STYLE/images/Flag/vie.gif">
	</a> <a href="?language=en_EN" title="English"
		onclick="changeLanguage('EN');"> <img class="flagNational"
		alt="English" title="English" src="./PAGE-STYLE/images/Flag/eng.jpg">
	</a>
	<c:if test="${!empty param.language}">
		<f:setLocale value="${param.language}" scope="session" />
	</c:if>
	<f:setBundle basename="GlobalDefine.Language" scope="session" />
</div>

<script type="text/javascript">
	// lang: global variable

	var lang = "";
	var lang = '<s:property value="#session.language" />';

	if (lang.length == 4 || lang == null || lang === '') {
		lang = 'EN';
	}

	function changeLanguage(keyLang) {
		if (navigator.onLine) {
			// Show loading
			showOverlay(EN_MESSAGE.Key_loading, VI_MESSAGE.Key_loading);
			$.ajax({
				type : 'post',
				url : 'changeLanguage.do',
				dataType : 'json',
				timeout : G_MESSAGE.globalTimeOut,
				data : JSON.stringify({
					'keyLang' : keyLang
				}),
				contentType : 'application/json',
				async : true,
				success : function(response) {
					//hideOverlay();
				},
				error : function(response) {
					hideOverlay();
				}
			});
		} else {
			hideOverlay();
		}
	};

	function setPlatForm(platformId) {
		if (navigator.onLine) {
			// Show loading
			showOverlay(EN_MESSAGE.Key_loading, VI_MESSAGE.Key_loading);

			$.ajax({
				type : 'post',
				url : 'loadPlatform!handlerSetPlatform.do',
				dataType : 'json',
				timeout : G_MESSAGE.globalTimeOut,
				data : JSON.stringify({
					'platformId' : platformId
				}),
				contentType : 'application/json',
				async : true,
				success : function(response) {
					location.href = 'Home.do';
				},
				error : function(response) {
					showAlertMessage(EN_MESSAGE.Key_changeplatform_error,
							VI_MESSAGE.Key_changeplatform_error);
				}
			});
		} else {
			showAlertMessage(EN_MESSAGE.Key_changeplatform_error,
					VI_MESSAGE.Key_changeplatform_error);
		}
	};

	
</script>