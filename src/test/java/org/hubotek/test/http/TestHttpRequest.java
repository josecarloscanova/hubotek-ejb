package org.hubotek.test.http;

import java.io.StringReader;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.model.rss.RssItem;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.util.DomParser;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class TestHttpRequest {
	
	@Test
	public void should_send_http_request() throws Exception
	{ 
		HttpRequestProcessor processor = new HttpRequestProcessor();
		String response = processor.processRequest("https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss", new HttpRequestParameters());
		Document document = generateDocumentFromString(response);
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(document).build();
		rssDocument.getRssItems().stream().forEach(i -> print(i));
	}
	
	private void print(RssItem i) {
		System.err.println(i.getTitle());
	}

	public Document generateDocumentFromString(String xmlString) throws Exception
	{ 
		InputSource source = new InputSource(new StringReader(xmlString));
		DomParser parser = new DomParser();
		return parser.parseInput(source);
	}
}
