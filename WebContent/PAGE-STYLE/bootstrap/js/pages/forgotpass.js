// Processing for capcha
$(".LBD_CaptchaImageDiv a").remove();
$("#ajaxValidatedCaptcha_SoundIcon").remove();
$("#captchaCodeTextBox").change(function() {
	value = $("#captchaCodeTextBox").val();
	$("#captchaCodeTextBox").val($.trim(value));
	if (($.trim($("#captchaCodeTextBox").val())).length > 0) {
		ajaxValidatedCaptcha.Validate();
		return false;
	}
});

// validtion form
$('#regiter_form').on('submit', function(e) {
	$('.send-has-error').text('');
});

$('#regiter_form').formValidation({
	framework : 'bootstrap',
	onError : function(e) {
		ajaxValidatedCaptcha.Validate();
	},
}).on(
		'success.form.fv',
		function(e) {

			// alert(1);
			captchaValid = ajaxValidatedCaptcha.Validate();
			if (!captchaValid) {
				showErrorMessage("divForCaptcha");
				return false;
			} else {
				hideErrorMessage("divForCaptcha");

				showProcesingModal(true);
				$.ajax({
					type : 'POST',
					url : 'sendFogotPassEmail.do',
					timeout : G_MESSAGE.globalTimeOut,
					data : JSON.stringify({
						"recipient" : $("#email").val().trim()
					}),
					dataType : 'json',
					contentType : 'application/json',
					async : true,
					success : function(response) {

						var status = response.isSent;

						if (status === "success") {
							window.location.replace('GetPassWordLink.do');

						} else if (status === "locked") {
							showError('.send-has-error',
									G_MESSAGE.ACCOUNT_IS_LOCK);

						} else if (status === "notactived") {
							showError('.send-has-error',
									G_MESSAGE.ACCOUNT_IS_NOT_ACTIVED);

						} else if (status === "notExisted") {
							showError('.send-has-error',
									G_MESSAGE.EmailNotExisted);

						} else if (status === "fail") {
							showError('.send-has-error',
									G_MESSAGE.Email_cannot_send);

						} else {
							showError('.send-has-error',
									G_MESSAGE.globalErrorMsg);
						}
					},
					error : function(response) {
						showError('.send-has-error', G_MESSAGE.globalErrorMsg);

					}
				});

				return false;
			}
		});

function hideErrorMessage(control_id) {
	$("#" + control_id).hide();
	$("#" + control_id).css('display', 'none');
}

function showErrorMessage(control_id, isShown) {
	$("#" + control_id).show();
	$("#" + control_id).css('display', 'block');
}
