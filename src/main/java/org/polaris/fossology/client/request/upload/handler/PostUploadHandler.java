package org.polaris.fossology.client.request.upload.handler;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpResponseHandler;
import org.polaris.fossology.client.model.DefaultResponse;
import org.polaris.fossology.client.model.upload.UploadResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostUploadHandler extends HttpResponseHandler<DefaultResponse>{

	private static Logger logger = LogManager.getLogger(PostUploadHandler.class);

	@Override
	public DefaultResponse transform(HttpResponse response, StringBuilder stringBuilder) {
		ObjectMapper mapper = new ObjectMapper();
		DefaultResponse responseBean = null;
		
		try {
			responseBean = mapper.readValue(stringBuilder.toString(), DefaultResponse.class);
		    return responseBean;
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		}
		
		return responseBean;
	}
	
	
	
}
