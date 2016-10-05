package test.org.hubotek.service.repository.orm;

import javax.inject.Inject;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.cse.GoogleSearchEngineBase;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.service.orm.PersistenceService;
import org.hubotek.test.BasePersistenceTestClass;
import org.hubotek.test.BaseTestClass;
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
public class TestPersistenceService  extends BaseTestClass{

	@Inject 
	PersistenceService persistenceService;
	
	@Inject
	UserTransaction utx;
	
	@Deployment
	public static JavaArchive createDeployment()
	{ 
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(PersistenceService.class.getPackage())
				.addPackage(BasePersistenceTestClass.class.getPackage())
				.addPackage(Base.class.getPackage())
				.addPackage(GoogleApiKey.class.getPackage())
				.addPackage(DOMElementExtratorUtil.class.getPackage())
				.addPackage(ElementEnum.class.getPackage())
				.addPackage(HubDocument.class.getPackage())
				.addPackage(RssDocument.class.getPackage())
				.addPackage(NamedUrl.class.getPackage())
				.addPackage(GoogleSearchEngineBase.class.getPackage())
				.addClass(GoogleBase.class)
				.addPackage(NewsTopic.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("log4j.properties", "log4j.properties")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
	}
	
	
	@Test
	public void should_verify_entity_manager() throws Exception {
		utx.begin();
		NewsTopic n = new NewsTopic();
		n.setId(1l);
		n.setTopic("Simple Topic");
		persistenceService.delete(NewsTopic.class);
		persistenceService.save(n);
		utx.commit();
	}
	
	
}
