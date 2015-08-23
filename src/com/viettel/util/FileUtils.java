package com.viettel.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * @author hieunq5
 * 
 */
public class FileUtils {
	private static final String TAG = FileUtils.class.getSimpleName();

	/**
	 * @param file
	 * @param fileName
	 * @param filesDirectory
	 * @throws IOException
	 */
	/**
	 * @param bytes
	 * @param os
	 * @return
	 */
	public static boolean write(int bytes, FileOutputStream out) {
		try {
			// byte[] bytes_ = longToBytes(bytes);
			out.write(bytes);
		} catch (IOException e) {
		}
		return true;
	}

	/**
	 * @param x
	 * @return
	 */
	public static byte[] longToBytes(long x) {
		ByteBuffer buffer = ByteBuffer.allocate(Long.SIZE);
		buffer.putLong(x);
		return buffer.array();
	}

	public static boolean copyWithStreams(File aSourceFile, File aTargetFile, boolean aAppend) {
		ensureTargetDirectoryExists(aTargetFile.getParentFile());
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			try {
				byte[] bucket = new byte[32 * 1024];
				inStream = new BufferedInputStream(new FileInputStream(aSourceFile));
				outStream = new BufferedOutputStream(new FileOutputStream(aTargetFile, aAppend));
				int bytesRead = 0;
				while (bytesRead != -1) {
					bytesRead = inStream.read(bucket); // -1, 0, or more
					if (bytesRead > 0) {
						outStream.write(bucket, 0, bytesRead);
					}
				}
			} finally {
				if (inStream != null)
					inStream.close();
				if (outStream != null)
					outStream.close();
			}
		} catch (FileNotFoundException ex) {
			return false;

		} catch (IOException ex) {
			return false;

		}

		return true;
	}

	private static void ensureTargetDirectoryExists(File aTargetDir) {
		if (!aTargetDir.exists()) {
			aTargetDir.mkdirs();
		}
	}

	public static boolean saveFile(File file, String fileName, String filesDirectory) throws IOException {

		boolean isSaved = true;
		FileInputStream in = null;
		FileOutputStream out = null;

		File dir = new File(filesDirectory);
		if (!dir.exists())
			dir.mkdirs();

		String targetPath = dir.getPath() + File.separator + fileName;
		File destinationFile = new File(targetPath);
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(destinationFile);
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (Exception e) {
			isSaved = false;
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		return isSaved;
	}

	/**
	 * @param file
	 * @return
	 */
	public static boolean removeFile(File file) {

		boolean deleted = false;
		try {
			if (file != null) {
				if (file.exists()) {
					deleted = file.delete();
				}
			}
		} catch (Exception e) {
			deleted = false;
		}
		return deleted;
	}

	/**
	 * @param filePath
	 * @return
	 */
	public static boolean removeFile(String filePath) {
		if (filePath == null || filePath.equals("")) {
			return true;
		}
		File file = new File(filePath);
		return removeFile(file);
	}

	/**
	 * @param fileName
	 * @param buff
	 */
	public static void writeFile(String fileName, byte[] buff) {

		OutputStream out;
		try {
			out = new FileOutputStream(new File(fileName));
			out.write(buff, 0, buff.length);
			out.close();
		} catch (Exception ex) {
		}
	}

	public static boolean write(String content, String fileName) {
		FileWriter fileWriter = null;
		File file = new File(fileName);
		if (!file.exists()) {
			return false;
		}
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(content);
		} catch (Exception e) {
			return false;
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e2) {
			}
		}
		return true;
	}

	public static String read(String fileName) {
		String result = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
		} finally {
			try {
				br.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static byte[] readFile(String fileName) {
		File file = new File(fileName);
		int fileLength = (int) file.length();
		byte[] buff = new byte[fileLength];
		InputStream in;

		try {
			in = new FileInputStream(new File(fileName));
			in.read(buff, 0, buff.length);
			in.close();
		} catch (Exception ex) {

		}
		return buff;
	}

	/**
	 * @param oldFile
	 * @param newFile
	 * @return
	 */
	public static boolean renameFile(File oldFile, File newFile) {

		if (oldFile.renameTo(newFile)) {
			return true;
		}
		return false;

	}

	/**
	 * @param src
	 * @return
	 */
	public static void deleteFolder(File src) {
		if (src.isDirectory()) {
			File[] childFiles = src.listFiles();
			for (File child : childFiles) {
				deleteFolder(child);
			}
		}
		src.delete();
	}

	public static void deleteFolder(String path) {
		if (path == null) {
			return;
		}
		if (path.equals("")) {
			return;
		}
		File src = new File(path);
		if (!src.exists()) {
			return;
		}
		deleteFolder(src);
	}

	/**
	 * @param sourceLocation
	 * @param targetLocation
	 */
	public static boolean move(File sourceLocation, File targetLocation) {
		targetLocation = new File(targetLocation, sourceLocation.getName().toString());
		try {
			targetLocation.createNewFile();
			sourceLocation.renameTo(targetLocation);
			LogUtils.d(TAG, "File " + sourceLocation.getName() + "has been moved to " + targetLocation.getName() + ".");
		} catch (Exception ex) {
			LogUtils.d(TAG, "Cannot moved file.");
			return false;
		}
		deleteFolder(sourceLocation);
		return true;
	}

	/**
	 * @param path
	 * @return
	 */
	public static boolean isFileExsited(String path) {
		if (path == null) {
			return false;
		}
		if (path.equals("")) {
			return false;
		}
		File file = new File(path);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

}
