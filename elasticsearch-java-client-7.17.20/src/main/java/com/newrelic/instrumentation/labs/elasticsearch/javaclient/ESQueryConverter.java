package com.newrelic.instrumentation.labs.elasticsearch.javaclient;

import java.util.Map;

import com.newrelic.api.agent.QueryConverter;

public class ESQueryConverter implements QueryConverter<QueryHolder> {

	@Override
	public String toRawQueryString(QueryHolder rawQuery) {
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
		return sb.toString();
	}

	@Override
	public String toObfuscatedQueryString(QueryHolder rawQuery) {
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
		return sb.toString();
	}


}
