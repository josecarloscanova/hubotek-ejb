package org.hubotek.service;

@FunctionalInterface
public interface MimeTypeDetector<O,T> {

	public T detecMimeType(O origin);
	
}
