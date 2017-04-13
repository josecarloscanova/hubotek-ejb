package org.hubotek.service.http.header;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Holds the header captured during a response processsing. 
 * 
 * @author JoseCanova
 *
 */
public class HttpHeaders {
	
	List<HttpHeader> headerList;

	//an object constructor
	public HttpHeaders(){
		headerList = new ArrayList<HttpHeader>();
	}
	
	public HttpHeader[] headers()
	{ 
		return headerList.stream().collect(Collectors.toList()).toArray(new HttpHeader[headerList.size()]);
	}
	
	public void addHeader(HttpHeader header)
	{ 
			headerList.add(header); 
	}

}