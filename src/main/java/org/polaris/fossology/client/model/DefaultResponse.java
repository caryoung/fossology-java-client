package org.polaris.fossology.client.model;

import org.polaris.fossology.client.util.Consts;

public class DefaultResponse {

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		if (type != null) {
			setTypeEnum(DefaultTypeEnum.byOrdinal(type));
		}
	}

	public DefaultTypeEnum getTypeEnum() {
		return typeEnum;
	}

	public void setTypeEnum(DefaultTypeEnum typeEnum) {
		this.typeEnum = typeEnum;
	}

	private int code;
	private String message;
	private String type;
	private DefaultTypeEnum typeEnum;

	public String toString() {
		String result = "";
		result = result + "code:" + code + Consts.SPLIT_SIGN + "message:" + Consts.SPLIT_SIGN + "type:" + type
				+ Consts.SPLIT_SIGN;
		return result;
	}

}
