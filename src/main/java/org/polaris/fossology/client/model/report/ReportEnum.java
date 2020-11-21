package org.polaris.fossology.client.model.report;

import org.polaris.fossology.client.util.Utils;

public enum ReportEnum {

	Dep5("dep5"),Spdx2("spdx2"),Spdx2tv("spdx2tv"),Readmeoss("readmeoss"),Unifiedreport("unifiedreport");
	
	private String content = null;
	
	ReportEnum(String c){
		this.content = c;
	}

	public static ReportEnum byOrdinal(String c) {
		if(Utils.isEmpty(c)) {
			return null;
		}
		
		for(ReportEnum m : ReportEnum.values()) {
			if(m.content.equals(c)) {
				return m;
			}
		}
		
		return null;
	}
	
	public String toString() {
		return this.content;
	}
}