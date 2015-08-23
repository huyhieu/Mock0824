<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<link href="./PAGE-STYLE/css/pages/styleDetailApi.css" type="text/css" rel="stylesheet" />
<style>
<!--
input[type="radio"] {
	margin-left: 20px;
	margin-top: 0;
}

button.btn.btn-default.dropdown-toggle {
	border-top-right-radius: 0;
	border-bottom-right-radius: 0;
}

.action {
	border-top-left-radius: 0;
	border-bottom-left-radius: 0;
}

.verb {
	padding-top: 6px;
}
-->
</style>
<div style="padding: 10px 10px 10px 20px">
	<div class="row">
		<div class="col-xs-8" style="margin-top: 20px;">
			<span style="color: #222; font-size: 18px; font-weight: 400; line-height: 31px; text-transform: uppercase;">
				Tên dự án </span>
		</div>
		<div class="col-xs-3">
			<button class="btn btn-primary pull-right" id="btn_saved_price" onclick="saveStoreListingInfor();"
				style="margin-right: -45px;">Lưu</button>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="pull-right">
				<p class="star">Những thông tin chưa dấu * là bắt buột nhập</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="store_listing">
			<div class="box-body big">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-12" style="border-bottom: 1px solid #e9e9e9;">
							<p class="title_product_detail">Chi tiết API</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<p class="name_field">Tên hiển thị</p>
							<p class="star">*</p>
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="appTitle_SL" id="appTitle_SL" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<p class="name_field">Đường dẫn</p>
							<p class="star">*</p>
						</label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1"
									style="border-top-right-radius: 0; border-bottom-right-radius: 0;">localhost:8080/MockService/V2/</span>
								<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"
									style="border-top-left-radius: 0; border-bottom-left-radius: 0;">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<p class="name_field">Phương thức</p>
							<p class="star">*</p>
						</label>
						<div class="col-sm-10">
							<div class="col-sm-2 verb">
								<input type="radio" aria-label="Radio button for following text input">
								<p class="name_field">Get</p>
							</div>
							<div class="col-sm-2 verb">
								<input type="radio" aria-label="Radio button for following text input">
								<p class="name_field">Post</p>
							</div>
							<div class="col-sm-2 verb">
								<input type="radio" aria-label="Radio button for following text input">
								<p class="name_field">Put</p>
							</div>
							<div class="col-sm-2 verb">
								<input type="radio" aria-label="Radio button for following text input">
								<p class="name_field">Path</p>
							</div>
							<div class="col-sm-2 verb">
								<input type="radio" aria-label="Radio button for following text input">
								<p class="name_field">Delete</p>
							</div>
							<div class="col-sm-2 verb">
								<input type="radio" aria-label="Radio button for following text input">
								<p class="name_field">Options</p>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<p class="name_field">Đầu vào</p>
							<p class="star">*</p>
						</label>
						<div class="col-sm-10">
							<div class="input-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										Action
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li>
											<a>application/json</a>
										</li>
										<li>
											<a>application/xml</a>
										</li>
										<li>
											<a>text/xml</a>
										</li>
										<li>
											<a>text/json</a>
										</li>
										<li>
											<a>text/plain</a>
										</li>
									</ul>
								</div>
								<!-- /btn-group -->
								<input type="text" class="form-control action" aria-label="...">
							</div>
							<!-- /input-group -->
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<p class="name_field">Đầu ra</p>
							<p class="star">*</p>
						</label>
						<div class="col-sm-10">
							<div class="input-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										Action
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li>
											<a>application/json</a>
										</li>
										<li>
											<a>application/xml</a>
										</li>
										<li>
											<a>text/xml</a>
										</li>
										<li>
											<a>text/json</a>
										</li>
										<li>
											<a>text/plain</a>
										</li>
									</ul>
								</div>
								<!-- /btn-group -->
								<input type="text" class="form-control action" aria-label="...">
							</div>
							<!-- /input-group -->
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12" style="border-bottom: 1px solid #e9e9e9;">
							<p class="title_product_detail">Cấu hình</p>
						</div>
					</div>
					<div class="form-group">
						<div class="header-config" data-example-id="simple-nav-tabs">
							<ul class="nav nav-tabs">
								<li role="presentation" class="active">
									<a href="#">Defailt</a>
								</li>
								<li role="presentation">
									<a href="#">Custome</a>
								</li>
							</ul>
						</div>
						<div class="content_config" id="content_config">							
							
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12" style="border-bottom: 1px solid #e9e9e9;">
							<p class="title_product_detail">Chi tiết</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<p class="name_field">Chú thích cho API</p>
						</label>
						<div class="col-sm-10">
							<textarea onkeyup="countLenghtInput('fullDes_SL', 'sttFullDes_SL', 50, 2000)" rows="6" cols=""
								class="form-control" name="fullDes_SL" id="fullDes_SL" placeholder="Nội dung chú thích">  </textarea>
							<p class="status_text" id="sttFullDes_SL"></p>
						</div>
					</div>
			</div>
		</div>
	</div>
</div>

<script>
function switchTab(tab) {
	selectedTab = tab;	
	doShowReport(inputDateType, beginDate, endDate, dropdownText,
			dropdownText);
};

function switchTab(tab) {

	var actionUrl = '';
	if (tab == 1) {
		actionUrl = 'showDefaultRespone.do';

	} else if (tab == 2) {
		actionUrl = 'showCustomizeReponse.do';

	} else {
		return;
	}
	showProgressIcon();
	$
			.ajax({
				type : 'POST',
				url : actionUrl,
				timeout : JQUERY_MESSAGE_CLASS.globalTimeOut,
				dataType : 'html',
				contentType : 'application/json',
				data : JSON.stringify({
					"endDate" : stopDate
				}),
				async : true,
				success : function(response) {

					
						$("#report_content").html(response);
						
						hideLoading();
					
				},
				error : function(response) {
					
				}
			});
};

</script>