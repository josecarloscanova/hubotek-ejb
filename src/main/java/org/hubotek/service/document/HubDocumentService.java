package org.hubotek.service.document;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentType;

@FunctionalInterface
public interface HubDocumentService  {

	HubDocument processDocument(String xmlDocumentString , HubDocumentType documentType);
	
}
