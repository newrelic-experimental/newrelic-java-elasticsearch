package org.elasticsearch.transport;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.elasticsearch.MessageHeaders;

@Weave
public abstract class RequestHandlerRegistry<Request extends TransportRequest> {

	@Trace(dispatcher=true)
	public void processMessageReceived(Request request, TransportChannel channel) {
		MessageHeaders headers = new MessageHeaders(request);
		NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
		Weaver.callOriginal();
	}
}
