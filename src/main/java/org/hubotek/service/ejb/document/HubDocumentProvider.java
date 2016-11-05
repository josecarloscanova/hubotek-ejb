package org.hubotek.service.ejb.document;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.LocalService;

@FunctionalInterface
public interface HubDocumentProvider extends LocalService{

	HubDocument processDocument(String xmlDocumentString , HubDocumentType documentType);
	
}
