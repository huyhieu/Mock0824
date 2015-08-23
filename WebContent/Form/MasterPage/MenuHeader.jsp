<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<style>
img.platform {
	margin-right: 5px;
	border-radius: 0px !important;
	height: 29px;
	width: 29px;
}

.scroll_menu {
	max-height: 290px;
	overflow: hidden;
	overflow-y: auto;
}

a.dropdown-toggle {
	position: relative;
}

a.dropdown-toggle::before {
	content: '';
	display: inline-block;
	border-left: 7px solid transparent;
	border-right: 7px solid transparent;
	border-bottom: 7px solid #CCC;
	border-bottom-color: rgba(0, 0, 0, 0.2);
	position: absolute;
	bottom: -2px;
	right: 7px;
	display: none;
}

a.dropdown-toggle::after {
	content: '';
	display: inline-block;
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	border-bottom: 6px solid white;
	position: absolute;
	bottom: -2px;
	right: 8px;
	z-index: 1001;
	display: none;
}

.open>a.dropdown-toggle::before,.open>a.dropdown-toggle::after {
	display: block;
}
</style>
<nav class="navbar navbar-default"
	style="background: none repeat scroll 0 0 #fff; border-bottom: solid 1px #eee;">
	<div class="container-fluid" style="padding-left: 5px;">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" style="margin-left: 5px;">
			<ul class="nav navbar-nav">
				<!-- PlatForm -->
				<li class="dropdown user" id="header-user"
					style="border-right: solid #e8e8e8 1px;"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					style="min-width: 165px;"> <s:if
							test="#session.listPlatform!= null">
							<s:iterator value="#session.listPlatform" id="itemPlatform">
								<s:if test="#itemPlatform.platformId == #session.platform">
									<img class="platform" alt=""
										src="<s:property value="#itemPlatform.platformIcon"/>" />
									<span class="username"> <s:property
											value="#itemPlatform.platformName" />
									</span>
									<i class="fa fa-angle-down pull-right"
										style="margin-top: 5px; color: #333"></i>
								</s:if>
							</s:iterator>
						</s:if>

				</a>
					<ul class="dropdown-menu">
						<s:if test="#session.listPlatform!= null">
							<s:iterator value="#session.listPlatform" id="itemPlatform">
								<s:if test="#itemPlatform.platformId != #session.platform">
									<li><a
										onclick="setPlatForm(<s:property value="#itemPlatform.platformId"/>);">
											<img class="platform" style="width: 25px; margin-left: -5px;"
											src="<s:property value="#itemPlatform.platformIcon"/>">
											<s:property value="#itemPlatform.platformName" />
									</a></li>
								</s:if>
							</s:iterator>
						</s:if>
					</ul></li>
				<!-- \PlatForm -->

				<!-- category -->
				<li class="dropdown" id="AppCategoryHome"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-expanded="false"> <img
						src="./PAGE-STYLE/images/MenuIcon/ic-bar.png" class="icon-bar"
						style="width: 25%; margin-right: 2px;"> category
				</a>
					<ul class="dropdown-menu scroll_menu" role="menu">
						<s:if test="#session.listCategory!=null">
							<s:iterator value="#session.listCategory" id="itemCategory">
								<li id="categoryId"><a href="#"
									onclick="onClickMenuHeader('AppCategoryHome', '<s:property value="#itemCategory.categoryId" />')">
										<s:if test="#session.language == 'VI'">
											<s:property value="#itemCategory.categoryNameVi" />
										</s:if> <s:else>
											<s:property value="#itemCategory.categoryName" />
										</s:else>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li><a href="#">Error</a></li>
						</s:else>
					</ul></li>
				<!-- /category -->

				<li class="active"><a id="FetureHome" href="#"
					onclick="onClickMenuHeader(this.id);"><f:message
							key="Key_featured" /></a></li>
				<li><a id="TopChartHome" href="#"
					onclick="onClickMenuHeader(this.id);"><f:message
							key="Key_topChart" /></a></li>
				<s:if test="#attr.hasLogin != null && #attr.hasLogin == 1">
					<li><a id="FavoritesHome" href="#"
						onclick="onClickMenuHeader(this.id);"><f:message
								key="Key_favoritesList" /></a></li>
					<li><a id="HistoryHome" href="#"
						onclick="onClickMenuHeader(this.id);"><f:message
								key="Key_history" /></a></li>
					<li class="dropdown" id="YourtestingHome"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-expanded="false"> <f:message key="Key_yourTesting" /> <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"
								onclick="onclickMenuYourTesting('InvitedApp')"><f:message
										key="Key_invitedApp" /></a></li>
							<li><a href="#" onclick="onclickMenuYourTesting('MyApp')"><f:message
										key="Key_myApp" /></a></li>
						</ul></li>
				</s:if>
			</ul>
		</div>
	</div>
</nav>

<script type="text/javascript">
	function onClickMenuHeader(idHearMenu, idCategory) {
		// dua cac menu ve trang thai chua active
		unActiveAllHeadMenu();

		switch (idHearMenu) {
		// kiem tra co phai menuDropdown duoc chon hay khong
		case 'AppCategoryHome': {
			$('#' + idHearMenu).addClass('active');
			break;
		}
		default: {
			// bat trang thai active cho menu duoc chon		
			$('#' + idHearMenu).parent('li').addClass('active');
			break;
		}
		}
		// load thong tin form
		getInfoAppHeadMenu(idHearMenu, idCategory);
	}

	// xu ly rieng cho menu your testing
	function onclickMenuYourTesting(idHearMenu) {
		// dua cac menu ve trang thai chua active
		unActiveAllHeadMenu();
		// bat trang thai active cho menu your testing
		$('#YourtestingHome').addClass('active');
		// load thong tin form
		getInfoAppHeadMenu('load' + idHearMenu);
	}

	function unActiveAllHeadMenu() {
		$('#FetureHome').parent('li').closest('li').removeClass('active');
		$('#TopChartHome').parent('li').closest('li').removeClass('active');
		$('#FavoritesHome').parent('li').closest('li').removeClass('active');
		$('#HistoryHome').parent('li').closest('li').removeClass('active');
		$('#YourtestingHome').removeClass('active');
		$('#AppCategoryHome').removeClass('active');
		$(window).unbind("scroll");
	}

	function getInfoAppHeadMenu(action, idCategory, actionYourTesting) {
		if (navigator.onLine) {
			// Show loading
			showOverlay(EN_MESSAGE.Key_loading, VI_MESSAGE.Key_loading);
			$.ajax({
				type : 'post',
				url : 'Home!' + action + '.do',
				timeout : G_MESSAGE.globalTimeOut,
				dataType : 'html',
				data : JSON.stringify({
					'idCategory' : idCategory,
					'actionYourTesting' : actionYourTesting,
					"countLoad" : 1
				// load lan dau tien
				}),
				contentType : 'application/json',
				async : true,
				success : function(response) {
					var fileContent = response.trim();
					if (fileContent === 'error') {
						showAlertMessage(EN_MESSAGE.Key_loading_list_app,
								VI_MESSAGE.Key_loading_list_app);
					} else {
						$("#content").html(response);
					}

					hideOverlay();
				},
				error : function(response) {
					hideOverlay();
					showAlertMessage(EN_MESSAGE.Key_loading_list_app,
							VI_MESSAGE.Key_loading_list_app);
				}
			});
		} else {
			showAlertMessage(EN_MESSAGE.Key_loading_list_app,
					VI_MESSAGE.Key_loading_list_app);
		}
	};

	
</script>