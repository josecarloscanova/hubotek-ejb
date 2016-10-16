package org.hubotek.server.ejb;

import javax.ejb.Local;

@Local
public interface ServiceFacade {

	String hello(String hi);
	
}
