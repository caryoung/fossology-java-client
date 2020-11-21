package org.polaris.fossology.client.model.job.request;

public class PostJobsRequestHead {

	public int getFolderId() {
		return folderId;
	}
	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}
	public int getUploaderId() {
		return uploaderId;
	}
	public void setUploaderId(int uploaderId) {
		this.uploaderId = uploaderId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	private int folderId;
	private int uploaderId;
	private String groupName;
	
	
}
