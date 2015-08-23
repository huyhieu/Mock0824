<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<style>
#sticky_navigation_wrapper {
	width: 100%;
	height: 67px;
	position: absolute;
	z-index: 1000;
}

#sticky_navigation {
	display: none;
	width: 100%;
	height: 67px;
	margin: 0 auto;
	background: none;
}
</style>

<div id="sticky_navigation_wrapper">
	<div id="sticky_navigation">
		<div id="imgLoading" style="width: 130px; text-align: center; height: 50px; margin: 0px auto; display: block; border-radius: 10px; background: none">
			<img src="./PAGE-STYLE/images/loader1.gif" style="width: 50px; height: 50px; margin: 0 auto;">
		</div>
		<div id="errMessage" style="text-align: center; width: 100%; position: absolute; top: 24px;"></div>

	</div>
</div>
<script>
	var sticky_navigation_offset_top = $('#sticky_navigation').offset().top;
	var sticky_navigation = function() {
		var scroll_top = $(window).scrollTop(); // our current vertical position from the top
		if (scroll_top > sticky_navigation_offset_top) {
			$('#sticky_navigation').css({
				'position' : 'fixed',
				'top' : 0,
				'left' : 0
			});
		} else {
			$('#sticky_navigation').css({
				'position' : 'relative'
			});
		}
	};

	sticky_navigation();
	$(window).scroll(function() {
		sticky_navigation();
	});
	$('a[href="#"]').click(function(event) {
		event.preventDefault();
	});
	$('#removeButon').click(function(event) {
		clearTimeout(messageTimeout);
		hideLoading();
	});
	$("#sticky_navigation").hide();

	var messageTimeout;
	var timeout = 3000;

	function showMessageError(mesage, respone, callback) {
		var obj = respone;
		if (!$.isEmptyObject(obj)) {
			if (obj.responseText.indexOf('<script>') == 8) {
				var url = document.URL;
				var shortUrl = url.substring(0, url.lastIndexOf("/"));
				window.location.href = shortUrl;
				return;
			}
		}

		$("#sticky_navigation_wrapper").css("display", "");
		$("#imgLoading").css("display", "none");
		$("#errMessage").css("display", "block");
		$("#errMessage").text(mesage);
		$('#sticky_navigation').css({
			'background' : '#c74c47',
			'color' : '#FFF',
			'z-index' : 1000,
		});
		$('#sticky_navigation').slideDown(200, function() {
			$("#sticky_navigation_wrapper").css("height", "67px");
			clearTimeout(messageTimeout);
			messageTimeout = setTimeout(function() {
				hideLoading();
				if (callback)
					callback();
			}, timeout);
		});
		$("#siteIcon").attr("href", "./PAGE-STYLE/images/ic_logo.png");
	}

	function showMessageSuccess(mesage, callback) {
		$("#sticky_navigation_wrapper").css("display", "");
		$("#imgLoading").css("display", "none");
		$("#errMessage").css("display", "block");
		$("#errMessage").text(mesage);
		$('#sticky_navigation').css({
			'background' : '#33CCFF',
			'color' : '#FFF',
			'z-index' : 1000,
		});
		$('#sticky_navigation').slideDown(200, function() {
			$("#sticky_navigation_wrapper").css("height", "67px");
			clearTimeout(messageTimeout);
			messageTimeout = setTimeout(function() {
				hideLoading();
				if (callback)
					callback();
			}, timeout);
		});
		$("#siteIcon").attr("href", "./PAGE-STYLE/images/ic_logo.png");
	}
	function showProgressIcon(callback) {
		$("#siteIcon").attr("href", "./PAGE-STYLE/images/loader1.gif");
		$("#sticky_navigation_wrapper").css("display", "");
		$("#imgLoading").css("display", "block");
		$("#errMessage").css("display", "none");
		$('#sticky_navigation').css({
			'background' : 'none'
		});
		$('#sticky_navigation').slideDown(0, function() {
			$("#sticky_navigation_wrapper").css("height", "67px");
			if (callback != null)
				callback();
		});
	}
	function hideLoading() {
		$('#sticky_navigation_wrapper').slideUp(200, function() {
		});
		$("#siteIcon").attr("href", "./PAGE-STYLE/images/ic_logo.png");
	}
	$('#sticky_navigation_wrapper').slideUp();

	// Refresh menu user
	function doRefreshUserMenu(menuIndex) {
		$
				.ajax({
					type : 'POST',
					url : 'refreshUserMenu.do',
					dataType : 'html',
					async : true,
					success : function(response) {
						$("#list-toggle").html(response);
						//settingActive(menuIndex, 2);
						onClickSubMenu('' + menuIndex);
					},
					error : function(response) {
						showMessageError(JQUERY_MESSAGE_CLASS.globalErrorMsg,
								response);
					}
				});
	};

	function doRefreshAppStatus() {
		$
				.ajax({
					type : 'POST',
					url : 'refreshAppStatus.do',
					dataType : 'html',
					async : true,
					success : function(response) {
						$("#appStatusDiv").html(response);
					},
					error : function(response) {
						showMessageError(JQUERY_MESSAGE_CLASS.globalErrorMsg,
								response);
					}
				});
	};

	function refreshAppIcon() {
		$
				.ajax({
					type : 'POST',
					url : 'refreshAppIcon.do',
					dataType : 'html',
					async : true,
					success : function(response) {
						$("#title_app").html(response);
					},
					error : function(response) {
						showMessageError(JQUERY_MESSAGE_CLASS.globalErrorMsg,
								response);
					}
				});
	};

	function doRefreshListAppsAndStatus() {
		$
				.ajax({
					type : 'POST',
					url : 'refreshManageApk.do',
					dataType : 'html',
					async : true,
					success : function(response) {
						$("#right").html(response);
						hideLoading();
					},
					error : function(response) {
						showMessageError(JQUERY_MESSAGE_CLASS.globalErrorMsg,
								response);
					}
				});
	};

	// Reset select - option
	function resetOption(selectId) {
		$('#' + selectId + ' option').prop('selected', function() {
			return this.defaultSelected;
		});
	};

	// Logout
	function doLogoutFunc() {
		var url = document.URL;
		var shortUrl = url.substring(0, url.lastIndexOf("/"));
		window.location.href = shortUrl;
	};
</script>