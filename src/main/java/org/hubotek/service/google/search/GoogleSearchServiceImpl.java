package org.hubotek.service.google.search;

import java.io.PrintStream;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.google.search.SearchParameterTemplate;
import org.hubotek.service.data.CseKeyService;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.RequestType;
import org.hubotek.service.http.impl.HttpRequestProcessorServiceImpl;
import org.hubotek.util.EncoderHelper;

@Stateless
public class GoogleSearchServiceImpl  implements GoogleSearchService{

	private static final long serialVersionUID = 8258092920115020536L;

	private static final String GOOGLE_SEARCH_URL = "https://www.googleapis.com/customsearch/v1";

	private static final PrintStream out = System.out;
	
	@Inject
	private GoogleSearchUrlBuilder googleSearchUrlBuilder;
	
	@Inject @Named("cseKeyService")
	CseKeyService cseKeyService;

	@Inject @Named("httpRequestProcessor")
	HttpRequestProcessorServiceImpl httpRequestProcessor; 
	
	public GoogleSearchServiceImpl (){}

	public GoogleSearchServiceImpl (GoogleSearchUrlBuilder googleSearchUrlBuilder)
	{ 
		this.googleSearchUrlBuilder = googleSearchUrlBuilder;
	}

	public String doSearch(SearchParameterTemplate spt) {
		return httpRequestProcessor.processRequest(prepareUrl(spt) , new HttpRequestParameters() , RequestType.GET);
	}

	private String prepareUrl(SearchParameterTemplate spt)
	{ 
		return new StringBuffer().append(GOOGLE_SEARCH_URL).append('?').append(mountQueryString(spt)).toString();
	}

	private String mountQueryString(SearchParameterTemplate spt)
	{ 
		return googleSearchUrlBuilder.withAlt(spt.getAlt())
				.withCountry(spt.getCountry())
				.withCx(spt.getCx())
				.withLanguage(spt.getLanguage())
				.withNum(spt.getNum())
				.withSafe(spt.getSafe())
				.withSearchTerms(EncoderHelper.encode(spt.getSearchTerms()))
				.withSort(spt.getSort())
				.withStartIndex(spt.getStartIndex())
				.withKey(cseKeyService.getCurrentKey().getKey())
				.build();
	}


	public static void main(String[] args)
	{ 
		GoogleSearchUrlBuilder googleSearchUrlBuilder = new GoogleSearchUrlBuilder();
		SearchParameterTemplate spt = new SearchParameterTemplate();
		spt.setSearchTerms("java language");
		spt.setAlt("json");
		spt.setCx("partner-pub-6996754678263425:6706236868");
		spt.setLanguage("us");
		spt.setSafe("off");
		spt.setSort("date");
		out.println(new GoogleSearchServiceImpl(googleSearchUrlBuilder.withKey("AIzaSyBof_lvJ8KJDjwnNJLw4KVtn3DeR7IreXk")).prepareUrl(spt));
	}

}
