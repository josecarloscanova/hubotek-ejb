package org.hubotek.service;


@FunctionalInterface
public interface RequestProcessorService<T,R,I,P> extends Service {

	T processRequest(P url , R requestParameters , I requestType);
	
}
