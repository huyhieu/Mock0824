package com.viettel.util;

public class FileFilter {
	public static String file_extensions[] = new String[] { ".json", ".xml", ".wsdl" };

	/**
	 * Check whether input file name is accepted or not
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean accept(String fileName) {
		boolean accepted = false;
		int length = file_extensions.length;
		for (int i = 0; i < length; i++)
			if (fileName.toLowerCase().endsWith(file_extensions[i])) {
				accepted = true;
				break;
			}
		return accepted;
	}

}
