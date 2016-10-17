package org.hubotek.service.converter;

import org.hubotek.HubotekException;
import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;
import org.hubotek.service.ejb.document.DocumentConverter;

public class AtomDocumentConverter implements DocumentConverter<AtomDocument>{

	@Override
	public AtomDocument convert(String xmlString) {
		try { 
				return new AtomDocumentBuilder().withDocument(generateDocumentFromString(xmlString)).build();
		}catch (Exception ex)
		{ 
			throw new HubotekException(ex);
		}
	}

}
