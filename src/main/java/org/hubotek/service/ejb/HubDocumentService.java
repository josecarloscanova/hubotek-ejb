package org.hubotek.service.ejb;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentType;

public interface HubDocumentService <T extends HubDocument>  extends LocalService{

	T requestDocumentFromUrl(String uri , HubDocumentType documentType);
	
}
