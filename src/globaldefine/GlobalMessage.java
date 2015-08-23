package globaldefine;

/**
 * 
 * @author hieuph
 *
 */
public class GlobalMessage {
	
	// ACCOUNT
	public static final String MSG_EMAIL_IS_EXIST = "Email đã tồn tại, vui lòng thử lại Email khác.";
	public static final String MSG_RESET_PASSWORD_FAIL =  "Reset mật khẩu thất bại, vui lòng thử lại sau.";
	public static final String MSG_FIELD_REQUIRED =  "Trường này bắt buộc nhập.";
	public static final String MSG_EMAIL_REQUIRED =  "Email người dùng bắt buộc nhập.";
	public static final String MSG_PASSWORD_REQUIRED =  "Mật khẩu người dùng bắt buộc nhập.";
	public static final String MSG_EMAIL_PASSWORD_INCORRECT =  "Email hoặc mật khẩu không chính xác.";
	public static final String MSG_EMAIL_UNCONFIRMED  = "Email chưa được xác nhận!";
	public static final String MSG_UNKNOWN_ERROR_OCCURRED  = "Xảy ra lỗi ngoại lệ, vui lòng thử lại sau.";
	public static final String MSG_ACCOUNT_ACTIVATION_SUCCESSFUL = "<b>Kích hoạt tài khoản thành công.</b>";
	public static final String MSG_ACCOUNT_ACTIVATION_FAIL = "<b>Kích hoạt tài khoản thất bại vui lòng kiểm tra lại.</b>";
	public static final String MSG_SUCCESSFUL_PASSWORD_CHANGE = "<b>Thay đổi mật khẩu thành công.</b><br><br> " +
			"Một mật khẩu mới đã được gửi đến email của bạn<br><br>" +
			"Nếu bạn không sử dụng mật khẩu mới này ở ngay lần đăng nhập tiếp theo thì mật khẩu này sẽ bị hủy";
	
	public static final String MSG_CREATE_ACCOUNT_SUCCESSFUL = "<b>Tài khoản của bạn đã được tạo thành công.</b><br><br>Tuy nhiên, " +
			"trước khi tài khoản có thể được sử dụng nó phải được kích hoạt.<br><br>" +
			"Một email đã được gửi đến địa chỉ mà bạn cung cấp. Thực hiện theo các " +
			"hướng dẫn trong email để kích hoạt tài khoản của bạn.";
}
