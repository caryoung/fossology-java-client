package org.polaris.fossology.client.model.job;

import org.polaris.fossology.client.util.Consts;
import org.polaris.fossology.client.util.Utils;

public class Job {

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

	public String getQueueDate() {
		return queueDate;
	}

	public void setQueueDate(String queueDate) {
		this.queueDate = queueDate;
	}

	public int getUploadId() {
		return uploadId;
	}

	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		if (!Utils.isEmpty(status)) {
			JobStatusEnum jobStatusEnum = JobStatusEnum.byOrdinal(status);
			setJobStatusEnum(jobStatusEnum);
		}

	}

	public JobStatusEnum getJobStatusEnum() {
		return jobStatusEnum;
	}

	public void setJobStatusEnum(JobStatusEnum jobStatusEnum) {
		this.jobStatusEnum = jobStatusEnum;
	}

	private int id;
	private String name;
	/**
	 * When the job was queued
	 */
	private String queueDate;
	/**
	 * Upload for which the job was scheduled
	 */
	private int uploadId;
	private int userId;
	private int groupId;
	/**
	 * ETA of job to finish in seconds
	 */
	private int eta;
	private String status;
	private JobStatusEnum jobStatusEnum;

	public String toString() {
		String result = "id:" + id + Consts.SPLIT_SIGN + "name:" + name + Consts.SPLIT_SIGN + "queueDate:" + queueDate
				+ Consts.SPLIT_SIGN + "uploadId:" + uploadId + Consts.SPLIT_SIGN + "userId:" + userId
				+ Consts.SPLIT_SIGN + "groupId:" + groupId + Consts.SPLIT_SIGN + "eta:" + eta + Consts.SPLIT_SIGN
				+ "status:" + status;
		return result;
	}

}
