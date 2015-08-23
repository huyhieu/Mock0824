package globaldefine;

/**
 * 
 * @author hieuph
 *
 */
public class EmailConfig {

	public static final String host = "203.113.131.19";
	public static final String port = "465";
	public static final String auth = "false";

	public static final String from = "hieuph@viettel.com.vn";
	public static final String password = "JnVfuoRi5X4byplitATKwyjFbAjSGoOi";

	public static final String HEADER_SUBJECT = "[Vmock] ";

	// Email lien he trong moi email gui toi nguoi dung
	public static final String ip_contact = "http://localhost:9552/MockServiveV2/";
	
	public static final String email_contact = "hotro@vmock.vn";
	
	// Email Created Account Successfully.
	public static final String SUBJECT_CREATED_ACCOUNT_SUCCESSFULLY = HEADER_SUBJECT + "Tạo tài khoản thành công.";
	public static final String CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_1 = "Tài khoản của bạn đã được tạo thành công. <br><a style='cursor: pointer;' ";
	public static final String CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_2 = "href='";
	public static final String CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_3 = "verifyEmail.html?email=";
	public static final String CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_4 = "&activeCode="; 
	public static final String CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_5 = "'><b>Xác nhận Email</b></a>";
	
	//Confirm password changes
	public static final String SUBJECT_CONFIRM_PASSWORD_CHANGES = HEADER_SUBJECT + "Xác nhận thay đổi mật khẩu.";
	public static final String CONTENT_CONFIRM_PASSWORD_CHANGES_1 = "Mật khẩu được cấp ngày ";	
	public static final String CONTENT_CONFIRM_PASSWORD_CHANGES_2 = " đã được kích hoạt thành công.";
	public static final String CONTENT_CONFIRM_PASSWORD_CHANGES_3 = " đã bị hủy.";
	
	//Reset password
	public static final String SUBJECT_RESETPASSWORD = HEADER_SUBJECT + "Vmock cấp lại mật khẩu";
	public static final String CONTENT_RESETPASSWORD = "Mật khẩu mới là: ";
}
