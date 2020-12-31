package com.nr.instrumentation.elasticsearch;

import java.util.List;

import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetRequest.Item;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;

@SuppressWarnings("rawtypes")
public class ElasticSearchUtils {

	public static Holder getAll(ActionRequest request) {
		String operation = getOperation(request);
		String collection = getCollection(operation, request);
		String query = getQuery(operation,request);
		
		return new Holder(query, collection, operation);
	}
	
	public static String getOperation(ActionRequest request) {
		String type = "Unknown";
		String classname = request.getClass().getSimpleName();
		if(classname.endsWith("Request")) {
			int index = classname.indexOf("Request");
			if(index > -1) {
				type = classname.substring(0, index);
			}
		}
		return type;
	}
	
	
	public static String getQuery(String operation,ActionRequest request) {
		String result = "";
		
		if(operation.equalsIgnoreCase("get")) {
			GetRequest getRequest = (GetRequest)request;
			String index = getRequest.index();
			String type = getRequest.type();
			String id = getRequest.id();
			
			return  "get "+index+"/"+type+"/"+id;
		}
		
		if(operation.equalsIgnoreCase("update")) {
			UpdateRequest updateRequest = (UpdateRequest)request;
			String index = updateRequest.index();
			String type = updateRequest.type();
			String id = updateRequest.id();
			return  "update "+index+"/"+type+"/"+id;
		}
		
		if(operation.equalsIgnoreCase("search")) {
			SearchRequest searchRequest = (SearchRequest)request;
			String tmp = getSearchCollection(searchRequest);
			return "search "+tmp;
		}
		
		if(operation.equalsIgnoreCase("index")) {
			IndexRequest indexRequest = (IndexRequest)request;
			String index = indexRequest.index();
			String type = indexRequest.type();
			String id = indexRequest.id();
			
			return "index " +index+"/"+type+"/"+id;
		}
		
		if(operation.equalsIgnoreCase("delete")) {
			DeleteRequest deleteRequest = (DeleteRequest)request;
			String index = deleteRequest.index();
			String type = deleteRequest.type();
			String id = deleteRequest.id();
			
			return "delete " +index+"/"+type+"/"+id;
		}
		
		if(operation.equalsIgnoreCase("multiget")) {
			MultiGetRequest multiGetRequest = (MultiGetRequest)request;
			List<Item> items = multiGetRequest.getItems();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<items.size();i++) {
				Item item = items.get(i);
				String index = item.index();
				String type = item.type();
				String id = item.id();
				sb.append(index+"/"+type+"/"+id);
				if(i < items.size()-1) {
					sb.append(',');
				}
			}
			return "multiget " + sb.toString();
		}
		
		if(operation.equalsIgnoreCase("multisearch")) {
			MultiSearchRequest multiSearchRequest = (MultiSearchRequest)request;
			List<SearchRequest> searches = multiSearchRequest.requests(); 
			int size = searches.size();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<size;i++) {
				SearchRequest searchRequest = searches.get(i);
				String s = getSearchCollection(searchRequest);
				sb.append(s);
				if(i < size -1) {
					sb.append(',');
				}
			}
			return "multisearch "+sb.toString();
		}
		
		return result;
	}
	
	public static String getCollection(ActionRequest request) {
		String result = "Unknown";
		if(GetRequest.class.isInstance(request)) {
			GetRequest getRequest = (GetRequest)request;
			result = getRequest.index() + "-" + getRequest.type();
		} else if(UpdateRequest.class.isInstance(request)) {
			UpdateRequest updateRequest = (UpdateRequest)request;
			result = updateRequest.index() + "-" + updateRequest.type();
		} else if(SearchRequest.class.isInstance(request)) {
			SearchRequest searchRequest = (SearchRequest)request;
			result = getSearchCollection(searchRequest);
		} else if(IndexRequest.class.isInstance(request)) {
			IndexRequest indexRequest = (IndexRequest)request;
			result = indexRequest.index() + "-" + indexRequest.type();
//		} else if(BulkRequest.class.isInstance(request)) {
//			BulkRequest bulkRequest = (BulkRequest)request;
//			result = bulkRequest.pipeline() + "-" + bulkRequest.routing();
		} else if(DeleteRequest.class.isInstance(request)) {
			DeleteRequest deleteRequest = (DeleteRequest)request;
			result = deleteRequest.index() + "-" + deleteRequest.type();
		} else if(MultiGetRequest.class.isInstance(request)) {
			MultiGetRequest multiGetRequest = (MultiGetRequest)request;
			List<Item> items = multiGetRequest.getItems();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<items.size();i++) {
				Item item = items.get(i);
				sb.append(item.index()+"-"+item.type());
				if(i < items.size()-1) {
					sb.append(',');
				}
			}
			result = sb.toString();
			if(result.endsWith(",")) {
				result = result.substring(0, result.length()-1);
			}
		} else if(MultiSearchRequest.class.isInstance(request)) {
			MultiSearchRequest multiSearchRequest = (MultiSearchRequest)request;
			List<SearchRequest> searches = multiSearchRequest.requests(); 
			int size = searches.size();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<size;i++) {
				SearchRequest searchRequest = searches.get(i);
				String s = getSearchCollection(searchRequest);
				sb.append(s);
				if(i < size -1) {
					sb.append(',');
				}
			}
			result = sb.toString();
		}
		return result;
	}
	
	public static String getCollection(String operation, ActionRequest request) {
		String result = "Unknown";
		if(operation.equalsIgnoreCase("get")) {
			GetRequest getRequest = (GetRequest)request;
			result = getRequest.index() + "-" + getRequest.type();
		} else if(operation.equalsIgnoreCase("update")) {
			UpdateRequest updateRequest = (UpdateRequest)request;
			result = updateRequest.index() + "-" + updateRequest.type();
		} else if(operation.equalsIgnoreCase("search")) {
			SearchRequest searchRequest = (SearchRequest)request;
			result = getSearchCollection(searchRequest);
		} else if(operation.equalsIgnoreCase("index")) {
			IndexRequest indexRequest = (IndexRequest)request;
			result = indexRequest.index() + "-" + indexRequest.type();
//		} else if(BulkRequest.class.isInstance(request)) {
//			BulkRequest bulkRequest = (BulkRequest)request;
//			result = bulkRequest.pipeline() + "-" + bulkRequest.routing();
		} else if(operation.equalsIgnoreCase("delete")) {
			DeleteRequest deleteRequest = (DeleteRequest)request;
			result = deleteRequest.index() + "-" + deleteRequest.type();
		} else if(operation.equalsIgnoreCase("multiget")) {
			MultiGetRequest multiGetRequest = (MultiGetRequest)request;
			List<Item> items = multiGetRequest.getItems();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<items.size();i++) {
				Item item = items.get(i);
				sb.append(item.index()+"-"+item.index());
				if(i < items.size()-1) {
					sb.append(',');
				}
			}
			result = sb.toString();
			if(result.endsWith(",")) {
				result = result.substring(0, result.length()-1);
			}
		} else if(operation.equalsIgnoreCase("multisearch")) {
			MultiSearchRequest multiSearchRequest = (MultiSearchRequest)request;
			List<SearchRequest> searches = multiSearchRequest.requests(); 
			int size = searches.size();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<size;i++) {
				SearchRequest searchRequest = searches.get(i);
				String s = getSearchCollection(searchRequest);
				sb.append(s);
				if(i < size -1) {
					sb.append(',');
				}
			}
			result = sb.toString();
		}
		return result;
	}

	private static String getSearchCollection(SearchRequest request) {
		String[] indices = request.indices();
		String[] types = request.types();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<indices.length;i++) {
			sb.append(indices[i]);
			if(i < indices.length-1) {
				sb.append(',');
			}
		}
		if(sb.length() != 0) {
			sb.append('-');
		}
		for(int i=0;i<types.length;i++) {
			sb.append(types[i]);
			if(i < types.length-1) {
				sb.append(',');
			}
		}
		return sb.toString();
	}
	
	public static class Holder {
		public String rawQuery;
		public String collection;
		public String operation;
		
		public Holder(String rawQuery, String collection, String operation) {
			super();
			this.rawQuery = rawQuery;
			this.collection = collection;
			this.operation = operation;
		}
		
		
	}
}
