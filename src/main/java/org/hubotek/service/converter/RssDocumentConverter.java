package org.hubotek.service.converter;

import org.hubotek.HubotekException;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.service.ejb.document.DocumentConverter;

public class RssDocumentConverter implements DocumentConverter<RssDocument>{

	@Override
	public RssDocument convert(String xmlString) {
		try { 
			return new RssDocumentBuilder().withDocument(generateDocumentFromString(xmlString)).build();
	}catch (Exception ex)
	{ 
		throw new HubotekException(ex);
	}
	}

}
