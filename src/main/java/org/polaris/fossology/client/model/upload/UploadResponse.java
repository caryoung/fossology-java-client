package org.polaris.fossology.client.model.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadResponse {

	@JsonProperty("folderid")
	public int getFolderId() {
		return folderId;
	}
	@JsonProperty("folderid")
	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonProperty("uploadname")
	public String getUploadName() {
		return uploadName;
	}
	@JsonProperty("uploadname")
	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	@JsonProperty("uploaddate")
	public String getUploadDate() {
		return uploadDate;
	}
	@JsonProperty("uploaddate")
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	@JsonProperty("filesize")
	public int getFileSize() {
		return fileSize;
	}
	@JsonProperty("filesize")
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	@JsonProperty("filessha1")
	public String getFileSha1() {
		return fileSha1;
	}
	@JsonProperty("filessha1")
	public void setFileSha1(String fileSha1) {
		this.fileSha1 = fileSha1;
	}
	private int folderId;
	private String folderName;
	private int id;
	private String description;
	private String uploadName;
	private String uploadDate;
	private int fileSize;
	private String fileSha1;
	
}
