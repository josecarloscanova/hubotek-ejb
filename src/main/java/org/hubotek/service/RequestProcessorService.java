package org.hubotek.service;


@FunctionalInterface
public interface RequestProcessorService<T,R,I,P> extends Service {

	T processRequest(P location , R requestParameters , I requestType);
	
}
