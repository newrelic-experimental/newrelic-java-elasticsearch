package com.nr.instrumentation.elasticsearch;

import java.util.List;
import java.util.Map;

import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetRequest.Item;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.TransportChannel;

public class Utils {

	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}
	
	public static void addTransportAddress(Map<String, Object> attributes, TransportAddress address) {
		addAttribute(attributes, "Transport-Host", address.getHost());
		addAttribute(attributes, "Transport-Port", address.getPort());
		addAttribute(attributes, "Transport-Address", address.getAddress());
	}
	
	public static void addTransportChannel(Map<String,Object> attributes, TransportChannel channel) {
		addAttribute(attributes, "TransportChannel-Action", channel.action());
		addAttribute(attributes, "TransportChannel-ChannelType", channel.getChannelType());
		addAttribute(attributes, "TransportChannel-ProfileName", channel.getProfileName());
		addAttribute(attributes, "TransportChannel-RequestId", channel.getRequestId());

	}
	
	public static void addActionRequest(Map<String,Object> attributes, ActionRequest<?> request) {
		addAttribute(attributes, "Request-Description", request.getDescription());
		addTransportAddress(attributes, request.remoteAddress());
		if(request instanceof GetRequest) {
			GetRequest getRequest = (GetRequest)request;
			addAttribute(attributes, "GetRequest-Id", getRequest.id());
			addAttribute(attributes, "GetRequest-Index", getRequest.index());
			addAttribute(attributes, "GetRequest-Parent", getRequest.parent());
			addAttribute(attributes, "GetRequest-Routing", getRequest.routing());
			addAttribute(attributes, "GetRequest-Type", getRequest.type());
		} else if(request instanceof UpdateRequest) {
			UpdateRequest updateRequest = (UpdateRequest)request;
			addAttribute(attributes, "UpdateRequest-Id", updateRequest.id());
			addAttribute(attributes, "UpdateRequest-ConcreateIndex", updateRequest.concreteIndex());
			addAttribute(attributes, "UpdateRequest-ShardId", updateRequest.getShardId());
			addAttribute(attributes, "UpdateRequest-Index", updateRequest.index());
			addAttribute(attributes, "UpdateRequest-Routing", updateRequest.routing());
			addAttribute(attributes, "UpdateRequest-Type", updateRequest.type());
		} else if(request instanceof SearchRequest) {
			SearchRequest searchRequest = (SearchRequest)request;
			addAttribute(attributes, "SearchRequest-Routing", searchRequest.routing());
			addAttribute(attributes, "SearchRequest-SearchType", searchRequest.searchType());
		} else if(request instanceof IndexRequest) {
			IndexRequest indexRequest = (IndexRequest)request;
			addAttribute(attributes, "IndexRequest-ContentType", indexRequest.getContentType());
			addAttribute(attributes, "IndexRequest-Pipeline", indexRequest.getPipeline());
			addAttribute(attributes, "IndexRequest-Id", indexRequest.id());
			addAttribute(attributes, "IndexRequest-Index", indexRequest.index());
			addAttribute(attributes, "IndexRequest-OpType", indexRequest.opType());
			addAttribute(attributes, "IndexRequest-ShardId", indexRequest.shardId());
			addAttribute(attributes, "IndexRequest-Routing", indexRequest.routing());
		} else if(request instanceof DeleteRequest) {
			DeleteRequest deleteRequest = (DeleteRequest)request;
			addAttribute(attributes, "DeleteRequest-Id", deleteRequest.id());
			addAttribute(attributes, "DeleteRequest-Index", deleteRequest.index());
			addAttribute(attributes, "DeleteRequest-Routing", deleteRequest.routing());
			addAttribute(attributes, "DeleteRequest-Type", deleteRequest.type());
		} else if(request instanceof MultiGetRequest) {
			MultiGetRequest	multiGet = (MultiGetRequest)request;
			StringBuffer sb = new StringBuffer();
			List<Item> itemList = multiGet.getItems();
			int size = itemList.size();
			for(int i=0;i<size;i++) {
				sb.append(itemList.get(i));
				if(i < size - 1) {
					sb.append(',');
				}
			}
			if(sb.length() > 0) {
				addAttribute(attributes, "Items", sb.toString());
			}
		} else if(request instanceof MultiSearchRequest) {
			MultiSearchRequest multiSearch = (MultiSearchRequest)request;
			List<SearchRequest> requests = multiSearch.requests();
			int count = 1;
			for(SearchRequest searchRequest : requests) {
				addAttribute(attributes, "MultiSearchRequest-"+count+"-SearchType", searchRequest.searchType());
				String[] indices = searchRequest.indices();
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<indices.length;i++) {
					sb.append(indices[i]);
					if(i < indices.length - 1) {
						sb.append(',');
					}
				}
				if(sb.length() > 0) {
					addAttribute(attributes, "MultiSearchRequest-"+count+"-Indices", sb.toString());
				}
			}
		}
	}

}
