package org.hubotek.server.openejb;

import javax.ejb.Local;

@Local
public interface SessionServerLocal {
	
	String getSomeInfo();
	
}
