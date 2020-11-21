package org.polaris.fossology.client.httpclient;

import org.apache.http.HttpResponse;

public interface ReponseTransform<T> {
	public T transform(HttpResponse response, StringBuilder stringBuilder);
}
