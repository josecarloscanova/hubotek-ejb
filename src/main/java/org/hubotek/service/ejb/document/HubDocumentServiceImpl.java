package org.hubotek.service.ejb.document;

import java.io.StringReader;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hubotek.HubotekException;
import org.hubotek.model.HubDocument;
import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.service.HubotekServiceException;
import org.hubotek.service.ejb.HubDocumentService;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.service.http.RequestType;
import org.hubotek.util.DomParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@Stateless
public class HubDocumentServiceImpl implements HubDocumentService {

	@Inject
	private HttpRequestProcessor httpRequestProcessor;
	
	@Override
	public <T extends HubDocument> T requestDocumentFromUrl(String uri, HubDocumentType documentType) {
		String xmlString = httpRequestProcessor.processRequest(uri, new HttpRequestParameters(), RequestType.GET);
		return prepareDocument (xmlString , documentType);
	}
	
	private  <T extends HubDocument> T prepareDocument(String xmlString , HubDocumentType documentType)
	{ 
		T hubDocument = null;
		switch (documentType)
		{
		case ATOM:
			hubDocument = (T) prepareAtomDocument(xmlString);
			break;
		case RSS:
			hubDocument = (T) prepareRssDocument(xmlString);
			break;
		case JSON:
			break;
		default : 
			throw new HubotekServiceException("No Document Type");
		}
		return hubDocument;
	}


	private AtomDocument prepareAtomDocument(String xmlString)
	{ 
		try {
			return new AtomDocumentBuilder().withDocument(generateDocumentFromString(xmlString)).build();
		} catch (Exception e) {
			throw new HubotekException(e);
		}
	}

	private RssDocument prepareRssDocument(String xmlString)
	{ 
		try {
			return new RssDocumentBuilder().withDocument(generateDocumentFromString(xmlString)).build();
		} catch (Exception e) {
			throw new HubotekException(e);
		}
	}

	private Document generateDocumentFromString(String xmlString) throws Exception
	{ 
		InputSource source = new InputSource(new StringReader(xmlString));
		DomParser parser = new DomParser();
		return parser.parseInput(source);
	}


}
