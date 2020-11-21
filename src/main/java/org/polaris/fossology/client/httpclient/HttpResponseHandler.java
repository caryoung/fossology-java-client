package org.polaris.fossology.client.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class HttpResponseHandler<T> implements ResponseHandler<T>, ReponseTransform<T> {

	private static Logger logger = LogManager.getLogger(HttpResponseHandler.class);

	private ReponseTransform<T> transform = null;

	public ReponseTransform<T> getTransform() {
		return transform;
	}

	public void setTransform(ReponseTransform<T> transform) {
		this.transform = transform;
	}

	public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		try (InputStream inputStream = response.getEntity().getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);) {
			StringBuilder stringBuilder = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}

			logger.info(stringBuilder.toString());
			return transform(response, stringBuilder);
		} catch (IOException e) {
			logger.error(e, e);
		}
		return null;
	}

}
