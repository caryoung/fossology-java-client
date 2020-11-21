package org.polaris.fossology.client.request.job;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpGetMethod;
import org.polaris.fossology.client.httpclient.HttpPostMethod;
import org.polaris.fossology.client.model.job.Job;
import org.polaris.fossology.client.model.job.request.GetJobsRequest;
import org.polaris.fossology.client.model.job.request.PostJobsRequestBody;
import org.polaris.fossology.client.model.job.request.PostJobsRequestHead;
import org.polaris.fossology.client.request.job.handler.AddJobHandler;
import org.polaris.fossology.client.request.job.handler.GetJobHandler;
import org.polaris.fossology.client.request.job.handler.GetJobsHandler;
import org.polaris.fossology.client.util.Consts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobRequest {

	private static Logger logger = LogManager.getLogger(JobRequest.class);

	
	/**
	 * get all jobs in fossology
	 * 
	 */
	public List<Job> get(GetJobsRequest requestBean) {
		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/jobs";
		HttpUriRequest request = new HttpGet(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);
		request.addHeader("limit", ""+requestBean.getLimit());
		request.addHeader("page", ""+requestBean.getPage());
		Integer upload = requestBean.getUpload();
		if(upload != null) {
			request.addHeader("upload", ""+upload);
		}

		HttpGetMethod<List<Job>> getMethod = new HttpGetMethod<List<Job>>();
		getMethod.setRequest(request);

		GetJobsHandler handler = new GetJobsHandler();
		getMethod.setHandler(handler);
		List<Job> list = getMethod.get();
		return list;
	}

	public Job get(int jobId) {
		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/jobs"+"/"+jobId;
		HttpUriRequest request = new HttpGet(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);

		HttpGetMethod<Job> getMethod = new HttpGetMethod<Job>();
		getMethod.setRequest(request);
		
		GetJobHandler handler = new GetJobHandler();
		getMethod.setHandler(handler);
		
		Job result = getMethod.get();
		
		return result;
	}

	public int add(PostJobsRequestHead requestHead, PostJobsRequestBody requestBody) {
		int JobId = 0;

		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/jobs";
		HttpPost request = new HttpPost(uri);
		request.addHeader(Consts.FOLDER_ID, ""+requestHead.getFolderId());
		request.addHeader(Consts.UPLOAD_ID, ""+requestHead.getUploaderId());
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		
		HttpPostMethod<Integer> postMethod = new HttpPostMethod<Integer>();
		try {
			json = objectMapper.writeValueAsString(requestBody);
			StringEntity entity =  new StringEntity(json);
			request.setEntity(entity);
			
			AddJobHandler handler = new AddJobHandler();
			postMethod.setHandler(handler);
			JobId = postMethod.post();
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e, e);
		}
		
		return JobId;
	}
	
}
