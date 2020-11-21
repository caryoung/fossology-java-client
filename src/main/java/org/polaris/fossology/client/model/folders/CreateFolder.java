package org.polaris.fossology.client.model.folders;

public class CreateFolder {

	public int getParentFolder() {
		return parentFolder;
	}
	public void setParentFolder(int parentFolder) {
		this.parentFolder = parentFolder;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolderDescription() {
		return folderDescription;
	}
	public void setFolderDescription(String folderDescription) {
		this.folderDescription = folderDescription;
	}
	
	private int parentFolder;
	private String folderName;
	private String folderDescription;
	
}
