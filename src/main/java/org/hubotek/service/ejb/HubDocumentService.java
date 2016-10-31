package org.hubotek.service.ejb;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentType;

@FunctionalInterface
public interface HubDocumentService extends LocalService{

	HubDocument processDocument(String xmlDocumentString , HubDocumentType documentType);
	
}
