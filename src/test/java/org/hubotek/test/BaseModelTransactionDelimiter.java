package org.hubotek.test;

import org.junit.After;
import org.junit.Before;

public class BaseModelTransactionDelimiter extends BaseModelDeployer {
	
	@Before
	public void start_transaction() throws Exception
	{ 
		beginTransaction();
	}
	
	@After 
	public void endTransaction() throws Exception
	{ 
		commitTransaction();
	}

}
