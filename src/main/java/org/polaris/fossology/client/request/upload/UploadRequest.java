package org.polaris.fossology.client.request.upload;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpGetMethod;
import org.polaris.fossology.client.httpclient.HttpPostMethod;
import org.polaris.fossology.client.model.DefaultResponse;
import org.polaris.fossology.client.model.upload.UploadRequestBody;
import org.polaris.fossology.client.model.upload.UploadRequestHead;
import org.polaris.fossology.client.model.upload.UploadResponse;
import org.polaris.fossology.client.request.upload.handler.GetUploadHandler;
import org.polaris.fossology.client.request.upload.handler.PostUploadHandler;
import org.polaris.fossology.client.util.Consts;

public class UploadRequest {

	private static Logger logger = LogManager.getLogger(UploadRequest.class);

	/**
	 * get all jobs in fossology
	 * 
	 */
	public UploadResponse get(int id) {
		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/uploads" + "/" + id;
		HttpUriRequest request = new HttpGet(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);

		HttpGetMethod<UploadResponse> getMethod = new HttpGetMethod<UploadResponse>();
		getMethod.setRequest(request);

		GetUploadHandler handler = new GetUploadHandler();
		getMethod.setHandler(handler);
		UploadResponse responseBean = getMethod.get();
		return responseBean;
	}

	public UploadResponse post(UploadRequestHead requestHead, UploadRequestBody requestBody) {
		int JobId = 0;

		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/jobs";
		HttpPost request = new HttpPost(uri);
		request.addHeader(Consts.FOLDER_ID, "" + requestHead.getFolderId());
		request.addHeader(Consts.PUBLIC_STRING, "" + requestHead.getPublicAccess());
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);
		request.addHeader(HttpHeaders.CONTENT_TYPE,
				Consts.CONTENT_TYPE_MULTIPART + ";" + ";boundary=" + Consts.BOUNDARY);
		request.addHeader("ignoreScm", "true");

		String filePath = requestBody.getFileInput();
		int index = filePath.lastIndexOf("/");
		String fileName = filePath.substring(index + 1);
		File file = new File(filePath);
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		multipartEntityBuilder.setMode(HttpMultipartMode.STRICT);
		FormBodyPartBuilder formBodyPartBuilder = FormBodyPartBuilder.create();
		FileBody fileBody = new FileBody(file, ContentType.APPLICATION_OCTET_STREAM, fileName);
		formBodyPartBuilder.setName("fileInput");
		formBodyPartBuilder.setBody(fileBody);
		FormBodyPart bodyPart = formBodyPartBuilder.build();
		multipartEntityBuilder.addPart(bodyPart);
		multipartEntityBuilder.setBoundary(Consts.BOUNDARY);
		HttpEntity httpEntity = multipartEntityBuilder.build();
		request.setEntity(httpEntity);

		HttpPostMethod<DefaultResponse> getMethod = new HttpPostMethod<DefaultResponse>();
		getMethod.setRequest(request);

		PostUploadHandler handler = new PostUploadHandler();
		getMethod.setHandler(handler);

		DefaultResponse defaultResponse = getMethod.post();
		UploadResponse uploadResponse = new UploadResponse();
		String idStr = defaultResponse.getMessage();
		uploadResponse.setId(Integer.parseInt(idStr));

		return uploadResponse;
	}

}
