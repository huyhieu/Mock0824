package com.viettel.util;

/**
 * @author hieunq5
 * 
 */
public class LogUtils {
	private static final boolean isDebug = true;

	public LogUtils(String MsgLog) {
		System.out.println(MsgLog);
	}

	public static void i(String TAG, String message) {
		if (isDebug) {
			System.out.println(TAG + ": " + message);
		}
	}

	public static void d(String TAG, String message) {
		if (isDebug) {
			System.out.println(TAG + ": " + message);
		}
	}
}
