package org.polaris.fossology.client.model;

import org.polaris.fossology.client.util.Utils;

public enum DefaultTypeEnum {

	info("info"),error("error");
	
	private String type = null;
	DefaultTypeEnum(String type){
		this.type = type;
	}
	
	public static DefaultTypeEnum byOrdinal(String s) {
		if(Utils.isEmpty(s)) {
			return null;
		}
		
		for(DefaultTypeEnum typeEnum : DefaultTypeEnum.values()) {
			if(typeEnum.type.equals(s)) {
				return typeEnum;
			}
		}
		return null;
	}
}
