package test.org.hubotek.service.data;

import javax.inject.Inject;
import javax.transaction.UserTransaction;

import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.cse.GoogleSearchEngine;
import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.data.FeedService;
import org.hubotek.service.data.GoogleSearchEngineService;
import org.hubotek.service.orm.PersistenceService;
import org.hubotek.test.BasePersistenceTestClass;
import org.hubotek.util.DOMElementExtratorUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nanotek.Base;

@RunWith(Arquillian.class)
public class BasePersistenceServiceTest {

	@Inject 
	FeedService feedService;
	
	@Inject
	GoogleSearchEngineService googleSearchEngineService;
	
	@Inject
	UserTransaction utx;
	
	@Deployment
	public static JavaArchive createDeployment()
	{ 
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(DataBaseService.class.getPackage())
				.addPackage(FeedService.class.getPackage())
				.addPackage(GoogleSearchEngineService.class.getPackage())
				.addPackage(GoogleSearchEngine.class.getPackage())
				.addPackage(FeedUrl.class.getPackage())
				.addPackage(PersistenceService.class.getPackage())
				.addPackage(BasePersistenceTestClass.class.getPackage())
				.addPackage(Base.class.getPackage())
				.addPackage(GoogleApiKey.class.getPackage())
				.addPackage(DOMElementExtratorUtil.class.getPackage())
				.addPackage(ElementEnum.class.getPackage())
				.addPackage(HubDocument.class.getPackage())
				.addPackage(RssDocument.class.getPackage())
				.addPackage(NamedUrl.class.getPackage())
				.addClass(GoogleBase.class)
				.addPackage(NewsTopic.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("log4j.properties", "log4j.properties")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
	}
	
	@Test
	public void test(){}
	
	@Test
	public void testSaveCseEngine()  throws Exception
	{ 
		utx.begin();
		googleSearchEngineService.deleteAll();
		GoogleSearchEngine n = new GoogleSearchEngine();
		n.setId("cx-id-for-service");
		n.setDescription("A simple Description new Test");
		n.setName("CSE-NAME");
		googleSearchEngineService.saveSearchEngineDefinition(n);
		utx.commit();
	}
	
	@Test
	public void testSaveFeedUrl() throws Exception
	{ 
			utx.begin();
			feedService.deleteAll();
			FeedUrl n = new FeedUrl();
			n.setId(1l);
			n.setUrl("A Simple Url For Test");
			feedService.saveFeedUrl(n);
			utx.commit();
	}
	
}
