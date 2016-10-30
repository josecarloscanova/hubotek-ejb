package org.nanotek.web.google.news;

import java.io.IOException;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import org.hubotek.service.google.news.GoogleNewsService;
import org.nanotek.web.google.GoogleResourceBase;

@Path("/google/news")
public class GoogleNewsResource extends GoogleResourceBase{

	@EJB 
	GoogleNewsService googleNewsService; 

	@Path("/top")
	@Produces("application/xml")
	public StreamingOutput getNewsTopic(@PathParam("topic") String topic)
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(googleNewsService.processRequest().getBytes());
			}
		};
	}

}
