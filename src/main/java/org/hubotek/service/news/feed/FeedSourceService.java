package org.hubotek.service.news.feed;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.news.feed.FeedSource;
import org.hubotek.service.orm.PersistenceService;

/**
 * Used to manage feed sources origins.
 * @author JoseCanova
 *
 */
@Named(value="feedSourceService")
public class FeedSourceService {

	@Inject
	PersistenceService persistenceService; 
	
	@Inject 
	FeedMapper feedMapper; 
	
	@Inject
	FeedSourceMapper feedSourceMapper;
	
	public FeedSourceService() {
	}

	public void addFeedSource(Feed feed)
	{ 
		persistenceService.save(feedSourceMapper.from(feed));
	}
	
	public void removeFeedSource(Feed feed)
	{ 
		FeedSource feedSource = persistenceService.find(FeedSource.class, feed.getFeedId());
		persistenceService.remove(feedSource);
	}
	
	public void updateFeedSource(Feed feed)
	{ 
		persistenceService.save(feedSourceMapper.from(feed));
	}
	
	public List<Feed> listFeedSources()
	{ 
		return persistenceService.createQuery("from FeedSource f" , FeedSource.class).getResultList().stream().map(fs ->feedMapper.from(fs)).collect(Collectors.toList()); 
	}
	
	public List<Feed> findFeedSourceByName(String nameParam)
	{ 
		return persistenceService.createQuery("from FeedSource f where f.feedName like :nameParam" , FeedSource.class).setParameter("nameParam", nameParam) .getResultList().stream().map(fs ->feedMapper.from(fs)).collect(Collectors.toList());
	}
}
