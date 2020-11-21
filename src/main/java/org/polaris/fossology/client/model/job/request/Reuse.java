package org.polaris.fossology.client.model.job.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reuse {

	@JsonProperty("reuse_upload")
	public int getReuseUpload() {
		return reuseUpload;
	}

	@JsonProperty("reuse_upload")
	public void setReuseUpload(int reuseUpload) {
		this.reuseUpload = reuseUpload;
	}

	@JsonProperty("reuse_group")
	public int getReuseGroup() {
		return reuseGroup;
	}
	
	@JsonProperty("reuse_group")
	public void setReuseGroup(int reuseGroup) {
		this.reuseGroup = reuseGroup;
	}

	@JsonProperty("reuse_main")
	public boolean isReuseMain() {
		return reuseMain;
	}

	@JsonProperty("reuse_main")
	public void setReuseMain(boolean reuseMain) {
		this.reuseMain = reuseMain;
	}

	@JsonProperty("reuse_enhanced")
	public boolean isReuseEnhanced() {
		return reuseEnhanced;
	}

	@JsonProperty("reuse_enhanced")
	public void setReuseEnhanced(boolean reuseEnhanced) {
		this.reuseEnhanced = reuseEnhanced;
	}

	/**
	 * The UploadID to reuse. orginal : reuse_upload
	 */
	private int reuseUpload;

	/**
	 * The group of the reused upload orginal : reuse_group
	 */
	private int reuseGroup;

	/**
	 * Scanners matches if all Nomos findings are within the Monk findings. orginal
	 * : reuse_main
	 */
	private boolean reuseMain = true;

	/**
	 * Bulk phrases from reused packages. orginal : reuse_enhanced
	 */
	private boolean reuseEnhanced = true;

}
