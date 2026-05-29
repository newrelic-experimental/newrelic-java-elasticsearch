package org.elasticsearch.client;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.common.CheckedFunction;
import org.elasticsearch.common.transport.TransportAddress;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave
public abstract class RestHighLevelClient {

	/*
	 * use similar logic as in the elasticsearch-xxx instrumentation in AbstractClient
	 * the difference is that all requests go through two methods here
	 * 
	 * in both if request is an instanceof ActionRequest then cast it as an ActionRequest and 
	 * use com.nr.instrumentation.elasticsearch.ElasticSearchUtils.getAll() to get the DB info
	 * 
	 * in the sync method report the method as an external DB call
	 * 
	 * in the async method create an instance of com.newrelic.instrumentation.labs.elasticsearch.highlevelrest.NRActionListenerWrapper<Response>
	 * to wrap the listener input and set input to the wrapper
	 * 
	 */
	
	@Trace(leaf = true)
	public BulkResponse bulk(BulkRequest bulkRequest, RequestOptions options) {
		String desc = bulkRequest.getDescription();
		TransportAddress address = bulkRequest.remoteAddress();
		DatastoreParameters params = DatastoreParameters.product("ElasticSearch").collection(desc).operation("bulkRequest").instance(address.getAddress(), address.getPort()).build();
		return Weaver.callOriginal();
	}
	
	protected abstract <Req extends Validatable, Resp> Resp performRequest(Req request,
            CheckedFunction<Req, Request, IOException> requestConverter,
            RequestOptions options,
            CheckedFunction<Response, Resp, IOException> responseConverter,
            Set<Integer> ignores);
		
	protected abstract <Req extends Validatable, Resp> void performRequestAsync(Req request,
            CheckedFunction<Req, Request, IOException> requestConverter,
            RequestOptions options,
            CheckedFunction<Response, Resp, IOException> responseConverter,
            ActionListener<Resp> listener, Set<Integer> ignores);
}
