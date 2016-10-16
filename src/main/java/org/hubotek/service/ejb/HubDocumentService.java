package org.hubotek.service.ejb;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentType;

public interface HubDocumentService extends LocalService{

	<T extends HubDocument> T requestDocumentFromUrl(String uri , HubDocumentType documentType);
	
}
