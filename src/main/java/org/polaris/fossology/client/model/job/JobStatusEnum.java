package org.polaris.fossology.client.model.job;

import org.polaris.fossology.client.util.Utils;

/**
 * Denotes the current status of the job in the queue <br>
 * Enum: [ Completed, Failed, Queued, Processing ]
 * 
 */
public enum JobStatusEnum {

	Completed("info"), Failed("error"), Queued("Queued"), Processing("Processing");

	private String type = null;

	JobStatusEnum(String type) {
		this.type = type;
	}

	public static JobStatusEnum byOrdinal(String s) {
		if (Utils.isEmpty(s)) {
			return null;
		}

		for (JobStatusEnum typeEnum : JobStatusEnum.values()) {
			if (typeEnum.type.equals(s)) {
				return typeEnum;
			}
		}
		return null;
	}
}
