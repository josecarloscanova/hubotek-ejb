package org.hubotek.test.services;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.service.google.news.GoogleNewsService;
import org.hubotek.test.BaseEarModelDeployer;
import org.hubotek.util.DomParser;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xml.sax.InputSource;

@RunWith(Arquillian.class)
public class TestGoogleNewsService extends BaseEarModelDeployer {

	@EJB
	GoogleNewsService googleNewsService; 
	
/*	@Inject @Named("hubotekRssDocumentTransformer")
	Function<RssDocument , HubotekDocument> hubotekRssDocumentTransformer;// = r -> new HubotekRssDocumentTransformer().apply(r);
*/	
	
	@PersistenceContext
    protected EntityManager entityManager;
    
    @Inject
    protected UserTransaction utx;
    
    @Before
    public  void beginTransaction() throws Exception
	{ 
		utx.begin();  
		entityManager.joinTransaction(); 
	}
	
    @After
    public  void commitTransaction() throws Exception
	{ 
		utx.commit();
	}
	
	/*@Test
	public void should_work_google_news_service_request()
	{ 
		String responseString = googleNewsService.processRequest();
		DomParser domParser = new DomParser();
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(domParser.parseInput(new InputSource(new StringReader(responseString)))).build();
		assertNotNull(responseString);
		System.err.println(responseString);
		Stream.of(new RssDocument[]{rssDocument}).forEach(r -> persist(r));
	}

	@Test
	public void should_work_google_news_service_request_top()
	{ 
		String responseString = googleNewsService.processRequestTop();
		DomParser domParser = new DomParser();
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(domParser.parseInput(new InputSource(new StringReader(responseString)))).build();
		assertNotNull(responseString);
		System.err.println(responseString);
		Stream.of(new RssDocument[]{rssDocument}).forEach(r -> persist(r));
	}
	
	@Test
	public void should_work_google_news_service_request_entertaiment()
	{ 
		String responseString = googleNewsService.processRequestEntertainement();
		DomParser domParser = new DomParser();
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(domParser.parseInput(new InputSource(new StringReader(responseString)))).build();
		assertNotNull(responseString);
		System.err.println(responseString);
		Stream.of(new RssDocument[]{rssDocument}).forEach(r -> persist(r));
	}
	
	@Test
	public void should_work_google_news_service_request_world()
	{ 
		String responseString = googleNewsService.processRequestWorld();
		DomParser domParser = new DomParser();
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(domParser.parseInput(new InputSource(new StringReader(responseString)))).build();
		assertNotNull(responseString);
		System.err.println(responseString);
		Stream.of(new RssDocument[]{rssDocument}).forEach(r -> persist(r));
	}*/
	
	@Test
	public void should_work_google_news_service_request_search()
	{ 
		String responseString = googleNewsService.processRequestSearch("ISIS site:cnn.com");
		DomParser domParser = new DomParser();
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(domParser.parseInput(new InputSource(new StringReader(responseString)))).build();
		assertNotNull(responseString);
		System.err.println(responseString);
		Stream.of(new RssDocument[]{rssDocument}).forEach(r -> persist(r));
	}
	
	private void persist(RssDocument r) {
		entityManager.persist(r);;
	}
	
}
