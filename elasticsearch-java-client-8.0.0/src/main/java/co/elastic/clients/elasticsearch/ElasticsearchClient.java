package co.elastic.clients.elasticsearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.elasticsearch.javaclient.Utils;

import co.elastic.clients.ApiClient;
import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.InlineScript;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.CountRequest;
import co.elastic.clients.elasticsearch.core.CountResponse;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.CreateResponse;
import co.elastic.clients.elasticsearch.core.DeleteByQueryRequest;
import co.elastic.clients.elasticsearch.core.DeleteByQueryResponse;
import co.elastic.clients.elasticsearch.core.DeleteByQueryRethrottleRequest;
import co.elastic.clients.elasticsearch.core.DeleteByQueryRethrottleResponse;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.DeleteScriptRequest;
import co.elastic.clients.elasticsearch.core.DeleteScriptResponse;
import co.elastic.clients.elasticsearch.core.ExistsRequest;
import co.elastic.clients.elasticsearch.core.ExistsSourceRequest;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.GetScriptRequest;
import co.elastic.clients.elasticsearch.core.GetScriptResponse;
import co.elastic.clients.elasticsearch.core.GetSourceRequest;
import co.elastic.clients.elasticsearch.core.GetSourceResponse;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.InfoResponse;
import co.elastic.clients.elasticsearch.core.MgetRequest;
import co.elastic.clients.elasticsearch.core.MgetResponse;
import co.elastic.clients.elasticsearch.core.MsearchRequest;
import co.elastic.clients.elasticsearch.core.MsearchResponse;
import co.elastic.clients.elasticsearch.core.PutScriptRequest;
import co.elastic.clients.elasticsearch.core.PutScriptResponse;
import co.elastic.clients.elasticsearch.core.ReindexRequest;
import co.elastic.clients.elasticsearch.core.ReindexResponse;
import co.elastic.clients.elasticsearch.core.ScriptsPainlessExecuteRequest;
import co.elastic.clients.elasticsearch.core.ScriptsPainlessExecuteResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.SearchShardsRequest;
import co.elastic.clients.elasticsearch.core.SearchShardsResponse;
import co.elastic.clients.elasticsearch.core.SearchTemplateRequest;
import co.elastic.clients.elasticsearch.core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.UpdateByQueryRequest;
import co.elastic.clients.elasticsearch.core.UpdateByQueryResponse;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.TransportOptions;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;

@Weave
public abstract class ElasticsearchClient  extends ApiClient<ElasticsearchTransport, ElasticsearchClient> {
	
	public ElasticsearchClient(ElasticsearchTransport transport) {
		super(transport, null);
	}

	public ElasticsearchClient(ElasticsearchTransport transport, TransportOptions transportOptions) {
		super(transport, transportOptions);
	}

	@Trace(leaf = true)
	public BulkResponse bulk(BulkRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		Endpoint<BulkRequest, BulkResponse, ErrorResponse> endPoint = BulkRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public BulkResponse bulk() {
		BulkRequest request = new BulkRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		Endpoint<BulkRequest, BulkResponse, ErrorResponse> endPoint = BulkRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public CountResponse count(CountRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index",index);
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("query",Utils.getObjectString(query));
		}
		Endpoint<CountRequest, CountResponse, ErrorResponse> endPoint = CountRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), query);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> CreateResponse create(CreateRequest<TDocument> request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		TDocument doc = request.document();
		if(doc != null) {
			collectionAttr.put("documentType", doc.getClass().getSimpleName());
		}
		
		Endpoint<CreateRequest<?>, CreateResponse, ErrorResponse> endPoint = CreateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteResponse delete(DeleteRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		 Endpoint<DeleteRequest, DeleteResponse, ErrorResponse> endPoint = DeleteRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteByQueryResponse deleteByQuery(DeleteByQueryRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("Query", Utils.getObjectString(query));
		}

		Endpoint<DeleteByQueryRequest, DeleteByQueryResponse, ErrorResponse> endPoint = DeleteByQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, DeleteByQueryRequest._ENDPOINT.queryParameters(request), query);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteByQueryRethrottleResponse deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String taskId = request.taskId();
		if(taskId != null) {
			collectionAttr.put("taskid", taskId);
		}
		Endpoint<DeleteByQueryRethrottleRequest, DeleteByQueryRethrottleResponse, ErrorResponse> endPoint = DeleteByQueryRethrottleRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteScriptResponse deleteScript(DeleteScriptRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String scriptId = request.id();
		collectionAttr.put("scriptid", scriptId);
		Endpoint<DeleteScriptRequest, DeleteScriptResponse, ErrorResponse> endPoint = DeleteScriptRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public BooleanResponse exists(ExistsRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		Endpoint<ExistsRequest, BooleanResponse, ErrorResponse> endPoint = ExistsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public BooleanResponse existsSource(ExistsSourceRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		Endpoint<ExistsSourceRequest, BooleanResponse, ErrorResponse> endPoint = ExistsSourceRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> GetResponse<TDocument> get(GetRequest request, Class<TDocument> tDocumentClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type",tDocumentClass.getSimpleName());
		}
		SimpleEndpoint<GetRequest, ?> endPoint = GetRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public GetScriptResponse getScript(GetScriptRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String id = request.id();
		if(id != null) {
			collectionAttr.put("scriptid", id);
		}
		Endpoint<GetScriptRequest, GetScriptResponse, ErrorResponse> endPoint = GetScriptRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> GetSourceResponse<TDocument> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		SimpleEndpoint<GetSourceRequest, ?> endPoint = GetSourceRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> IndexResponse index(IndexRequest<TDocument> request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		TDocument doc = request.document();
		if(doc != null) {
			collectionAttr.put("document-type", doc.getClass().getSimpleName());
		}
		Endpoint<IndexRequest<?>, IndexResponse, ErrorResponse> endPoint = IndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> MgetResponse<TDocument> mget(MgetRequest request, Class<TDocument> tDocumentClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		SimpleEndpoint<MgetRequest, ?> endPoint = MgetRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> MsearchResponse<TDocument> msearch(MsearchRequest request, Class<TDocument> tDocumentClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index =  Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		SimpleEndpoint<MsearchRequest, ?> endPoint = MsearchRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public PutScriptResponse putScript(PutScriptRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		String context = request.context();
		if(context != null) {
			collectionAttr.put("context", context);
		}
		Endpoint<PutScriptRequest, PutScriptResponse, ErrorResponse> endPoint = PutScriptRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public ReindexResponse reindex(ReindexRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("collection", "");
		Endpoint<ReindexRequest, ReindexResponse, ErrorResponse> endPoint = ReindexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String context = request.context();
		if(context != null) {
			collectionAttr.put("context", context);
		}
		InlineScript script = request.script();
		if (script != null) {
			String source = script.source();
			if(source != null) {
				collectionAttr.put("script-source", source);
			}
			
		}
		if(tResultClass != null) {
			collectionAttr.put("result-type", tResultClass.getSimpleName());
		}
		 SimpleEndpoint<ScriptsPainlessExecuteRequest, ?> endPoint = ScriptsPainlessExecuteRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> SearchResponse<TDocument> search(SearchRequest request, Class<TDocument> tDocumentClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index",index);
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("query", Utils.getObjectString(query));
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		SimpleEndpoint<SearchRequest, ?> endPoint = SearchRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request,collectionAttr, endPoint.queryParameters(request), query);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public SearchShardsResponse searchShards(SearchShardsRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		} else {
			collectionAttr.put(" ", "");
		}
		Endpoint<SearchShardsRequest, SearchShardsResponse, ErrorResponse> endPoint = SearchShardsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> SearchTemplateResponse<TDocument> searchTemplate(SearchTemplateRequest request, Class<TDocument> tDocumentClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}		
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		SimpleEndpoint<SearchTemplateRequest, ?> endPoint = SearchTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument, TPartialDocument> UpdateResponse<TDocument> update(UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		TPartialDocument partialDoc = request.doc();
		if(partialDoc != null) {
			collectionAttr.put("partial-doc-type", partialDoc.getClass().getSimpleName());
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		SimpleEndpoint<UpdateRequest<?, ?>, ?> endPoint = UpdateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request) , null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public UpdateByQueryResponse updateByQuery(UpdateByQueryRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("query", Utils.getObjectString(query));
		}
		Endpoint<UpdateByQueryRequest, UpdateByQueryResponse, ErrorResponse> endPoint = UpdateByQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), query);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public InfoResponse info() {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		DatastoreParameters params = Utils.getParams("InfoRequest", collectionAttr, Collections.emptyMap(), null);
		traced.reportAsExternal(params);
		return Weaver.callOriginal();
	}
}
