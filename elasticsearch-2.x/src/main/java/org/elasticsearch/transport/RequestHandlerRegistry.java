package org.elasticsearch.transport;

import java.util.HashMap;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.elasticsearch.MessageHeaders;
import com.nr.instrumentation.elasticsearch.Utils;

@Weave
public abstract class RequestHandlerRegistry<Request extends TransportRequest> {

	@Trace(dispatcher=true)
	public void processMessageReceived(Request request, TransportChannel channel) {
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.addAttribute(attributes, "RequestDescription", request.getDescription());
		Utils.addTransportAddress(attributes, request.remoteAddress());
		Utils.addTransportChannel(attributes, channel);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		MessageHeaders headers = new MessageHeaders(request);
		NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
		Weaver.callOriginal();
	}
}
