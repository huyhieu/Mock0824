function centerModal() {
	$(this).css('display', 'block');
	var $dialog = $(this).find(".modal-dialog");

	// Center modal vertically in window
	var offset = ($(window).height() - $dialog.height()) / 2;
	$dialog.css("margin-top", offset);

	// if process dialog -> resize
	if ($dialog.hasClass('processing')) {
		$dialog.css("width", "130px");
		$('#procesingModal .modal-content').css('background', 'none');
		$('#procesingModal .modal-content').css('box-shadow', 'none');
		$('#procesingModal .modal-content').css('border', 'none');
	}
}

$('.modal').on('show.bs.modal', centerModal);
$(window).on("resize", function() {
	$('.modal:visible').each(centerModal);
});

function showProcesingModal(isShow) {
	if ($('#procesingModal')) {
		if (isShow) {
			$('#procesingModal').modal({
				"backdrop" : "static"
			});
		} else {
			$('#procesingModal').modal('toggle');
		}
	}
};

function showPageModal(isShow, content) {
	if ($('#pageModal')) {
		if (isShow) {
			$('#pageModal .modal-body').html(content);
			$('#pageModal').modal({
				"backdrop" : "static"
			});
		} else {
			$('#pageModal').modal('toggle');
		}
	}
}

function hidePageModal() {
	$('#pageModal').modal('hide');
};

function showError(classOrId, msg) {
	if ($(classOrId)) {
		$(classOrId).text(msg);
		showProcesingModal(false);
	}
}

function showSuccess(classOrId, msg) {
	if ($(classOrId)) {

	}
}

if ($("#closeButton")) {
	$("#closeButton").click(function() {
		showPageModal(false);
	});
}

function showDialog(title_, message_, callback_) {
	BootstrapDialog.confirm({
		title : title_,
		message : message_,
		type : BootstrapDialog.TYPE_WARNING,
		closable : true, // <-- Default value is false
		draggable : true, // <-- Default value is false
		btnCancelLabel : 'Cancel', // <-- Default value is 'Cancel',
		btnOKLabel : 'OK', // <-- Default value is 'OK',
		btnOKClass : 'btn btn-primary', // <-- If you didn't specify it, dialog
		// type will be used,
		callback : function(result) {
			if (result) {
				callback_();
			}
		}
	});
};

function showAppDetail(appId) {
	$.ajax({
		type : 'POST',
		url : 'AppDetail!' + 'showAppDetail.do',
		timeout : G_MESSAGE.globalTimeOut,
		dataType : 'html',
		contentType : 'application/json',
		data : JSON.stringify({
			"appId" : appId
		}),
		async : true,
		success : function(response) {
			var status = response.trim();
			if (status === 'error') {
				showAlertMessage(EN_MESSAGE.Key_loading_appdetail,
						VI_MESSAGE.Key_loading_appdetail);
			} else {
				// Show data on div
				$('#app_detail').html(response);
			}
		},
		error : function(response) {
			showAlertMessage(EN_MESSAGE.Key_loading_appdetail,
					VI_MESSAGE.Key_loading_appdetail);
		}
	});
};
