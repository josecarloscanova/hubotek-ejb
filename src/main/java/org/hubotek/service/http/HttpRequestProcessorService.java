package org.hubotek.service.http;

import org.hubotek.service.RequestProcessorService;

@FunctionalInterface
public interface HttpRequestProcessorService extends RequestProcessorService<HttpProcessorResponse,HttpRequestParameters,RequestType, String>{
}
