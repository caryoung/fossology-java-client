package org.polaris.fossology.client.httpclient;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.util.HttpClientUtil;

public class HttpGetFileMethod<T> {

	private static Logger logger = LogManager.getLogger(HttpGetFileMethod.class);

	private File file = null;
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	private Request request = null;

	public T getFiles() {
		Executor executor = null;
		Response response = null;
		HttpClientUtil util = new HttpClientUtil();
		try (CloseableHttpClient closeableHttpClient = util.getClient();) {
			executor = Executor.newInstance(closeableHttpClient);
			response = executor.execute(request);
			response.saveContent(file);
		} catch (IOException e) {
			logger.error(e, e);
		}
		return null;
	}
}
