package org.elasticsearch.action;

import java.util.concurrent.TimeUnit;

import org.elasticsearch.core.TimeValue;

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
public abstract class ActionFuture<T> {

	@Trace(async=true)
    public T actionGet() {
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
		return Weaver.callOriginal();
    }

	@Trace(async=true)
    public T actionGet(String timeout) {
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
		return Weaver.callOriginal();
    }

	@Trace(async=true)
    public T actionGet(long timeoutMillis) {
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
		return Weaver.callOriginal();
    }

	@Trace(async=true)
    public T actionGet(long timeout, TimeUnit unit) {
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
		return Weaver.callOriginal();
    }

	@Trace(async=true)
    public T actionGet(TimeValue timeout) {
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
		return Weaver.callOriginal();
    }

}
