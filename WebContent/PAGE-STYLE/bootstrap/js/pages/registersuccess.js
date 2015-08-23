$('#sendemail').on('click', function(e) {
	$('.send-has-error').text('');

	showProcesingModal(true);
	var dataObj = {
		"recipient" : $('#email').val(),
	};

	$.ajax({
		type : 'POST',
		url : 'sendVerifyEmail.do',
		data : JSON.stringify(dataObj),
		dataType : 'json',
		contentType : "application/json",
		async : true,
		success : function(response) {
			if (response.isSent === "success") {
				// showSuccess("Information account confirmation has been sent
				// to your email.");
				showProcesingModal(false);
			} else
				showError('.send-has-error', G_MESSAGE.globalErrorMsg);
		},
		error : function(returnData) {
			showError('.send-has-error', G_MESSAGE.globalErrorMsg);
		}
	});
});