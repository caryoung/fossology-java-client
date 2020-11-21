package org.polaris.fossology.client.httpclient;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.util.HttpClientUtil;

public class HttpDeleteMethod<T> {

	private static Logger logger  = LogManager.getLogger(HttpDeleteMethod.class);
	
	public ResponseHandler<T> getHandler() {
		return handler;
	}

	public void setHandler(ResponseHandler<T> handler) {
		this.handler = handler;
	}

	public HttpUriRequest getRequest() {
		return request;
	}

	public void setRequest(HttpUriRequest request) {
		this.request = request;
	}

	private ResponseHandler<T> handler = null;
	private HttpUriRequest request = null;

	public T post() {
		HttpClientUtil util = new HttpClientUtil();
		try (CloseableHttpClient closeableHttpClient = util.getClient();
				CloseableHttpResponse response = closeableHttpClient.execute(request)) {
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			logger.info(" status code: "+statusCode);
			
			return handler.handleResponse(response);
		} catch (IOException e) {
			logger.error(e, e);
		}
		
		return null;
	}

}
