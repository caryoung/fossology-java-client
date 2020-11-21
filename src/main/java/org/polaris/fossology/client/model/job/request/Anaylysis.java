package org.polaris.fossology.client.model.job.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Anaylysis {

	public boolean isBucket() {
		return bucket;
	}

	public void setBucket(boolean bucket) {
		this.bucket = bucket;
	}

	@JsonProperty("copyright_email_author")
	public boolean isCopyrightEmailAuthor() {
		return copyrightEmailAuthor;
	}

	@JsonProperty("copyright_email_author")
	public void setCopyrightEmailAuthor(boolean copyrightEmailAuthor) {
		this.copyrightEmailAuthor = copyrightEmailAuthor;
	}

	public boolean isEcc() {
		return ecc;
	}

	public void setEcc(boolean ecc) {
		this.ecc = ecc;
	}

	public boolean isKeyword() {
		return keyword;
	}

	public void setKeyword(boolean keyword) {
		this.keyword = keyword;
	}

	public boolean isMime() {
		return mime;
	}

	public void setMime(boolean mime) {
		this.mime = mime;
	}

	public boolean isMonk() {
		return monk;
	}

	public void setMonk(boolean monk) {
		this.monk = monk;
	}

	public boolean isNomos() {
		return nomos;
	}

	public void setNomos(boolean nomos) {
		this.nomos = nomos;
	}

	public boolean isOjo() {
		return ojo;
	}

	public void setOjo(boolean ojo) {
		this.ojo = ojo;
	}

	@JsonProperty("package")
	public boolean isPackageAnaylysis() {
		return packageAnaylysis;
	}

	@JsonProperty("package")
	public void setPackageAnaylysis(boolean packageAnaylysis) {
		this.packageAnaylysis = packageAnaylysis;
	}

	/**
	 * Should bucket analysis be run on this upload
	 */
	private boolean bucket = true;
	/**
	 * Should Copyright/Email/URL/Author Analysis be run on this upload.
	 * 
	 * orignal : copyright_email_author
	 * 
	 */
	private boolean copyrightEmailAuthor = true;

	/**
	 * Should ECC Analysis be run on this upload.
	 */
	private boolean ecc = true;

	/**
	 * Should keyword Analysis be run on this upload.
	 */
	private boolean keyword = true;

	/**
	 * Should MIME Analysis be run on this upload.
	 **/
	private boolean mime = true;

	/**
	 * Should Monk Analysis be run on this upload.
	 */
	private boolean monk = true;

	/**
	 * Should nomos Analysis be run on this upload.
	 */
	private boolean nomos = true;

	/**
	 * Should ojo Analysis be run on this upload.
	 */
	private boolean ojo = true;

	/**
	 * Should package Analysis be run on this upload.<br>
	 * orignal : package
	 */
	
	private boolean packageAnaylysis = true;
}
