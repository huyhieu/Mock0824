package com.viettel.data.model.form;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

	private MultipartFile file;
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
