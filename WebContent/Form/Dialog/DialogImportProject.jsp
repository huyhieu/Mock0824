<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Style -->
<style>
.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity =                                 0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}
</style>

<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h5 class="modal-title" id="myModalLabel">
			<b>NẠP DỮ LIỆU</b>
		</h5>
	</div>
	<div class="modal-body" style="margin-top: 10px;">
		<div style="height: 400px; overflow-y: scroll; overflow-x: hidden;">
			<div class="row">
				<div class="col-md-3">Chọn tệp tin:</div>
				<div class="col-md-9">
					<form id="fm_import_json" method="post"
						enctype="multipart/form-data">
						<span class="btn btn-default btn-file"> Chọn <input
							id="file" type="file" name="file">
						</span>
						<div style="display: inline;" id="selected_file_name"></div>
						<div id="fm_import_json_error" style="color: red;"></div>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">Danh sách API:</div>
				<div class="col-md-9">
					<div id="list_request_import" class="list-request"></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div id="no_api_choosen" class="col-md-9" style="color: red;"></div>
		</div>
		<div class="row">
			<div class="col-md-3">Thao tác:</div>
			<div class="col-md-9"
				style="vertical-align: middle; line-height: 30px; margin-bottom: 0px !important;">
				<div class="form-group"
					style="width: auto !important; display: inline; float: left;">
					<select id="sl_action" class="form-control"
						style="width: auto !important;">
						<option id="1">Cập nhật</option>
						<option id="2">Ghi đè</option>
					</select>
				</div>
				<div style="display: inline; margin-left: 10px;">dữ liệu đã
					tồn tại</div>
			</div>
		</div>
	</div>

	<div class="modal-footer">
		<div class="text-left vertical-center col-xs-6 hidden"></div>
		<div class="pull-right">
			<input type="button" class="btn btn-primary" value="Nạp dữ liệu"
				onclick="importProjects();"> <input type="button"
				class="btn btn-default" value="Đóng" data-dismiss="modal">
		</div>
	</div>
</div>