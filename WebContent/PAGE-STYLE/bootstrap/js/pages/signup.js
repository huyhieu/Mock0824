$('#birthday').datepicker({
	format : "dd/mm/yyyy"
});

// Choose gender
$(".dropdown-menu li a").click(
		function() {
			var selText = $(this).text();
			$(this).parents('.btn-group').find('.dropdown-toggle').html(
					selText + ' <span class="caret"></span>');
		});

$("#btnSearch").click(function() {
});

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
	$('.regist-has-error').text('');
});

$('#birthday').on('changeDate show', function(e) {
	// Revalidate the date when user change it
	$('#regiter_form').bootstrapValidator('revalidateField', 'birthday');
});

$('#term_condition').on('click', function(e) {
	showProcesingModal(true);
	$.ajax({
		type : 'POST',
		url : "showTermConditions.do",
		timeout : G_MESSAGE.globalTimeOut,
		dataType : 'html',
		data : JSON.stringify({
			"isTermCondition" : 1,
			"termType" : 1
		}),
		async : true,
		success : function(response) {
			showPageModal(true, response);
			showProcesingModal(false);
		},
		error : function(response) {
			showError('.regist-has-error', G_MESSAGE.globalErrorMsg);
		},
	});
	return false;
});
$('#regiter_form').formValidation({
	framework : 'bootstrap',
	icon : {},
	fields : {
		confirmPassword : {
			validators : {
				identical : {
					field : 'password',
					message : 'The password are not the same the confirm password.'
				}
			}
		},
		birthday : {
			validators : {
				date : {
					format : 'DD/MM/YYYY',
					message : 'The value is not a valid date'
				}
			}
		}
	}
}).on('success.form.fv', function(e) {
	
});

function registerAccount() {
	var fullName = $("#fullname").val();
	var birthday = $("#birthday").val();
	var gender = $('#gender').text();
	var email = $("#email").val();
	var password = $("#password").val();
	var platformDefault = $("#platformDefault").text();

	var dataObj = {
		"formRegister" : {
			"fullName" : fullName,
			"passWord" : password,
			"email" : email,
			"birthday" : birthday,
			"gender" : gender,
			"platformDefault" : platformDefault,
			"isRegister" : 1
		}
	};

	var data = JSON.stringify(dataObj);

	$.ajax({
		type : 'POST',
		url : 'registerUserAccount.do',
		timeout : G_MESSAGE.globalTimeOut,
		data : data,
		dataType : 'json',
		contentType : "application/json",
		async : true,
		success : function(response) {
			var message = response.isRegisterSuccessfull;
			if (message === "success") {
				location.href = "registerSuccessful.do";
			} else if (message === "existed") {
				showError('.regist-has-error',
						'Your email account is already exists.');
			} else if (message === "invalidEmail") {
				showError('.regist-has-error', "Invalid email format.");
			} else if (message === "invalidBirthday") {
				showError('.regist-has-error', 'invalidBirthday');
			} else if (message === "invalidFullName") {
				showError('.regist-has-error', 'invalidFullName');
			} else if (message === "invalidPassword") {
				showError('.regist-has-error', 'invalidPassword');
			} else {
				showError('.regist-has-error', G_MESSAGE.globalErrorMsg);
			}
		},
		error : function(response) {
			showError('.regist-has-error', G_MESSAGE.globalErrorMsg);
		}
	});
}