package org.polaris.fossology.client.request.folder.handler;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpResponseHandler;
import org.polaris.fossology.client.model.folders.Folder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class GetFolderHandler extends HttpResponseHandler<List<Folder>>{

	private static Logger logger = LogManager.getLogger(GetFolderHandler.class);

	@Override
	public List<Folder> transform(HttpResponse response, StringBuilder stringBuilder) {
		List<Folder> list = new ArrayList<Folder>();
		
		ObjectMapper mapper = new ObjectMapper();
		Folder[] folders = null;
		
		try {
			folders = mapper.readValue(stringBuilder.toString(), Folder[].class);
			for(Folder folder : folders) {
				logger.info(folder);
				list.add(folder);
			}
		} catch (JsonProcessingException e) {
			logger.error(e, e);
		}
		
		return list;
	}
	
	
	
}
