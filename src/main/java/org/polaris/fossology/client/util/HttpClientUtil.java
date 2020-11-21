package org.polaris.fossology.client.util;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientUtil {

	public static int maxConnTotal = 100;
	public static int connTimeToLive = 5 * 60;
	private static final HttpClientBuilder clientBuilder = HttpClientBuilder.create();
	
	static {
		clientBuilder.setMaxConnTotal(maxConnTotal);
		clientBuilder.setConnectionTimeToLive(connTimeToLive, TimeUnit.SECONDS);
		clientBuilder.disableContentCompression();
	}
	
	public CloseableHttpClient getClient(){
		getHttpClientBuidler().evictExpiredConnections();
		return getHttpClientBuidler().build();
	}

	private HttpClientBuilder getHttpClientBuidler() {
		return clientBuilder;
	}
	
}
