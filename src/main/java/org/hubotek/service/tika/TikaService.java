package org.hubotek.service.tika;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.apache.tika.config.TikaConfig;
import org.hubotek.HubotekException;

@Named 
public class TikaService {

	public TikaService() {
	}

	@PostConstruct
	void prepare()
	{ 
		try{ 
			TikaConfig tikaConfig = new TikaConfig();
		}catch(Exception ex)
		{ 
			throw new HubotekException(ex);
		}
	}


	@PreDestroy
	void destroy()
	{ 

	}
}
