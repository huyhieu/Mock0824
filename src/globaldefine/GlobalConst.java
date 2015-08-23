package globaldefine;

/**
 * 
 * @author hieunq5
 * 
 */
public class GlobalConst {
	public static final Long ROLE_ADMIN = 1L;
	public static final Long ROLE_USER = 0L;
	public static final Long ROLE_SUPER_ADMIN = 2L;

	public static final long UPDATE = 1;
	public static final long OVERRIDE = 2;

	public static final String TREE_NODE_PROJECT = "data-jstree='{\"icon\":\"./PAGE-STYLE/images/project/ic_project.png\"}\'";
	public static final String TREE_NODE_SERVICE = "data-jstree='{\"icon\":\"./PAGE-STYLE/images/project/ic_service.png\"}\'";
	public static final String TREE_NODE_REQUEST = "data-jstree='{\"icon\":\"./PAGE-STYLE/images/project/ic_request.png\"}\'";

	public static final String JSON_PATH = "C:\\Users\\VPMT\\Desktop\\";

	// EXPORTS
	public static final int EXPORT_TYPE_ALL = 1;
	public static final int EXPORT_TYPE_JSON = 2;
	public static final int EXPORT_TYPE_JAVA = 3;
	public static final int EXPORT_TYPE_JAVA_C_SHARP = 4;
	public static final int EXPORT_TYPE_OBJECTIVE_C = 5;
}