package org.polaris.fossology.client.model.job.request;

public class PostJobsRequestBody {

	private Anaylysis analysis = new Anaylysis();
	public Anaylysis getAnalysis() {
		return analysis;
	}
	public void setAnalysis(Anaylysis analysis) {
		this.analysis = analysis;
	}
	public LicenseDecider getDecider() {
		return decider;
	}
	public void setDecider(LicenseDecider decider) {
		this.decider = decider;
	}
	public Reuse getReuse() {
		return reuse;
	}
	public void setReuse(Reuse reuse) {
		this.reuse = reuse;
	}
	private LicenseDecider decider = new LicenseDecider();
	private Reuse reuse = new Reuse();
	
	
}
