package org.hubotek.service.ejb;

import java.io.StringReader;

import javax.ejb.Stateless;

import org.hubotek.HubotekException;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.util.DomParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;


@Stateless
public class HubDocumentServiceImpl {

	public RssDocument prepareRssDocument(String xmlString)
	{ 
		try {
			return new RssDocumentBuilder().withDocument(generateDocumentFromString(xmlString)).build();
		} catch (Exception e) {
			throw new HubotekException(e);
		}
	}

	public Document generateDocumentFromString(String xmlString) throws Exception
	{ 
		InputSource source = new InputSource(new StringReader(xmlString));
		DomParser parser = new DomParser();
		return parser.parseInput(source);
	}

}
