package org.polaris.fossology.client.request.job.handler;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpResponseHandler;
import org.polaris.fossology.client.model.job.Job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetJobHandler extends HttpResponseHandler<Job>{

	private static Logger logger = LogManager.getLogger(GetJobHandler.class);

	@Override
	public Job transform(HttpResponse response, StringBuilder stringBuilder) {
		ObjectMapper mapper = new ObjectMapper();
		Job job = null;
		
		try {
			job = mapper.readValue(stringBuilder.toString(), Job.class);
		    return job;
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		}
		
		return job;
	}
	
	
	
}
