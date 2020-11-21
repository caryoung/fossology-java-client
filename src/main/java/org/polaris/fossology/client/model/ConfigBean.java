package org.polaris.fossology.client.model;

public class ConfigBean {

	public String getFosslogyURL() {
		return fosslogyURL;
	}
	public void setFosslogyURL(String fosslogyURL) {
		this.fosslogyURL = fosslogyURL;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getFileBase() {
		return fileBase;
	}
	public void setFileBase(String fileBase) {
		this.fileBase = fileBase;
	}
	private int fosslogyPort;
	public int getFosslogyPort() {
		return fosslogyPort;
	}
	public void setFosslogyPort(int fosslogyPort) {
		this.fosslogyPort = fosslogyPort;
	}
	
	private String fosslogyURL;
	private String auth;
	private String fileBase;
}
