<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="./PAGE-SCRIPT/jquery/jstree/dist/themes/proton/style.css" />
<link rel="stylesheet" href="./PAGE-SCRIPT/jquery/jstree/docs.css" />

<style>
.panel-background {
	margin-bottom: 0;
	border-radius: 4px;
	overflow: hidden;
	border-radius: 4px;
}

.panel-background .panel-heading {
	padding: 0px 0px !important;
	padding-top: 5px !important;
	padding-left: 15px !important;
	border: 3px;
	padding-top: 5px !important;
}

.panel-project {
	background-color: inherit !important;
}

.panel-group-parent {
	padding-left: 10px;
}

.panel-group .panel-group-service {
	position: relative;
	display: block;
	margin-bottom: 0px;
}

.panel-group .panel-group-request {
	position: relative;
	display: block;
	margin-left: 20px;
	margin-bottom: 0px;
}

.icon_project {
	width: 20px;
	height: 20px;
	float: left;
	background-repeat: no-repeat;
	background-size: contain;
	background-image: url('./PAGE-STYLE/images/project/ic_project.png');
	background-repeat: no-repeat;
}

.icon_service {
	width: 20px;
	height: 20px;
	float: left;
	background-repeat: no-repeat;
	background-size: contain;
	background-image: url('./PAGE-STYLE/images/project/ic_service.png');
}

.icon_request {
	width: 20px;
	height: 20px;
	float: left;
	background-repeat: no-repeat;
	background-size: contain;
	background-image: url('./PAGE-STYLE/images/project/ic_request.png');
	float: left;
}

.panel-item-title {
	display: inline;
	padding: 3px;
	cursor: pointer
}

.accordion-heading>a {
	white-space: nowrap;
	width: 8em;
	overflow: hidden;
	text-overflow: ellipsis;
}

.accordion-heading>span {
	margin-right: 20px;
	margin-top: -28px;
}
</style>

<div class="row">
	<div class="panel-group" id="accordionRoot"
		style="margin: 0 !important;">
		<c:forEach items="${list_api_key}" var="project">
			<!-- PROJECT -->
			<div class="panel-background">
				<div class="panel-heading">
					<div class="panel-title" data-toggle="collapse"
						data-parent="#accordionRoot"
						onclick="expandCollapse(this, 'collapseP<c:out value="${project.nodeID}"/>');">
						<!-- Icon -->
						<span class="glyphicon icon_project"> </span>
						<!-- Project name -->
						<a class="panel-item-title"> ${project.name} </a>
						<!-- Edit -->
						<span class="glyphicon icon_project"
							style="float: right !important; display: none;"> </span>
					</div>
				</div>
				<div id="collapseP<c:out value="${project.nodeID}"/>"
					class="panel-collapse collapse">
					<ul class="panel-group-parent">
						<li class="panel-group-service">
							<!--  -->
							<div class="panel-group" style="margin: 0 !important;"
								id="accordionP<c:out value="${project.nodeID}"/>">
								<c:forEach items="${project.htmlParses}" var="service">
									<!-- SERVICE -->
									<div class="panel-background">
										<div class="panel-heading">
											<div class="panel-title" data-toggle="collapse"
												data-parent="#accordionP<c:out value="${project.nodeID}"/>"
												onclick="expandCollapse(this, 'collapseS<c:out value="${service.nodeID}"/>');">
												<!-- Icon -->
												<span class="glyphicon icon_service"> </span>
												<!-- Service name -->
												<a class="panel-item-title"> ${service.name} </a>
												<!-- Edit -->
												<span class="glyphicon icon_service"
													style="float: right !important; display: none;"> </span>
											</div>
										</div>
										<div id="collapseS<c:out value="${service.nodeID}"/>"
											class="panel-collapse collapse">
											<ul class="panel-group-parent">
												<c:forEach items="${service.htmlParses}" var="request">
													<!-- REQUEST  -->
													<div class="row panel-group-request">
														<!-- Icon -->
														<span class="glyphicon icon_request"> </span>
														<!-- Request name -->
														<a class="panel-item-title"
															onclick="showRequestContent('<c:out value="${request.nodeID}"/>');">${request.name}</a>
														<!-- Edit -->
														<span class="glyphicon icon_request"
															style="float: right !important; display: none;"> </span>
													</div>
												</c:forEach>
											</ul>
										</div>
									</div>
								</c:forEach>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<script src="./PAGE-SCRIPT/jquery/jstree/dist/jstree.min.js"></script>
<script type="text/javascript">
	function expandCollapse(row, child) {
		var list = $('#' + child).attr('class').split(' ');
		var opened = false;
		for ( var i = 0; i < list.length; i++) {
			if (list[i] === 'in') {
				opened = true;
			}
		}
		if (opened) {
			$('#' + child).removeClass('in');
		} else {
			$('#' + child).addClass('in');
		}
	};

	function showRequestContent(requestId) {
		alert('RequestID=' + requestId);
	};
</script>