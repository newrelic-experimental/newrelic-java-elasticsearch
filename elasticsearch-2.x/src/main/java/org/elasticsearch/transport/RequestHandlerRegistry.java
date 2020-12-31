package org.elasticsearch.transport;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.elasticsearch.ElasticUtils;

@Weave
public abstract class RequestHandlerRegistry<Request extends TransportRequest> {

	@Trace(dispatcher=true)
	public void processMessageReceived(Request request, TransportChannel channel) {
		String dtString = request.getHeader(ElasticUtils.DISTRIBUTEDTRACINGNAME);
		NewRelic.getAgent().getTransaction().acceptDistributedTracePayload(dtString);
		Weaver.callOriginal();
	}
}
