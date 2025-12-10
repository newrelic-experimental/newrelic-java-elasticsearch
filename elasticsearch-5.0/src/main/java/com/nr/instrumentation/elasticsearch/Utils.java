package com.nr.instrumentation.elasticsearch;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import com.newrelic.api.agent.NewRelic;

public class Utils {

	private static final Logger ELASTICSEARCH_QUERY_LOGGER = Logger.getLogger("com.newrelic.instrumentation.elasticsearch");

	// Configuration keys
	private static final String CONFIG_LOGS_ENABLED = "elasticsearch.query.logs_in_context.enabled";
	private static final String CONFIG_LOG_THRESHOLD = "elasticsearch.query.logs_in_context.threshold";

	// Default values
	private static final int DEFAULT_LOG_THRESHOLD = 4093;
	private static Boolean logsInContextEnabled = null;
	private static Integer logThreshold = null;

	/**
	 * Check if logs in context is enabled for Elasticsearch queries.
	 * Configuration key: elasticsearch.query.logs_in_context.enabled
	 * Default: true
	 */
	private static boolean isLogsInContextEnabled() {
		if (logsInContextEnabled == null) {
			logsInContextEnabled = NewRelic.getAgent().getConfig().getValue(CONFIG_LOGS_ENABLED, Boolean.TRUE);
		}
		return logsInContextEnabled;
	}

	/**
	 * Get the threshold for logging queries (in characters).
	 * Configuration key: elasticsearch.query.logs_in_context.threshold
	 * Default: 4093
	 */
	private static int getLogThreshold() {
		if (logThreshold == null) {
			logThreshold = NewRelic.getAgent().getConfig().getValue(CONFIG_LOG_THRESHOLD, DEFAULT_LOG_THRESHOLD);
		}
		return logThreshold;
	}

	/**
	 * Log complete query to New Relic Logs when it exceeds the truncation limit.
	 * This provides full query visibility via logs in context.
	 * The New Relic agent will automatically forward these logs with trace context.
	 *
	 * Configuration:
	 *   elasticsearch.query.logs_in_context.enabled (default: true)
	 *   elasticsearch.query.logs_in_context.threshold (default: 4093)
	 */
	public static void logCompleteQueryToLogs(String fullQuery, String collection, String operation) {
		// Check if feature is enabled
		if (!isLogsInContextEnabled()) {
			return;
		}

		// Check if query exceeds threshold
		if (fullQuery == null || fullQuery.length() <= getLogThreshold()) {
			return;
		}

		try {
			// Log the complete query using java.util.logging
			// New Relic agent automatically forwards java.util.logging logs with trace context
			String logMessage = String.format(
				"Elasticsearch Long Query | collection=%s | operation=%s | length=%d | query=%s",
				collection != null ? collection : "unknown",
				operation != null ? operation : "unknown",
				fullQuery.length(),
				fullQuery
			);

			ELASTICSEARCH_QUERY_LOGGER.log(Level.INFO, logMessage);

		} catch (Exception e) {
			// Don't fail the transaction if logging fails
			NewRelic.getAgent().getLogger().log(Level.WARNING, "Failed to log complete Elasticsearch query: " + e.getMessage());
		}
	}

	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}
	
	public static void addTransportAddress(Map<String, Object> attributes, TransportAddress address) {
		if (address != null) {
		addAttribute(attributes, "Transport-Host", address.getHost());
		addAttribute(attributes, "Transport-Port", address.getPort());
					addAttribute(attributes, "Transport-Address", address.getAddress());
		}
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
