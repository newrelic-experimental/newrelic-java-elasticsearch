package com.newrelic.instrumentation.labs.esrestclient;

import java.util.Iterator;
import java.util.logging.Level;

import org.elasticsearch.client.Cancellable;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.Logger;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "org.elasticsearch.client.RestClient")
public abstract class RestClient_Instrumentation {

	@Trace(leaf = true)
	public Response performRequest(Request request) {
		Logger logger = NewRelic.getAgent().getLogger();
		String endpoint = request.getEndpoint();
		logger.log(Level.FINE, "In RestClient.performRequest, endpoint = {0}", endpoint);
		String payload = null;

		Utils.logRequestAttributes(request);
		if (Utils.isPayloadApplicable(request.getMethod())) {
			payload = Utils.getPayloadSafely(request);
		}
		logger.log(Level.FINE, "In RestClient.performRequest, payload = {0}", payload);

		logger.log(Level.FINE, "In RestClient.performRequest, method = {0}", request.getMethod());

		String sql = Utils.constructSql(endpoint, payload);
		logger.log(Level.FINE, "In RestClient.performRequest, sql = {0}", sql);
		DatastoreParameters params = DatastoreParameters.product("ElasticSeachRest")
				.collection(Utils.extractIndex(endpoint))
				.operation(request.getMethod())
				.noInstance()
				.noDatabaseName()
				.slowQuery(sql, new ESQueryConverter())
				.build();

		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}

	
	public Cancellable performRequestAsync(Request request, ResponseListener_instrumentation responseListener) {
		Logger logger = NewRelic.getAgent().getLogger();
		String endpoint = request.getEndpoint();
		logger.log(Level.FINE, "In RestClient.performRequest, endpoint = {0}", endpoint);
		String payload = null;

		Utils.logRequestAttributes(request);
		if (Utils.isPayloadApplicable(request.getMethod())) {
			payload = Utils.getPayloadSafely(request);
		}
		logger.log(Level.FINE, "In RestClient.performRequest, payload = {0}", payload);

		String sql = Utils.constructSql(endpoint, payload);
		DatastoreParameters params = DatastoreParameters.product("ElasticSeachRest")
				.collection(Utils.extractIndex(endpoint))
				.operation(request.getMethod())
				.noInstance()
				.noDatabaseName()
				.slowQuery(sql, new ESQueryConverter())
				.build();

		Segment segment = NewRelic.getAgent().getTransaction().startSegment("ElasticsearchRequest");
		responseListener.segment = segment;
		responseListener.params = params;
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true, excludeFromTransactionTrace = true)
	private void performRequestAsync(final NodeTuple<Iterator<Node>> nodeTuple,
            final InternalRequest request,
            final FailureTrackingResponseListener listener) {
		
	}
	
	@Weave(originalName = "org.elasticsearch.client.RestClient$InternalRequest")
	private static class InternalRequest {
		
	}
	
	@Weave(originalName = "org.elasticsearch.client.RestClient$NodeTuple")
	static class NodeTuple<T> {
		
	}
	
	@Weave(originalName = "org.elasticsearch.client.RestClient$FailureTrackingResponseListener")
	static class FailureTrackingResponseListener {
		
	}

}
