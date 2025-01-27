package com.newrelic.instrumentation.labs.elasticsearch.highlevelrest;

import com.newrelic.api.agent.QueryConverter;

public class ESQueryConverter implements QueryConverter<String> {

	@Override
	public String toRawQueryString(String rawQuery) {
		return rawQuery;
	}

	@Override
	/**
	 * Always obfuscate the id
	 */
	public String toObfuscatedQueryString(String rawQuery) {
		int index = rawQuery.lastIndexOf('/');
		if(index < 1) {
			return rawQuery;
		}
		
		return rawQuery.substring(0, index) + "/?";
	}

}
