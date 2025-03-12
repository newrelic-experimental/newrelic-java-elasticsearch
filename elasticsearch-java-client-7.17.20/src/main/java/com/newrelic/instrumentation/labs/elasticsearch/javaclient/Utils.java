package com.newrelic.instrumentation.labs.elasticsearch.javaclient;

import java.util.List;
import java.util.Map;

import com.newrelic.api.agent.DatastoreParameters;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;

public class Utils {

	public static <TDocument> DatastoreParameters getParams(String operation, String index, List<String> indices, Query query, Class<TDocument> tDocumentClass) {
		String collection = "";
		if(index != null) {
			collection = tDocumentClass != null ?  index + "-" + tDocumentClass.getSimpleName() : index;
		} else if(indices != null) {
			String collectionString = getCollectionFromList(indices);
			collection = tDocumentClass != null ? collectionString + tDocumentClass.getSimpleName() : collectionString;
		} else if(query != null) {
			collection = tDocumentClass != null ? "QueryType-" + query._kind().name() + "-" + tDocumentClass.getSimpleName() : "QueryType-" + query._kind().name();
		}
		
		DatastoreParameters params = DatastoreParameters.product("ElasticSearch").collection(collection).operation(operation).noInstance().noDatabaseName().noSlowQuery().build();
		
		return params;
	}
	
	public static <RequestT> DatastoreParameters getParams(String operation, Map<String, String> collectionAttributes, Map<String,String> params) {
		StringBuffer sb = new StringBuffer();
		for(String key : collectionAttributes.keySet()) {
			if(key.equals("id")) {
				params.put("id", collectionAttributes.get("id"));
			} else {
				sb.append(key + ":" + collectionAttributes.get(key) + " ");
			}
		}
		String collection = sb.toString();
		QueryHolder holder = new QueryHolder(operation, collection, params);
		
		return DatastoreParameters.product("ElasticSearch").collection(collection).operation(operation).noInstance().noDatabaseName().slowQuery(holder, new ESQueryConverter()).build();
	}
	
	public static String getCollectionFromList(List<String> list) {
		int size = list.size();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++) {
			sb.append(list.get(i));
			if(i < size-1) {
				sb.append(',');
			}
		}
		return sb.toString();
	}
	
	public static <TDocument> String getCollectionFromQuery(Query query, Class<TDocument> tDocumentClass) {
		if(query != null) {
			return tDocumentClass != null ? "QueryType-" + query._kind().name() + "-" + tDocumentClass.getSimpleName() : "QueryType-" + query._kind().name();
		}
		return null;
	}
}
