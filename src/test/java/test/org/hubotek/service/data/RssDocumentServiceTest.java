package test.org.hubotek.service.data;

import javax.inject.Inject;

import org.hubotek.service.data.RssDocumentService;
import org.hubotek.test.BaseModelTransactionDelimiter;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class RssDocumentServiceTest extends BaseModelTransactionDelimiter {

	@Inject
	RssDocumentService documentService; 
	
	
	@Test 
	public void test_findbyId()
	{ 
		Long id = 1l; 
		assertNotNull(documentService.findById(id));
	}
	
}
