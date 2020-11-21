package org.polaris.fossology.client.request.upload.handler;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpResponseHandler;
import org.polaris.fossology.client.model.upload.UploadResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetUploadHandler extends HttpResponseHandler<UploadResponse>{

	private static Logger logger = LogManager.getLogger(GetUploadHandler.class);

	@Override
	public UploadResponse transform(HttpResponse response, StringBuilder stringBuilder) {
		ObjectMapper mapper = new ObjectMapper();
		UploadResponse job = null;
		
		try {
			job = mapper.readValue(stringBuilder.toString(), UploadResponse.class);
		    return job;
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		}
		
		return job;
	}
	
	
	
}
