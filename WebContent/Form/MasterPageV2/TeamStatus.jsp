<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<div class="container team-status" id="team-status">
	<div id="scrollbar">
		<div class="handle"></div>
	</div>
	<div id="teamslider">
			<ul class="team-list">

						<li class="current">
					<a href="javascript:void(0);"
						onclick="doParentUserClicked(1);">
						<span class="image">
							<img src="./PAGE-STYLE/images/no-avatar.jpg" alt="" />
						</span> <span class="title">
							userFullName
						</span>
						<div class="progress">
							<div class="progress-bar progress-bar-success"
								style="width: 100%">
								<span class="sr-only">100% Complete (success)</span>
							</div>
						</div> <span class="status" style="display: none;">
							<div class="field">
								<span class="badge badge-orange">3</span>
								Project
								<span class="pull-right fa fa-adjust"></span>
							</div>
						</span>
					</a>
					</li>
			</ul>
	</div>
</div>