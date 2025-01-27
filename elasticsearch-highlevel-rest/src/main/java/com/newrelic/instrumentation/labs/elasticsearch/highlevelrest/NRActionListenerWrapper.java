package com.newrelic.instrumentation.labs.elasticsearch.highlevelrest;

import org.elasticsearch.action.ActionListener;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.instrumentation.labs.elasticsearch.highlevelrest.ElasticSearchUtils.Holder;

public class NRActionListenerWrapper<Response> implements ActionListener<Response> {
	
	private ActionListener<Response> delegate = null;
	private Segment segment = null;
	private Holder holder = null;
	
	public NRActionListenerWrapper(ActionListener<Response> d, Holder h) {
		delegate = d;
		holder = h;
		initialize();
	}
	
	private void initialize() {
		DatastoreParameters params = DatastoreParameters.product("ElasticSearch").collection(holder.collection).operation(holder.collection).build();
		segment = NewRelic.getAgent().getTransaction().startSegment("HighLevelRestClient/"+holder.collection);
		segment.reportAsExternal(params);
	}

	@Override
	public void onResponse(Response response) {
		if(segment != null) {
			segment.end();
			segment = null;
		}
		if(delegate != null) {
			delegate.onResponse(response);
		}
	}

	@Override
	public void onFailure(Exception e) {
		NewRelic.noticeError(e);
		if(segment != null) {
			segment.end();
			segment = null;
		}
		if(delegate != null) {
			delegate.onFailure(e);
		}
		
	}

}
