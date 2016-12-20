package org.hubotek.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.hubotek.HubotekException;

import com.google.common.base.Splitter;

public abstract class EncoderHelper {

	private static List<String> filterElements = new ArrayList<String>();
	
	static {
		filterElements.add("site:");
	}

	public static String encode(String queryString)
	{ 
		List<String> resultList = new ArrayList<String>();
		Splitter.on(' ').trimResults().split(queryString).forEach(p -> resultList.add(encodeElement(p)));
		return resultList.stream().reduce((a,e)  -> a +='+'+e).get();
	}

	private static String encodeElement(String element)
	{ 
		String result;
		try { 
			result =   filterElements.stream().filter(p-> element.contains(p)).count() == 0 ? URLEncoder.encode(element , "UTF-8") : element;
		} catch (UnsupportedEncodingException e) {
			throw new HubotekException(e);
		}
		return result;
	}

	public static void main(String[] args)
	{ 
		System.out.println(encode("Search string: for encoding site:google.com"));
	}
}
