package org.polaris.fossology.client.model.folders;

public class Folder {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	private int id;
	private String name;
	private String description;
	private Integer parent;
	
	public String toString() {
		String result = "";
		result = "id: "+id+" name: "+name+" description: "+description+" parent: "+parent;
		return result;
	}
	
}
