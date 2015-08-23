/* Define global message */
var G_MESSAGE = {
	globalErrorMsg : "An unexpected error occurred. Please try again later.",
	globalInvalidMsg : "Invalid data. Please try again.",
	globalFunctionNotImplementMsg : "This function has not implemented yet.",
	globalSaved : "Your information has been changed.",
	globalDelete : "Are you sure that you want to delete this appication?",
	globalDeleteUser : "Are you sure that you want to delete this User?",
	globalUserHasBeenDeleted : "User has been deleted.",
	globalPublish : "<a>Are you agree to ViettelAppsStore</a> <a style='  color: #1bb3ca; margin-top: 10px; margin-left: 4px; font-size: 14px; font-weight: normal;margin: 0;' "
			+ "onclick='showTermPublish();'>Terms publish</a> <a>and sure that you want to publish this application?</a>",
	globalPublishApk : "Are you sure that you want to publish this version?",
	globalNetworkFail : "Network not available, please check you connection and try again.",
	globalTimeOut : 60000,

	// APK Production
	movedToTesting : "Apk has been moved to testing list.",
	ApkTestingVersionExists : "Apk has been existed in testing mode.",
	ApkTestingDeleted : "Apk has been deleted.",

	// APK Testing
	movedToProduction : "Apk has been moved to production list.",
	ApkProductionVersionExists : "Apk has been existed in production list.",
	ApkProductionExists : "An apk production was existed, please check it again.",
	ApkProductionDeleted : "APK has been deleted.",

	// Revert apk
	Apk_RevertToPreviousVersion : "Cannot revert to previous version.",
	// Update APK Info
	ApkUpdateSuccess : "APK has been updated successfully.",
	ApkUpdateFail : "Updated APK failure.",

	// Upload
	APKInvalid : "You need to check that your file is a valid extention.",
	APKExistsInProduction : "An apk production was existed, please check it again.",
	APKInvalidFormat : "You need to check that your file is invalid format.",
	APKMissingInfor : "You need to check your file(version code, version name, ...).",
	BundleExists : "The bundle was existed. Please try another.",
	BundleDifferent : "The bundle is not matched.",
	VesionCode_invalid : "You need to check that apk version code is invalid(must contain letters or numbers, seperated by one dot(.)).",
	VesionCode_higher : "You need to check that apk version code is not higher than previous version.",

	// Invite tester
	InviteSuccess : "Your invitation has been sent.",

	PLish_emptydata : "Data from session is invalid.",
	PLish_noProduct : "No product apk to publish.",
	PLish_OnlyPublished : "This app have a published version.",
	PLish_missingApk : "Missing apk.",
	PLish_missingStoreListing : "App information is missing.",
	PLish_missingPricingDistribution : "App price & distribution is missing.",
	PLish_success : "Your updates are pending  publication. It can take  several hours until they are available throughout VTStore.",
	PLish_removeIcon : "Your app has been published, cannot remove all icon.",
	PLish_removePicture : "Your app has been published, cannot remove all picture.",

	Platform_showmenu : "Error occured during showing platform menu.",
	Platform_showApps : "Error occured when trying to show apps with platform.",

	InviteRemove : "Your invite has been removed from list.",
	InviteSendInvitation : "Exsting email that you cannot send.",

	Parent_error : "Couldn't show parent information, please try again.",

	Setting_empty : "Couldn't show parent information, please try again.",
	Setting_error : "Couldn't save setting information.",
	Setting_wrongFullname : "Fullname is wrong format(length must be in range[5 - 200]).",
	Setting_wrongBirthday : "Invalid birthday.",
	Setting_wrongEmail : "Invalid email.",
	// PRICE
	Price_error : "Error occured during save Price & Distribution.",
	Price_cannot_insert : "Cannot insert Price & Distribution.",
	Price_cannot_update : "Cannot update Price & Distribution.",

	// REVIEWS
	Review_reject : "Do you want to reject this version?",
	Review_publish : "Do you want to publish this version?",
	Review_review : "Do you want to review this version?",
	Review_reviewing : "This app is being reviewed, any actions will be limited.",

	// Change role user
	Change_rights_success : "Rights successfully changed.",
	Confirm_change_rights : "Do you want change rights this User?",

	// Change zone user
	Change_zone_success : "Zone successfully changed.",
	Confirm_change_zone : "Do you want change zone this User?",

	App_is_locked : "Applications are locked, unable to execute this action.",
	ACCOUNT_IS_LOCK : "Your account is locked. Try again later.",
	ACCOUNT_IS_NOT_ACTIVED : "Your account has not been actived yet. Try again later.",
	Email_cannot_send : "Cannot send email at this moment. Try again later.",
	// Send Request Email
	SendRequestSuccess : "success",
	SendRequestFail : "fail",
	SendRequestError : "error",
	SendRequestReady : "ready",
	SendRequestNotExisted : "notexisted",

	EmailNotExisted : "Email not Exist",

	// Validation for testbox
	Error_general_required : "This field is required.",

	// REGISTER
	PasswordNotSameCFPass : "The password are not the same the confirm password.",

};