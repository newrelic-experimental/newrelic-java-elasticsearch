package com.newrelic.instrumentation.labs.elasticsearch.javaclient;

import java.util.Map;
import java.util.logging.Level;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.QueryConverter;

public class ESQueryConverter implements QueryConverter<QueryHolder> {

	@Override
	public String toRawQueryString(QueryHolder rawQuery) {
		NewRelic.getAgent().getLogger().log(Level.FINE, "Call to ESQueryConverter.toRawQueryString({0}", rawQuery.toString());
		String collString = rawQuery.getCollection();
		String operation = rawQuery.getOperation();
		Map<String, String> params = rawQuery.getParams();
		
		StringBuffer sb = new StringBuffer();
		sb.append(operation);
		sb.append(' ');
		sb.append(collString);
		sb.append(" Parameters: ");
		for(String key : params.keySet()) {
			sb.append(key + "=" + params.get(key) + ",");
		}
		String queryStr = sb.toString();
		NewRelic.getAgent().getLogger().log(Level.FINE, "Call to ESQueryConverter.toRawQueryString, returning {0}", queryStr);
		return queryStr;
	}

	@Override
	public String toObfuscatedQueryString(QueryHolder rawQuery) {
		NewRelic.getAgent().getLogger().log(Level.FINE, "Call to ESQueryConverter.toObfuscatedQueryString({0}", rawQuery.toString());
		String collString = rawQuery.getCollection();
		String operation = rawQuery.getOperation();
		Map<String, String> params = rawQuery.getParams();
		
		StringBuffer sb = new StringBuffer();
		sb.append(operation);
		sb.append(' ');
		sb.append(collString);
		sb.append(" Parameters: ");
		for(String key : params.keySet()) {
			sb.append(key + "=?,");
		}
		String queryStr = sb.toString();
		NewRelic.getAgent().getLogger().log(Level.FINE, "Call to ESQueryConverter.toObfuscatedQueryString, returning {0}", queryStr);
		return queryStr;
	}


}
