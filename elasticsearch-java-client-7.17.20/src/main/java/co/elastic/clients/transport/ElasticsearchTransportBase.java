package co.elastic.clients.transport;

import java.util.concurrent.CompletableFuture;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.BaseClass)
public abstract class ElasticsearchTransportBase {

//	public <RequestT, ResponseT, ErrorT> ResponseT performRequest(RequestT request, Endpoint<RequestT, ResponseT, ErrorT> endpoint, TransportOptions options) {
//		String url = endpoint.requestUrl(request);
//		String method = endpoint.method(request);
//		NewRelic.getAgent().getLogger().log(Level.FINE, "In RestClientTransport.performRequest, url = {0}. method = {1}", url, method);
//		Map<String, String> headers = endpoint.headers(request);
//		Map<String, String> params = endpoint.queryParameters(request);
//		NewRelic.getAgent().getLogger().log(Level.FINE, "In RestClientTransport.performRequestAsync, headers = {0}. params = {1}", headers.toString(), params.toString());
//		return Weaver.callOriginal();
//	}

	@Trace(leaf = true, excludeFromTransactionTrace = true)
	public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(RequestT request, Endpoint<RequestT, ResponseT, ErrorT> endpoint, TransportOptions options) {
//		String url = endpoint.requestUrl(request);
//		String method = endpoint.method(request);
//		Map<String, String> headers = endpoint.headers(request);
//		Map<String, String> params = endpoint.queryParameters(request);
//		
//		NewRelic.getAgent().getLogger().log(Level.FINE, "In RestClientTransport.performRequestAsync, url = {0}. method = {1}", url, method);
//		NewRelic.getAgent().getLogger().log(Level.FINE, "In RestClientTransport.performRequestAsync, headers = {0}. params = {1}", headers.toString(), params.toString());
		return Weaver.callOriginal();
	}

}
