package com.viettel.data.model.form;

public class ExportForm {

	private String fileName;
	private String selectedIds;

	public String getFileName() {
		return fileName == null ? "" : fileName.trim();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSelectedIds() {
		return selectedIds == null ? "" : selectedIds.trim();
	}

	public void setSelectedIds(String selectedIds) {
		this.selectedIds = selectedIds;
	}

}
