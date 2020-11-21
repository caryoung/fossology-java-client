package org.polaris.fossology.client.model.job.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LicenseDecider {

	@JsonProperty("nomos_monk")
	public boolean isNomosMonk() {
		return nomosMonk;
	}

	@JsonProperty("nomos_monk")
	public void setNomosMonk(boolean nomosMonk) {
		this.nomosMonk = nomosMonk;
	}

	@JsonProperty("bulk_reused")
	public boolean isBulkReused() {
		return bulkReused;
	}

	@JsonProperty("bulk_reused")
	public void setBulkReused(boolean bulkReused) {
		this.bulkReused = bulkReused;
	}

	@JsonProperty("new_scanner")
	public boolean isNewScanner() {
		return newScanner;
	}

	@JsonProperty("new_scanner")
	public void setNewScanner(boolean newScanner) {
		this.newScanner = newScanner;
	}

	@JsonProperty("ojo_decider")
	public boolean isOjoDecider() {
		return ojoDecider;
	}

	@JsonProperty("ojo_decider")
	public void setOjoDecider(boolean ojoDecider) {
		this.ojoDecider = ojoDecider;
	}

	/**
	 * Scanners matches if all Nomos findings are within the Monk findings.
	 * orginal : nomos_monk
	 */
	private boolean nomosMonk = true;

	/**
	 * Bulk phrases from reused packages.
	 * orginal : bulk_reused
	 */
	private boolean bulkReused = true;

	/**
	 * New scanner results, i.e., decisions were marked as work in progress if new
	 * scanner finds additional licenses.
	 * 
	 * orginal : new_scanner
	 */
	private boolean newScanner = true;

	/**
	 * Scanners matches if Ojo findings are no contradiction with other findings.
	 * orginal : ojo_decider
	 */
	private boolean ojoDecider = true;

}
