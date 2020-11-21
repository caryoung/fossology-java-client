package org.polaris.fossology.client.request.folder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.model.folders.CreateFolder;
import org.polaris.fossology.client.model.folders.Folder;
import org.polaris.fossology.client.request.folder.handler.AddFolderHandler;
import org.polaris.fossology.client.request.folder.handler.DeleteFolderHandler;
import org.polaris.fossology.client.request.folder.handler.GetFolderHandler;
import org.polaris.fossology.client.util.Consts;
import org.polaris.fossology.client.httpclient.HttpDeleteMethod;
import org.polaris.fossology.client.httpclient.HttpGetMethod;
import org.polaris.fossology.client.httpclient.HttpPostMethod;

public class FolderRequest {

	private static Logger logger = LogManager.getLogger(FolderRequest.class);

	/**
	 * get all folders in fossology
	 * 
	 */
	public List<Folder> get() {
		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/folders";
		HttpUriRequest request = new HttpGet(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);

		HttpGetMethod<List<Folder>> getMethod = new HttpGetMethod<List<Folder>>();
		getMethod.setRequest(request);

		GetFolderHandler handler = new GetFolderHandler();
		getMethod.setHandler(handler);
		List<Folder> list = getMethod.get();
		return list;
	}

	public Integer get(String folderName) {
		Integer result = null;
		List<Folder> folders = get();
		List<Integer> list = folders.stream().filter(folder -> folder.getName().equals(folderName))
				.map(folder -> folder.getId()).collect(Collectors.toList());
		if (list.size() == 1) {
			result = list.get(0);
		}

		return result;
	}

	public int add(CreateFolder createFolderBean) {
		int folderId = 0;

		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/folders";
		HttpUriRequest request = new HttpPost(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);
		request.addHeader("parentFolder", ""+createFolderBean.getParentFolder());
		String folderName = createFolderBean.getFolderName();
		request.addHeader(Consts.FOLDER_NAME, folderName);
		request.addHeader("folderDescription", createFolderBean.getFolderDescription());
		
		HttpPostMethod<Integer> postMethod = new HttpPostMethod<Integer>();
		postMethod.setRequest(request);
		AddFolderHandler handler = new AddFolderHandler();
		handler.setFolderName(folderName);
		postMethod.setHandler(handler);
		folderId = postMethod.post();
		
		return folderId;
	}
	
	public int delete(int folderId) {
		String uri =  Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/folders"+"/"+folderId;
		HttpUriRequest request = new HttpDelete(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);
	
		HttpDeleteMethod<Integer> deleteMethod = new HttpDeleteMethod<Integer>();
		deleteMethod.setRequest(request);
		
		DeleteFolderHandler handler = new DeleteFolderHandler();
		deleteMethod.setHandler(handler);
		
		Integer resultCode = deleteMethod.post();
		return resultCode;
	}

}
