package org.polaris.fossology.client.model.job.request;

public class GetJobsRequest {
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Integer getUpload() {
		return upload;
	}
	public void setUpload(Integer upload) {
		this.upload = upload;
	}
	private int limit;
	private int page;
	private Integer upload;
	
}
