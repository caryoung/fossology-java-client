package org.polaris.fossology.client.model.upload;

public class UploadRequestBody {

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileInput() {
		return fileInput;
	}
	public void setFileInput(String fileInput) {
		this.fileInput = fileInput;
	}
	private String type = "multipart/form-data";
	private String fileInput;
	
}
