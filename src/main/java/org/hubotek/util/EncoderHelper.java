package org.hubotek.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.hubotek.HubotekException;

public abstract class EncoderHelper {

	public static String encode(String queryString)
	{ 
		String result;
		try {
			  result = URLEncoder.encode(queryString , "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new HubotekException(e);
		}
		return result;
	}
	
}
