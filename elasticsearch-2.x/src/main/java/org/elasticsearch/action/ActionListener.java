package org.elasticsearch.action;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.elasticsearch.NRHolder;

@Weave(type=MatchType.Interface)
public class ActionListener<Response> {

	
	@Trace(async=true)
	public void onResponse(Response response) {
		Weaver.callOriginal();
		Token token = NRHolder.getToken(hashCode());
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		Segment segment = NRHolder.getSegment(hashCode());
		DatastoreParameters params = NRHolder.getParams(hashCode());
		if(segment != null) {
			if(params != null) {
				segment.reportAsExternal(params);
			}
			segment.end();
		} else if(params != null) {
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		}
	}
	
	@Trace(async=true)
	public void onFailure(Throwable e) {
		NewRelic.noticeError(e);
		Weaver.callOriginal();
		Token token = NRHolder.getToken(hashCode());
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		Segment segment = NRHolder.getSegment(hashCode());
		DatastoreParameters params = NRHolder.getParams(hashCode());
		if(segment != null) {
			if(params != null) {
				segment.reportAsExternal(params);
			}
			segment.end();
		} else if(params != null) {
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		}
	}
}
