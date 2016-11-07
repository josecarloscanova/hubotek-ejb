package org.hubotek.service.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.service.DataBaseService;

@Named
public class FeedService extends DataBaseService<FeedUrl , Long> {

	public FeedUrl saveFeedUrl(FeedUrl feedUrl)
	{ 
		return persistenceService.save(feedUrl);
	}
	
	public FeedUrl findById(Long id)
	{ 
		return persistenceService.find(FeedUrl.class, id);
	}
	
	public FeedUrl findByName(String name)
	{ 
		TypedQuery<FeedUrl> query =  persistenceService.createQuery("Select fu from FeedUrl fu where fu.name = :yours" , FeedUrl.class); 
		query.setParameter("yours", name);
		return query.getSingleResult();
	}
	
	public void deleteAll ()
	{ 
		persistenceService.delete(FeedUrl.class);
	}

}
