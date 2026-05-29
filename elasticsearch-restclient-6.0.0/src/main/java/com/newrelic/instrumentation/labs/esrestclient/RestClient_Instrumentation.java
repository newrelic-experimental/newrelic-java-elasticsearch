package com.newrelic.instrumentation.labs.esrestclient;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
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
	public Response performRequest(String method, String endpoint, Map<String, String> params,
            HttpEntity entity, Header... headers) {
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.addAttribute(attributes, "EndPoint", endpoint);
		Utils.addAttribute(attributes, "Method", method);
		Utils.addMap(attributes, params);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		String payload = null;

		if (Utils.isPayloadApplicable(method)) {
			payload = Utils.getPayloadSafely(entity);
		}

		String sql = Utils.constructSql(endpoint, payload);
		DatastoreParameters dsParams = DatastoreParameters.product("ElasticSeachRest")
				.collection(Utils.extractIndex(endpoint))
				.operation(method)
				.noInstance()
				.noDatabaseName()
				.slowQuery(sql, new ESQueryConverter())
				.build();

		NewRelic.getAgent().getTracedMethod().reportAsExternal(dsParams);
		return Weaver.callOriginal();
	}

	
	public void performRequestAsync(String method, String endpoint, Map<String, String> params,
            HttpEntity entity, HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory,
            ResponseListener_instrumentation responseListener, Header... headers) {
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.addAttribute(attributes, "EndPoint", endpoint);
		Utils.addAttribute(attributes, "Method", method);
		Utils.addMap(attributes, params);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		String payload = null;

		if (Utils.isPayloadApplicable(method)) {
			payload = Utils.getPayloadSafely(entity);
		}


		String sql = Utils.constructSql(endpoint, payload);
		DatastoreParameters dsParams = DatastoreParameters.product("ElasticSeachRest")
				.collection(Utils.extractIndex(endpoint))
				.operation(method)
				.noInstance()
				.noDatabaseName()
				.slowQuery(sql, new ESQueryConverter())
				.build();

		Segment segment = NewRelic.getAgent().getTransaction().startSegment("ElasticsearchRequest");
		responseListener.segment = segment;
		responseListener.params = dsParams;
		Weaver.callOriginal();
	}

}
