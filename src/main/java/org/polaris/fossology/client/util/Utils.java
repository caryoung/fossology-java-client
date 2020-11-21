package org.polaris.fossology.client.util;

public class Utils {

	public static boolean isEmpty(String str) {
		if(str == null) {
			return true;
		}
		
		if(str.trim().equals("")) {
			return true;
		}
		
		return false;
	}
	
}
