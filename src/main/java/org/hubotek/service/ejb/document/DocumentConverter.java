package org.hubotek.service.ejb.document;

import java.io.StringReader;

import org.hubotek.Converter;
import org.hubotek.model.HubDocument;
import org.hubotek.util.DomParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@FunctionalInterface
public interface DocumentConverter<T extends HubDocument> extends Converter<T , String> {

	default Document generateDocumentFromString(String xmlString) throws Exception
	{ 
		InputSource source = new InputSource(new StringReader(xmlString));
		DomParser parser = new DomParser();
		return parser.parseInput(source);
	}
	
}
