package org.polaris.fossology.client.request.job.handler;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpResponseHandler;
import org.polaris.fossology.client.model.job.Job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class GetJobsHandler extends HttpResponseHandler<List<Job>>{

	private static Logger logger = LogManager.getLogger(GetJobsHandler.class);

	@Override
	public List<Job> transform(HttpResponse response, StringBuilder stringBuilder) {
		List<Job> list = new ArrayList<Job>();
		
		ObjectMapper mapper = new ObjectMapper();
		Job[] Jobs = null;
		
		try {
			Jobs = mapper.readValue(stringBuilder.toString(), Job[].class);
			for(Job Job : Jobs) {
				logger.info(Job);
				list.add(Job);
			}
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		}
		
		return list;
	}
	
	
	
}
