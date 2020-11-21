package org.polaris.fossology.client.model.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @param folderid    integer<br>
 *                    The folder id, where the upload is located
 * 
 * @param foldername  string<br>
 *                    The name of the folder where the upload is located
 * 
 * @param id          integer<br>
 *                    Upload id of the upload.
 * 
 * @param description string<br>
 *                    Description of the upload.
 * 
 * @param uploadname  string<br>
 *                    Display name of the upload.
 * 
 * @param uploaddate  string<br>
 *                    Date, when the file was uploaded.
 * 
 * @param filesize    integer<br>
 *                    Filesize in Bytes.
 * 
 * @param filesha1    string<br>
 *                    SHA1 digest of the file
 * 
 */																																																		

public class UploadRequestHead {

	private int folderId;
	private String uploadDescription;
	private String publicAccess;
	private String groupName;
	private String uploadType;

	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public String getUploadDescription() {
		return uploadDescription;
	}

	public void setUploadDescription(String uploadDescription) {
		this.uploadDescription = uploadDescription;
	}

	@JsonProperty("public")
	public String getPublicAccess() {
		return publicAccess;
	}

	@JsonProperty("public")
	public void setPublicAccess(String publicAccess) {
		this.publicAccess = publicAccess;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

}