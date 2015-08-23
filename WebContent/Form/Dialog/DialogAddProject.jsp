<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h5 class="modal-title" id="myModalLabel">
			<b>THÊM MỚI DỰ ÁN</b>
		</h5>
	</div>
	<form:form id="add_project_form" name="add_project_form"
		commandName="projectForm" action="addNewProject.html" method="post"
		style="margin-top: 10px;">
		<div class="modal-body">
			<div class="form-group">
				<input type="text" name="projectName" placeholder="Nhập tên dự án"
					class="form-control" required="required"
					data-fv-notempty-message="Vui lòng nhập tên dự án" />
			</div>
		</div>
		<div class="modal-footer">
			<div class="text-left vertical-center col-xs-6 hidden"></div>

			<div class="pull-right">
				<input type="submit" class="btn btn-primary" value="Thêm Mới">
				<input type="button" class="btn btn-default" value="Đóng"
					data-dismiss="modal">
			</div>
		</div>
	</form:form>
</div>



