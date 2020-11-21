package org.polaris.fossology.client.request.report.handler;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpResponseHandler;
import org.polaris.fossology.client.model.DefaultResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetReportHandler extends HttpResponseHandler<DefaultResponse>{

	private static Logger logger = LogManager.getLogger(GetReportHandler.class);

	@Override
	public DefaultResponse transform(HttpResponse response, StringBuilder stringBuilder) {
		ObjectMapper mapper = new ObjectMapper();
		DefaultResponse responseResult = null;
		
		try {
			responseResult = mapper.readValue(stringBuilder.toString(), DefaultResponse.class);
		    return responseResult;
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		}
		
		return responseResult;
	}
	
	
	
}
