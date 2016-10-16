package org.hubotek.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.hubotek.server.ejb.ServiceFacade;
import org.hubotek.server.ejb.SessionFacadeServer;
import org.hubotek.service.Service;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.service.http.RequestType;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class BaseEarModelDeployer {

	@EJB
	private ServiceFacade someEjb;

	@Inject
	private HttpRequestProcessor requestProcessor;


	@Deployment
	public static Archive<?> createDeploymentPackage() throws IOException {

		File[] files = Maven.resolver().loadPomFromFile("src/test/resources/ear/test-pom.xml")
				.importRuntimeDependencies().resolve().withTransitivity().asFile();

		Stream<File> jarFilesStream = Arrays.asList(files).stream();//.forEach(s -> print(s.getName()))

		final JavaArchive ejbJar = ShrinkWrap.create(JavaArchive.class, "ejb-jar.jar")
				.addClass(ServiceFacade.class)
				.addClass(SessionFacadeServer.class)
				.addPackage(Service.class.getPackage())
				.addPackage(HttpRequestProcessor.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

		// Embedding war package which contains the test class is needed
		// So that Arquillian can invoke test class through its servlet test runner
		final WebArchive testWar = ShrinkWrap.create(WebArchive.class, "test.war").addClass(BaseEarModelDeployer.class);
		final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
				.setApplicationXML("ear/test-application.xml")
				.addAsModule(ejbJar)
				.addAsModule(testWar);
		jarFilesStream.forEach(jf -> ear.addAsLibraries(jf));
		return ear;
	}

	/*private static void print(String value) {
			System.err.println(value);
		}*/

	@Test
	public void test() {
		Assert.assertEquals("Hello, Kyle", someEjb.hello("Kyle"));
	}
	
	@Test
	public void test_http_call()
	{ 
		String response = requestProcessor.processRequest("https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss", new HttpRequestParameters() , RequestType.GET);
		Assert.assertNotNull(response);
		System.err.println(response);
	}

}
