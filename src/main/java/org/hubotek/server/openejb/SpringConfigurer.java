package org.hubotek.server.openejb;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.hubotek.model.spring.SpringConfiguration;

@Startup
@Singleton
public class SpringConfigurer {

	@Lock(LockType.READ)
	SpringConfiguration checkConfiguration()
	{ 
		return new SpringConfiguration();
	}
	
}
