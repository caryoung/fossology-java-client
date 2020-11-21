package org.polaris.fossology.client.util;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.model.ConfigBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Consts {

	private static Logger logger = LogManager.getLogger(Consts.class);

	public static String FOSSOLOGY_URI = null;
	public static int FOSSOLOGY_PORT = 8085;
	public static String TOKEN = null;
	public static String FOSSOLOGY_PATH = "/repo/api/v1";

	public static final String SPLIT_SIGN = ",";
	public static String FILE_BASE = "files";
	public static final String PUBLIC_STRING = "public";
	public static final String CONTENT_TYPE_MULTIPART = "multipart/form-data";
	public static final String BOUNDARY = "----------------------b7c57e70ede726d5";
	public static final String AUTHORIZATION = "Authorization";
	public static final String FOLDER_NAME = "folderName";
	public static final String FOLDER_ID = "folderId";
	public static final String UPLOAD_ID = "uploadId";

	static {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			ConfigBean bean = mapper.readValue(new File("src/main/resources/config.yaml"), ConfigBean.class);
			FOSSOLOGY_URI = "https://" + bean.getFosslogyURL();
			FOSSOLOGY_PORT = bean.getFosslogyPort();
			TOKEN = bean.getAuth();
			FILE_BASE = bean.getFileBase();
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}
