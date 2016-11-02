package org.hubotek.service.http;

import org.hubotek.service.RequestProcessorService;

@FunctionalInterface
public interface HttpRequestProcessorService extends RequestProcessorService<String,HttpRequestParameters,RequestType, String>{
}
