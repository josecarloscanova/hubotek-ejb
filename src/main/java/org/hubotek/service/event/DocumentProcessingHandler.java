package org.hubotek.service.event;

import org.hubotek.service.ejb.LocalService;

public interface DocumentProcessingHandler extends LocalService{
	
	void processXmlStringDocument(DocumentProcessingEvent documentProcessingEvent);
	
}
