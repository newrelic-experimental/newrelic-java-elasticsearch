package co.elastic.clients.transport;

import java.util.concurrent.CompletableFuture;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.BaseClass)
public abstract class ElasticsearchTransportBase {

	/*
	 * Included to prevent downstream tracing which can lead to async token and segment problems
	 */
	@Trace(leaf = true, excludeFromTransactionTrace = true)
	public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(RequestT request, Endpoint<RequestT, ResponseT, ErrorT> endpoint, TransportOptions options) {
		return Weaver.callOriginal();
	}

}
