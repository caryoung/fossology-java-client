package org.polaris.fossology.client.request.folder.handler;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpResponseHandler;
import org.polaris.fossology.client.model.DefaultResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteFolderHandler extends HttpResponseHandler<Integer>{

	private static Logger logger = LogManager.getLogger(DeleteFolderHandler.class);

	private String folderName;
	
	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	@Override
	public Integer transform(HttpResponse response, StringBuilder stringBuilder) {
		Integer folderId = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			DefaultResponse defaultResponse = mapper.readValue(stringBuilder.toString(), DefaultResponse.class);
		    if(statusCode == HttpStatus.SC_OK) {
		    	logger.info(defaultResponse.getMessage());
		    }else if(statusCode == HttpStatus.SC_CREATED) {
		    	logger.info(defaultResponse.getMessage());
		    	folderId = Integer.parseInt(defaultResponse.getMessage());
		    }else {
		    	logger.info(defaultResponse.getMessage());
		    }
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		}
		
		return folderId;
	}
	
	
	
}
