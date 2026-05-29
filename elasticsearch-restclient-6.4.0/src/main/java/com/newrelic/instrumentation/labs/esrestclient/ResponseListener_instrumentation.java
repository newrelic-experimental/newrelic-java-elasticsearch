package com.newrelic.instrumentation.labs.esrestclient;

import org.elasticsearch.client.Response;

import com.newrelic.api.agent.ExternalParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "org.elasticsearch.client.ResponseListener", type = MatchType.Interface)
public abstract class ResponseListener_instrumentation {
	
	@NewField
	public Segment segment = null;
	
	@NewField
	public ExternalParameters params = null;

	public void onSuccess(Response response) {
		if(segment != null) {
			if(params != null) {
				segment.reportAsExternal(params);
			}
			segment.end();
			segment = null;
		}
		Weaver.callOriginal();
	}
	
	public void onFailure(Exception exception) {
		NewRelic.noticeError(exception);
		if(segment != null) {
			segment.ignore();
			segment = null;
		}
		Weaver.callOriginal();
	}
}
