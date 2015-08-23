<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<style>
.carousel-inner>.item>img,.carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}

a.ads.banner-2 {
	padding: 4px 4px 3px 4px;
}

img.lazy {
	border: 0px #fff solid;
	width: 95%;
	background-position: center center !important;
	padding: 2px 0px;
	height: auto;
	background-size: 100% 100% !important;
	background-repeat: no-repeat !important;
}

.col-xs-6.col-sm-6 {
	margin: 0;
	padding: 0px;
}

span.paragraph-end {
	background-image: -webkit-linear-gradient(left, rgba(255, 255, 255, 0),
		rgba(255, 255, 255, 1) );
	bottom: 0;
	max-height: 100%;
	position: absolute;
	right: 0;
	height: 22px;
	width: 45px;
	margin-bottom: 72px;
}

.appName {
	overflow: hidden;
	position: relative;
	white-space: nowrap;
}

img.AppIcon {
	border: 0px #fff solid;
	width: 100%;
	background-position: center center !important;
	height: 100%;
	background-size: 100% 100% !important;
	background-repeat: no-repeat !important;
	border-radius: 10px;
}

.appContent {
	border: 1px solid #ddd;
	padding: 12px;
	margin-bottom: 8px;
	border-radius: 3px;
	background-color: #fff;
	box-shadow: 1px 2px 7px #ddd;
}

.devName {
	display: block;
	width: 100%;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	color: #999999;
	font-size: 12px;
	font-weight: normal;
}
</style>

<style>
.box-app {
	position: relative;
	clear: both;
}

.row {
	margin-right: -4px;
	margin-left: -4px;
}

.block-main { /* padding-right: 280px; */
	
}

.block-list,.block-collection {
	position: relative;
}

.header {
	padding-right: 4px;
	padding-left: 4px;
	min-height: 64px;
	font-family: 'Roboto Condensed', sans-serif;
	clear: both;
}

.col-list {
	clear: both;
	overflow: hidden;
}

.header h3,.header h2,.header h1 {
	font-weight: normal;
	line-height: 64px;
	margin: 0;
	padding: 0;
	width: auto;
	white-space: nowrap;
	text-overflow: ellipsis;
	float: left;
	font-family: 'Roboto Condensed', sans-serif;
}

.thumbnail {
	display: block;
	position: relative;
	overflow: hidden;
	padding: 12px;
	margin-bottom: 8px;
	line-height: 1.42857143;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 3px;
	-webkit-transition: all .2s ease-in-out;
	-o-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
	box-shadow: 1px 2px 7px #ddd;
}

.thumbnail .caption {
	padding: 0px;
	color: #333;
}

.thumbnail .picCard a {
	display: block;
	-webkit-background-size: 100% 100%;
	background-size: 100% 100%;
	position: relative;
}

a {
	color: #444444;
	text-decoration: none !important;
}

.titleCard {
	margin-bottom: 4px;
}

.subCard,.subCard a {
	display: block;
	width: 100%;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	color: #999999;
	font-size: 12px;
	font-weight: normal;
}

.subCard {
	margin-bottom: 8px;
}

.btnCard {
	margin: 0;
	display: block;
	clear: both;
}

.titleCard a {
	display: block;
	width: 100%;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	font-weight: 400;
}

.subCard,.subCard a {
	display: block;
	width: 100%;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	color: #999999;
	font-size: 12px;
	font-weight: normal;
}

.btnCard a {
	display: block;
	font-weight: 600;
}

.btn-default {
	color: #333;
	background-color: #fff;
	border-color: #DDDDDD;
}

.header>button {
	margin-top: 20px;
	background: #1bb3ca;
	color: #fff;
	border-radius: 2px;
	border: 0;
}
</style>


<div class="ads-inner">
	<div class="ads-left col-md-6">
		<div class="contaisner" style="width: 100%">
			<br>
			<div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: auto;">
				<ol class="carousel-indicators">
					<s:if test="#session.listAppMostDownLoadWeek.size!=0">
						<s:iterator value="#session.listAppMostDownLoadWeek" id="itemSlide">
							<s:if test="#itemSlide.id==0">
								<li data-target="#myCarousel" data-slide-to='<s:property value="#itemSlide.id"/>' class="active"></li>
							</s:if>
							<s:else>
								<li data-target="#myCarousel" data-slide-to='<s:property value="#itemSlide.id"/>' class=""></li>
							</s:else>
						</s:iterator>
					</s:if>
				</ol>
				<div class="carousel-inner" role="listbox" style="height: auto;">
					<s:if test="#session.listAppMostDownLoadWeek.size!=0">
						<s:iterator value="#session.listAppMostDownLoadWeek" id="itemSlide">
							<s:if test="#itemSlide.id==0">
								<div class="item active">
									<a href="./AppDetail!showAppDetail.do?release=1&id=<s:property value="#itemSlide.bundleId"/>"> <img
											src="<s:property value="#itemSlide.featureGraphic"/>" alt="FeatureGraphic" width="460" style="width: 100%;">
									</a>
								</div>
							</s:if>
							<s:else>
								<div class="item">
									<a href="./AppDetail!showAppDetail.do?release=1&id=<s:property value="#itemSlide.bundleId"/>"> <img
											src="<s:property value="#itemSlide.featureGraphic"/>" alt="FeatureGraphic" width="460" style="width: 100%;">
									</a>
								</div>
							</s:else>
						</s:iterator>
					</s:if>
				</div>
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<div id="most_content" class="ads-right col-md-6">
		<br>
		<s:if test="#session.listAppMostDownLoadWeek.size > 0">
			<div class="ads-11 col-xs-6 col-sm-6">
				<a class="ads banner-2"
					href="./AppDetail!showAppDetail.do?release=1&id=<s:property value="#session.listAppMostDownLoadWeek[0].bundleId"/>"> <img
						class="lazy" src="<s:property value="#session.listAppMostDownLoadWeek[0].featureGraphic" />">
				</a>
			</div>
		</s:if>
		<s:else>
			<div class="ads-11 col-xs-6 col-sm-6">
				<a class="ads banner-2"> <img class="lazy"
						src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/share/5470/79e3110b-a2e6-4fb9-af9f-7a92dfecc47a1c9b3f56586119b31a416791760b7bdc.png">
				</a>
			</div>
		</s:else>
		<s:if test="#session.listAppMostDownLoadWeek.size > 1">
			<div class="ads-12 col-xs-6 col-sm-6">
				<a class="ads banner-2"
					href="./AppDetail!showAppDetail.do?release=1&id=<s:property value="#session.listAppMostDownLoadWeek[1].bundleId"/>"> <img
						class="lazy" src="<s:property value="#session.listAppMostDownLoadWeek[1].featureGraphic" />">
				</a>
			</div>
		</s:if>
		<s:else>
			<div class="ads-11 col-xs-6 col-sm-6">
				<a class="ads banner-2"> <img class="lazy"
						src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/share/5470/79e3110b-a2e6-4fb9-af9f-7a92dfecc47a1c9b3f56586119b31a416791760b7bdc.png">
				</a>
			</div>
		</s:else>

		<s:if test="#session.listAppMostRatingWeek.size > 0">
			<div class="ads-21 col-xs-6 col-sm-6">
				<a class="ads banner-2"
					href="./AppDetail!showAppDetail.do?release=1&id=<s:property value="#session.listAppMostRatingWeek[0].bundleId"/>"> <img
						class="lazy" src="<s:property value="#session.listAppMostRatingWeek[0].featureGraphic" />">
				</a>
			</div>
		</s:if>
		<s:else>
			<div class="ads-11 col-xs-6 col-sm-6">
				<a class="ads banner-2"> <img class="lazy"
						src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/share/5470/79e3110b-a2e6-4fb9-af9f-7a92dfecc47a1c9b3f56586119b31a416791760b7bdc.png">
				</a>
			</div>
		</s:else>
		<s:if test="#session.listAppMostRatingWeek.size > 1">
			<div class="ads-22 col-xs-6 col-sm-6">
				<a class="ads banner-2"
					href="./AppDetail!showAppDetail.do?release=1&id=<s:property value="#session.listAppMostRatingWeek[1].bundleId"/>"> <img
						class="lazy" src="<s:property value="#session.listAppMostRatingWeek[1].featureGraphic" />">
				</a>
			</div>
		</s:if>
		<s:else>
			<div class="ads-11 col-xs-6 col-sm-6">
				<a class="ads banner-2"> <img class="lazy"
						src="https://viettelappstore.com:19086/VPMTStore/PAGE-STYLE/share/5470/79e3110b-a2e6-4fb9-af9f-7a92dfecc47a1c9b3f56586119b31a416791760b7bdc.png">
				</a>
			</div>
		</s:else>
	</div>
</div>
<div id="contentListApp">
	<tiles:insertAttribute name="contentApp" />
</div>

<script type="text/javascript">
	function getSeeAll(action, categoryTitle) {
		if (navigator.onLine) {
			// Show loading
			showOverlay(EN_MESSAGE.Key_loading, VI_MESSAGE.Key_loading);
			$.ajax({
				type : 'post',
				url : 'Home!load' + action + '.do',
				timeout : G_MESSAGE.globalTimeOut,
				data : JSON.stringify({
					"countLoad" : 1,
					"categoryTitle" : categoryTitle
				// load lan dau tien
				}),
				dataType : 'html',
				contentType : 'application/json',
				async : true,
				success : function(response) {
					var fileContent = response.trim();
					if (fileContent === 'error') {
						showAlertMessage(EN_MESSAGE.Key_loadapp_error,
								VI_MESSAGE.Key_loadapp_error);
					} else {
						$("#content").html(response);
					}
					hideOverlay();
				},
				error : function(response) {
					hideOverlay();
					showAlertMessage(EN_MESSAGE.Key_loadapp_error,
							VI_MESSAGE.Key_loadapp_error);
				}
			});
		} else {
			showAlertMessage(EN_MESSAGE.Key_loadapp_error,
					VI_MESSAGE.Key_loadapp_error);
		}
	};
</script>
