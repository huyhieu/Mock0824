<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h5 class="modal-title" id="myModalLabel">
			<b>XUẤT DỮ LIỆU</b>
		</h5>
	</div>
	<form:form id="export_project_form" name="export_project_form"
		commandName="exportProjectForm" action="exportProject.html"
		method="post" style="margin-top: 10px;">
		<div class="modal-body">
			<div class="form-group">
				<div class="row">
					<div class="col-md-3">
						<label for="fileName">Tên tệp tin</label>
					</div>
					<div class="col-md-5">
						<input id="exportFileName" type="text" name="fileName"
							placeholder="Nhập tên tệp tin" class="form-control"
							required="required"
							data-fv-notempty-message="Vui lòng nhập tên tệp tin" />
					</div>
					<div class="col-md-4">
						<select id="sl_export_type" class="form-control"
							style="width: auto !important;">
							<option id="1">Tất cả</option>
							<option id="2">.json</option>
							<option id="3">.java(Java)</option>
							<option id="4">.java(C#)</option>
						</select>
					</div>
				</div>
			</div>
			<div style="height: 400px; overflow-y: scroll; overflow-x: hidden;">
				<!-- Show list request -->
				<div class="row">
					<div class="col-md-3">
						<label>Danh sách API</label>
					</div>
					<div class="col-md-9">
						<div id="list_request" class="list-request"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<div class="text-left vertical-center col-xs-6 hidden"></div>

			<div class="pull-right">
				<input type="submit" class="btn btn-primary" value="Xuất Dữ Liệu">
				<input type="button" class="btn btn-default" value="Đóng"
					data-dismiss="modal">
			</div>
		</div>
	</form:form>
</div>



