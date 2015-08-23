<%@page pageEncoding="UTF-8"%>

<style type="text/css">
.list-request {
	max-width: 100%;
	padding: 10px;
	border-radius: 3px;
}

.glyphicon {
	margin-right: 10px;
}

.panel-body {
	padding: 0px;
}

.panel-body table tr td {
	padding-left: 15px
}

.panel-body .table {
	margin-bottom: 0px;
}
</style>


<div>
	<!-- LIST PROJECT HEADER -->
	<div class="row" style="margin-bottom: 12px;">
		<div class="col-xs-12">
			<b> DANH SÁCH ỨNG DỤNG </b> <img
				style="width: 15px; height: 15px; float: right; cursor: pointer;"
				onclick="showDialogAddNewProject();"
				src="./PAGE-STYLE/images/project/ic_add_project.png" />
		</div>
	</div>

	<!-- LIST PROJECT CONTENT -->
	<div id="list_project_content"
		style="height: 400px; overflow-y: scroll; overflow-x: hidden;">
		<jsp:include page="/Form/PartPage/ListProject.jsp"></jsp:include>
	</div>

	<!-- LIST PROJECT FOOTER -->
	<div class="row">
		<div class="col-md-6">
			<span onclick="showDialogImportProject();" style="cursor: pointer;">
				Nạp dữ liệu <img style="width: 15px; height: 15px;"
				class="icon-download-alt"
				src="./PAGE-STYLE/images/project/ic_import.png" />
			</span>
		</div>
		<div class="col-md-6">
			<span onclick="showDialogExportProject();" style="cursor: pointer;">
				Xuất dữ liệu <img style="width: 15px; height: 15px;"
				class="icon-download-alt"
				src="./PAGE-STYLE/images/project/ic_export.png" />
			</span>
		</div>
	</div>
</div>

<script src="./PAGE-SCRIPT/project/project_script.js"></script>
<script src="./PAGE-SCRIPT/project/import_export_project.js"></script>
<script type="text/javascript">
	//When page is loaded, called this function to get list project
	$(document).ready(function() {
		getListProject();
	});

	// Get list project owned by this user
	function getListProject() {
		$.ajax({
			type : 'POST',
			url : 'getListProject.html',
			timeout : G_MESSAGE.globalTimeOut,
			dataType : 'html',
			contentType : 'application/json',
			data : JSON.stringify({}),
			async : true,
			success : function(response) {
				$('#list_project_content').html(response.trim());

				fireListApiTree();

				hidePageModal(false);
			},
			error : function(response) {
				alert('Có lỗi xãy ra khi thực hiện lấy danh sách API!');
			}
		});
	};

	// Make tree view valuable
	function fireListApiTree() {
		$("#tree_list_project").jstree('destroy');
		$('#tree_list_project').jstree({
			'plugins' : [ "wholerow" ],
			'core' : {
				'themes' : {
					'name' : 'proton',
					'responsive' : true
				}
			}
		});
	};
</script>