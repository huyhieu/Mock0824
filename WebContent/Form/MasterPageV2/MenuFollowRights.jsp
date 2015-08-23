<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<ul>
	<li>
		<a href="#" style="padding-top: 10px; padding-bottom: 10px;" onclick="onClickMenu(this.id);"
		id="1"> 
			<img style="width: 25px; margin-left: -5px;" src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/images/MenuIcon/ic_setting.png"> 
			<span class="menu-text" style="padding-left: 10px;"> Name menu </span> <span class="selected"></span>
		</a>
	</li>
	<li>
		<a href="#" style="padding-top: 10px; padding-bottom: 10px;" onclick="onClickMenu(this.id);"
		id="2"> 
			<img style="width: 25px; margin-left: -5px;" src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/images/MenuIcon/ic_setting.png"> 
			<span class="menu-text" style="padding-left: 10px;"> Name menu </span> <span class="selected"></span>
		</a>
	</li>
	<li>
		<a href="#" style="padding-top: 10px; padding-bottom: 10px;" onclick="onClickMenu(this.id);"
		id="3"> 
			<img style="width: 25px; margin-left: -5px;" src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/images/MenuIcon/ic_setting.png"> 
			<span class="menu-text" style="padding-left: 10px;"> Name menu </span> <span class="selected"></span>
		</a>
	</li>
	<li>
		<a href="#" style="padding-top: 10px; padding-bottom: 10px;" onclick="onClickMenu(this.id);"
		id="4"> 
			<img style="width: 25px; margin-left: -5px;" src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/images/MenuIcon/ic_setting.png"> 
			<span class="menu-text" style="padding-left: 10px;"> Name menu </span> <span class="selected"></span>
		</a>
	</li>
</ul>

<script>
	function onClickMenu(id) {
		settingActive(id, 1);
		switch (id) {
		case '1': {
			doRefreshPage("applicationOnClicked.do");
			break;
		}
		case '2': {
			doRefreshPage("loadReport.do");
			break;
		}
		case '3': {
			doRefreshPage("invitedAppsOnClicked.do");
			break;
		}
		case '4': {
			doRefreshPage("showSettingInfor.do");
			break;
		}
		case '5': {
			doRefreshPage("showReviewApps.do");
			break;
		}
		case '6': {
			doRefreshPage("showAllEvents.do");
			break;
		}
		case '7': {
			doRefreshPage("loadReport.do");
			break;
		}
		case '8': {
			doRefreshPage("showAdminInfo.do");
			break;
		}
		case '18': {
			doRefreshPage("showReviewComment.do");
			break;
		}
		case '19': {
			doRefreshPage("showConfigPage.do");
			break;
		}
		default:
			break;
		}
	}

	function onClickSubMenu(menuItemId) {
		// Set style -> highlight
		settingActive(menuItemId, 2);
		showProgressIcon();
		switch (menuItemId) {
		case '9':
		case '10':
		case '11':
			loadFormApplication('APK');
			break;

		case '12': {
			loadStoreListingForm();
			break;
		}
		case '13': {
			loadFormApplication('PricingAndDistribution');
			break;
		}
		case '14': {
			loadRatingAndReviews();
			break;
		}

		case '15': {
			doLoadFromSetting("AccountDetailsFromSetting.do");// gọi hàm ajax load form AccountDetails 
			break;
		}
		case '16': {
			doLoadFromSetting("UserAccountsFromSetting.do");// gọi hàm ajax load form UserAccounts
			break;
		}
		case '17': {
			doLoadFromSetting("ActivityLogsFromSetting.do");// gọi hàm ajax load form ActivityLogs
			break;
		}
		default:
			break;
		}
	}

	function doRefreshPage(url) {
		showProgressIcon();
		document.location.hash = url;
		history.pushState('data', '', document.location.hash); // insert aster risk after an action
		$
				.ajax({
					type : 'POST',
					url : url,
					dataType : 'html',
					async : true,
					success : function(response) {
						var status = response.trim();
						if (status === "error") {
							if (lang == JQUERY_KEY_LANG_CLASS.KEY_LANG_VI) {

								showMessageError(JQUERY_MESSAGE_VI_CLASS.COULD_NOT_LOAD_PAGE_AT_THE_MOMENT);
							} else {
								showMessageError(JQUERY_MESSAGE_CLASS.COULD_NOT_LOAD_PAGE_AT_THE_MOMENT);
							}
						} else {
							hideLoading();
							$("#content").html(response);
						}
					},
					error : function(response) {
						if (lang == JQUERY_KEY_LANG_CLASS.KEY_LANG_VI) {

							showMessageError(
									JQUERY_MESSAGE_VI_CLASS.globalErrorMsg,
									response);
						} else {
							showMessageError(
									JQUERY_MESSAGE_CLASS.globalErrorMsg,
									response);
						}

					}
				});
		hideLoading();
	};

	// lan dau tien load chon active menu dau tien
	var t = 0;
	if (t == 0) {
		settingActive('1', 1);
		t = 1;
	}

	function settingActive(id, level) {
		// bo het trang thai active
		if (level == 1) {
			$('#1').parent('li').closest('li').removeClass('active');
			$('#2').parent('li').closest('li').removeClass('active');
			$('#3').parent('li').closest('li').removeClass('active');
			$('#4').parent('li').closest('li').removeClass('active');
			$('#5').parent('li').closest('li').removeClass('active');
			$('#6').parent('li').closest('li').removeClass('active');
			$('#7').parent('li').closest('li').removeClass('active');
			$('#8').parent('li').closest('li').removeClass('active');
			$('#18').parent('li').closest('li').removeClass('active');
			$('#19').parent('li').closest('li').removeClass('active');
		} else {
			$('#9').parent('li').closest('li').removeClass('active');
			$('#10').parent('li').closest('li').removeClass('active');
			$('#11').parent('li').closest('li').removeClass('active');
			$('#12').parent('li').closest('li').removeClass('active');
			$('#13').parent('li').closest('li').removeClass('active');
			$('#14').parent('li').closest('li').removeClass('active');
			$('#15').parent('li').closest('li').removeClass('active');
			$('#16').parent('li').closest('li').removeClass('active');
			$('#17').parent('li').closest('li').removeClass('active');
		}

		// active menu onclick
		$('#' + id).parent('li').addClass('active');
	}
</script>