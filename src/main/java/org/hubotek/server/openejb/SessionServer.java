package org.hubotek.server.openejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SessionServer
 */
@Stateless(mappedName = "sessionServer")
@LocalBean
public class SessionServer implements SessionServerLocal {

    /**
     * Default constructor. 
     */
    public SessionServer() {
    }
    
    @PostConstruct
    public void prepare()
    { 
    }

	@Override
	public String getSomeInfo() {
		return "Some info to be Processed by a EJB client interface";
	}

}
