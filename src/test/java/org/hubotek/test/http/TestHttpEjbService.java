package org.hubotek.test.http;

import javax.ejb.EJB;

import org.hubotek.service.ejb.HttpService;
import org.hubotek.test.BaseModelDeployer;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestHttpEjbService extends BaseModelDeployer{

	
	@EJB
	HttpService httpService;
	
	@Test
	public void test()
	{ 
		httpService.doRequest("An Url To Perform A Request");
	}
}
