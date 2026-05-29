package com.newrelic.instrumentation.labs.esrestclient;

import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "org.elasticsearch.client.RestClient")
public abstract class RestClient_Instrumentation {

	@Trace(leaf = true)
	public Response performRequest(Request request) {
		String endpoint = request.getEndpoint();
		String payload = null;

		Utils.logRequestAttributes(request);
		if (Utils.isPayloadApplicable(request.getMethod())) {
			payload = Utils.getPayloadSafely(request);
		}

		String sql = Utils.constructSql(endpoint, payload);
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

	
	public void performRequestAsync(Request request, ResponseListener_instrumentation responseListener) {
		String endpoint = request.getEndpoint();
		String payload = null;

		Utils.logRequestAttributes(request);
		if (Utils.isPayloadApplicable(request.getMethod())) {
			payload = Utils.getPayloadSafely(request);
		}

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
		Weaver.callOriginal();
	}
}
