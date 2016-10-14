package org.hubotek.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.atom.AtomBase;
import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.cse.GoogleSearchEngine;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.lob.AtomDocumentContent;
import org.hubotek.model.lob.GoogleResultItem;
import org.hubotek.model.lob.RssItemDescription;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.search.GoogleSearchResult;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.data.RssDocumentService;
import org.hubotek.service.orm.PersistenceService;
import org.hubotek.util.DOMElementExtratorUtil;
import org.hubotek.util.DomParser;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.nanotek.Base;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class BaseModelDeployer extends BaseModelPersistenceTestClass{
	@Deployment
	public static JavaArchive createDeployment() {

		/*File[] files = Maven.resolver().loadPomFromFile("pom.xml")
				.importRuntimeDependencies().resolve().withTransitivity().asFile();*/

		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(FeedUrl.class.getPackage())
				.addPackage(AtomDocumentContent.class.getPackage())
				.addPackage(AtomBase.class.getPackage())
				.addPackage(BaseModelPersistenceTestClass.class.getPackage())
				.addPackage(Base.class.getPackage())
				.addPackage(GoogleApiKey.class.getPackage())
				.addPackage(DOMElementExtratorUtil.class.getPackage())
				.addPackage(ElementEnum.class.getPackage())
				.addPackage(HubDocument.class.getPackage())
				.addPackage(RssDocument.class.getPackage())
				.addPackage(RssItemDescription.class.getPackage())
				.addPackage(NamedUrl.class.getPackage())
				.addPackage(GoogleSearchEngine.class.getPackage())
				.addPackage(GoogleBase.class.getPackage())
				.addPackage(NewsTopic.class.getPackage())
				.addPackage(GoogleResultItem.class.getPackage())
				.addPackage(GoogleSearchResult.class.getPackage())
				.addPackage(DataBaseService.class.getPackage())
				.addPackage(RssDocumentService.class.getPackage())
				.addPackage(PersistenceService.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsResource("log4j.properties", "log4j.properties");
	}
	
	public Document generateDocumentFromSoource(String fileLocation) throws Exception
	{ 
		InputStream is =  new FileInputStream(new File(fileLocation));
		DomParser parser = new DomParser();
		return parser.parseInput(new InputSource(is));
	}
}
