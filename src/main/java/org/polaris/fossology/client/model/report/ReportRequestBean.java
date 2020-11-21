package org.polaris.fossology.client.model.report;

import org.polaris.fossology.client.util.Consts;
import org.polaris.fossology.client.util.Utils;

public class ReportRequestBean {

	public int getUploadId() {
		return uploadId;
	}

	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}

	public String getReportFormat() {
		return reportFormat;
	}

	public void setReportFormat(String reportFormat) {
		this.reportFormat = reportFormat;
		if (!Utils.isEmpty(reportFormat)) {
			ReportEnum reportEnum = ReportEnum.byOrdinal(reportFormat);
			this.reportFormatEnum = reportEnum;
		}
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupnName) {
		this.groupName = groupnName;
	}

	public ReportEnum getReportFormatEnum() {
		return reportFormatEnum;
	}

	public void setReportFormatEnum(ReportEnum reportFormatEnum) {
		this.reportFormatEnum = reportFormatEnum;
	}

	private int uploadId;
	private String reportFormat;
	private String groupName;
	private ReportEnum reportFormatEnum;

	public String toString() {
		String result = "";
		result = result + "uploadId:" + uploadId + Consts.SPLIT_SIGN + "reportFormat:" + Consts.SPLIT_SIGN
				+ "groupName:" + groupName + Consts.SPLIT_SIGN;
		return result;
	}
}
