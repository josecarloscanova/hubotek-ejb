package org.hubotek.server.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hubotek.service.http.HttpRequestProcessor;

/**
 * TODO: Check the LocalBean annotation.
 * 
 * @author JoseCanova
 *
 */
		
@Stateless(mappedName = "sessionFacadeServer")
@LocalBean
public class SessionFacadeServer implements ServiceFacade{

	@Inject 
	HttpRequestProcessor requestProcessor; 
	
	@Override
	public String hello(String hi) {
		return "Hello, "+ hi;
	}

}
