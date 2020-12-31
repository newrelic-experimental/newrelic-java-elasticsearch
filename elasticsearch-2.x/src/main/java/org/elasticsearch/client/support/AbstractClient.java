package org.elasticsearch.client.support;

import org.elasticsearch.action.Action;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.ActionRequestBuilder;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.common.transport.TransportAddress;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.elasticsearch.ESQueryConverter;
import com.nr.instrumentation.elasticsearch.ElasticSearchUtils;
import com.nr.instrumentation.elasticsearch.ElasticSearchUtils.Holder;
import com.nr.instrumentation.elasticsearch.ElasticUtils;
import com.nr.instrumentation.elasticsearch.NRHolder;

@Weave(type=MatchType.BaseClass)
public abstract class AbstractClient {

	@Trace
	protected <Request extends ActionRequest<Request>, Response extends ActionResponse, RequestBuilder extends ActionRequestBuilder<Request, Response, RequestBuilder>> void doExecute(final Action<Request, Response, RequestBuilder> action, final Request request, ActionListener<Response> listener)  {
		String host = null;
		Integer port = null;
		if(request != null) {
			TransportAddress remote = request.remoteAddress();
			if(remote != null) {
					host = remote.getHost();
					port = remote.getPort();
			}
		}
		request.putHeader(ElasticUtils.DISTRIBUTEDTRACINGNAME, NewRelic.getAgent().getTransaction().createDistributedTracePayload().text());
		Holder holder = ElasticSearchUtils.getAll(request);
		DatastoreParameters params = null;
		
		if(host != null) {
			params = DatastoreParameters.product("ElasticSearch").collection(holder.collection).operation(holder.operation).instance(host, port).noDatabaseName().slowQuery(holder.rawQuery, new ESQueryConverter()).build();
		} else {
			params = DatastoreParameters.product("ElasticSearch").collection(holder.collection).operation(holder.operation).noInstance().noDatabaseName().slowQuery(holder.rawQuery, new ESQueryConverter()).build();

		}
		int hash = listener.hashCode();
		NRHolder.putParams(hash,params);
		Segment segment = NewRelic.getAgent().getTransaction().startSegment("ElasticSearch", holder.operation);
		NRHolder.putSegment(hash, segment);
		NRHolder.putToken(hash,NewRelic.getAgent().getTransaction().getToken());
		Weaver.callOriginal();
	}
}
