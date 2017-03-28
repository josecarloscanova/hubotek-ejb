package org.hubotek.service.news.feed;

import org.hubotek.SingleMapper;
import org.hubotek.model.news.feed.FeedSource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="cdi")
public interface FeedSourceMapper extends SingleMapper<FeedSource,Feed>{

	@Override
	@Mappings({
				@Mapping(source="feed.feedId" , target="id"),
				@Mapping(source="" , target="")
			  }
			)
	FeedSource from(Feed feed);
	
}
