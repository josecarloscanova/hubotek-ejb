package org.hubotek;

import java.io.StringReader;

import org.hubotek.Converter;
import org.hubotek.model.HubDocument;
import org.hubotek.util.DomParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@FunctionalInterface
public interface DocumentConverter extends Converter<HubDocument , String> {

	default Document generateDocumentFromString(String xmlString) throws Exception
	{ 
		InputSource source = new InputSource(new StringReader(xmlString));
		return  new DomParser().parseInput(source);
	}
	
}
