package org.hubotek.service.http;

import org.apache.http.client.fluent.Request;

@FunctionalInterface
public interface RequestReference {
	
	Request prepare(String url);

}
