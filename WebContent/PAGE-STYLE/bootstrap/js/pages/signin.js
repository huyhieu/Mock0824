// Show login dialog using ajax

function showLoginDialog() {
	showProcesingModal(true);
	$.ajax({
		type : 'POST',
		url : "showLoginDialog.do",
		timeout : G_MESSAGE.globalTimeOut,
		dataType : 'html',
		async : true,
		success : function(response) {
			showPageModal(true, response);
			showProcesingModal(false);

			doValidate();
		},
		error : function(response) {
			showAlertMessage(EN_MESSAGE.Key_show_loginmodal,
					VI_MESSAGE.Key_show_loginmodal);
		},
	});
	return false;
};

function doValidate() {
	$('#login_form').formValidation().on('success.form.fv', function(e) {
		doLogin();
		e.preventdefault();
	});
	$('#login_form').on('submit', function(e) {
		//e.preventdefault();
	});
};

// Start login
function doLogin() {
	$.ajax({
		type : 'POST',
		url : 'doLogin.do',
		timeout : G_MESSAGE.globalTimeOut,
		data : JSON.stringify({
			"email" : $("#username").val(),
			"password" : $("#password").val(),
		}),
		dataType : 'json',
		contentType : "application/json",
		async : true,
		success : function(response) {

			var status = response.status;
			if (status === "success") {
				// Close dialog
				showPageModal(false);

				// Refresh login status
				reloadAccountStatus();

				// Refresh header menu
				reloadHeaderMenu();

			} else if (status === "invalid_email") {
				showAlertMessage(EN_MESSAGE.Key_invalid_email,
						VI_MESSAGE.Key_invalid_email);

			} else if (status === "login_fail") {
				showAlertMessage(EN_MESSAGE.Key_invalid_pass_email,
						VI_MESSAGE.Key_invalid_pass_email);

			} else if (status === "invalid_password") {
				showAlertMessage(EN_MESSAGE.Key_invalid_pass,
						VI_MESSAGE.Key_invalid_pass);

			} else if (status === "login_error") {
				showAlertMessage(EN_MESSAGE.Key_login_error,
						VI_MESSAGE.Key_login_error);

			} else if (status === "user_not_ative") {
				showAlertMessage(EN_MESSAGE.Key_account_not_active,
						VI_MESSAGE.Key_account_not_active);

			} else if (status === "user_is_locked") {
				showAlertMessage(EN_MESSAGE.Key_account_is_locked,
						VI_MESSAGE.Key_account_is_locked);
			}
		},
		error : function(response) {
			showAlertMessage(EN_MESSAGE.Key_login_error,
					VI_MESSAGE.Key_login_error);
		}
	});
};

// Start login
function doLogout() {
	$.ajax({
		type : 'POST',
		url : 'doLogout.do',
		timeout : G_MESSAGE.globalTimeOut,
		dataType : 'html',
		async : true,
		success : function(response) {
			var status = response.trim();
			if (status === 'error') {
				showAlertMessage(EN_MESSAGE.Key_logout_error,
						VI_MESSAGE.Key_logout_error);

			} else {
				// Show data on div
				$('#account_status').html(response);
				// reload headermenu
				reloadHeaderMenu();
			}
		},
		error : function(response) {
			showAlertMessage(EN_MESSAGE.Key_logout_error,
					VI_MESSAGE.Key_logout_error);
		}
	});
};
// Start login
function reloadAccountStatus() {
	$.ajax({
		type : 'POST',
		url : 'reloadAccountStatus.do',
		timeout : G_MESSAGE.globalTimeOut,
		dataType : 'html',
		async : true,
		success : function(response) {
			var status = response.trim();
			if (status !== 'error') {
				// Show data on div
				$('#account_status').html(response);
			}
		},
		error : function(response) {
			showAlertMessage(EN_MESSAGE.Key_error_reload_account,
					VI_MESSAGE.Key_error_reload_account);
		}
	});
}
// reload headermenu
function reloadHeaderMenu() {
	$.ajax({
		type : 'POST',
		url : 'Home!reloadHeaderMenu.do',
		timeout : G_MESSAGE.globalTimeOut,
		dataType : 'html',
		async : true,
		success : function(response) {
			var status = response.trim();
			if (status !== 'error') {
				// Show data on div
				$('#MenuHeader').html(response);
			}
		},
		error : function(response) {
		}
	});
}
