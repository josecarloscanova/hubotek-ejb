package org.hubotek.service.google.search;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.function.Function;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.hubotek.model.google.search.SearchParameterTemplate;
import org.hubotek.service.ejb.http.HttpServiceImpl;

public class GoogleSearchServiceImpl {// implements GoogleSearchService{

	//	private static final long serialVersionUID = 8258092920115020536L;

	private static final String GOOGLE_SEARCH_URL = "https://www.googleapis.com/customsearch/v1";

	private static final PrintStream out = System.out;
	
	@Inject
	private GoogleSearchUrlBuilder googleSearchUrlBuilder;

	@EJB
	private HttpServiceImpl httpService;

	public GoogleSearchServiceImpl (){}

	public GoogleSearchServiceImpl (GoogleSearchUrlBuilder googleSearchUrlBuilder)
	{ 
		this.googleSearchUrlBuilder = googleSearchUrlBuilder;
	}

	public String doSearch(SearchParameterTemplate spt) {
		return httpService.doRequest(prepareUrl(spt));
	}

	private String prepareUrl(SearchParameterTemplate spt)
	{ 
		return new StringBuffer().append(GOOGLE_SEARCH_URL).append('?').append(mountQueryString(spt)).toString();
	}

	private String mountQueryString(SearchParameterTemplate spt)
	{ 
		return googleSearchUrlBuilder.withAlt(spt.getAlt())
				.withCountry(spt.getCountry())
				.withCref(spt.getCref())
				.withCx(spt.getCx())
				.withLanguage(spt.getLanguage())
				.withNum(spt.getNum())
				.withSafe(spt.getSafe())
				.withSearchTerms(spt.getSearchTerms())
				.withSort(spt.getSort())
				.withStartIndex(spt.getStartIndex()).build();
	}


	public static void main(String[] args)
	{ 
		GoogleSearchUrlBuilder googleSearchUrlBuilder = new GoogleSearchUrlBuilder();
		SearchParameterTemplate spt = new SearchParameterTemplate();
		spt.setSearchTerms("java+language");
		spt.setAlt("json");
		out.println(new GoogleSearchServiceImpl(googleSearchUrlBuilder).mountQueryString(spt));
	}

}
