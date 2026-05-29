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

import co.elastic.clients.base.ApiClient;
import co.elastic.clients.base.BooleanResponse;
import co.elastic.clients.base.ElasticsearchError;
import co.elastic.clients.base.Endpoint;
import co.elastic.clients.base.Transport;
import co.elastic.clients.elasticsearch._core.BulkRequest;
import co.elastic.clients.elasticsearch._core.BulkResponse;
import co.elastic.clients.elasticsearch._core.CountRequest;
import co.elastic.clients.elasticsearch._core.CountResponse;
import co.elastic.clients.elasticsearch._core.CreateRequest;
import co.elastic.clients.elasticsearch._core.CreateResponse;
import co.elastic.clients.elasticsearch._core.DeleteByQueryRequest;
import co.elastic.clients.elasticsearch._core.DeleteByQueryResponse;
import co.elastic.clients.elasticsearch._core.DeleteByQueryRethrottleRequest;
import co.elastic.clients.elasticsearch._core.DeleteByQueryRethrottleResponse;
import co.elastic.clients.elasticsearch._core.DeleteRequest;
import co.elastic.clients.elasticsearch._core.DeleteResponse;
import co.elastic.clients.elasticsearch._core.DeleteScriptRequest;
import co.elastic.clients.elasticsearch._core.DeleteScriptResponse;
import co.elastic.clients.elasticsearch._core.ExistsRequest;
import co.elastic.clients.elasticsearch._core.ExistsSourceRequest;
import co.elastic.clients.elasticsearch._core.GetRequest;
import co.elastic.clients.elasticsearch._core.GetResponse;
import co.elastic.clients.elasticsearch._core.GetScriptRequest;
import co.elastic.clients.elasticsearch._core.GetScriptResponse;
import co.elastic.clients.elasticsearch._core.GetSourceRequest;
import co.elastic.clients.elasticsearch._core.GetSourceResponse;
import co.elastic.clients.elasticsearch._core.IndexRequest;
import co.elastic.clients.elasticsearch._core.IndexResponse;
import co.elastic.clients.elasticsearch._core.InfoResponse;
import co.elastic.clients.elasticsearch._core.MgetRequest;
import co.elastic.clients.elasticsearch._core.MgetResponse;
import co.elastic.clients.elasticsearch._core.MsearchRequest;
import co.elastic.clients.elasticsearch._core.MsearchResponse;
import co.elastic.clients.elasticsearch._core.PutScriptRequest;
import co.elastic.clients.elasticsearch._core.PutScriptResponse;
import co.elastic.clients.elasticsearch._core.ReindexRequest;
import co.elastic.clients.elasticsearch._core.ReindexResponse;
import co.elastic.clients.elasticsearch._core.ScriptsPainlessExecuteRequest;
import co.elastic.clients.elasticsearch._core.ScriptsPainlessExecuteResponse;
import co.elastic.clients.elasticsearch._core.SearchRequest;
import co.elastic.clients.elasticsearch._core.SearchResponse;
import co.elastic.clients.elasticsearch._core.SearchShardsRequest;
import co.elastic.clients.elasticsearch._core.SearchShardsResponse;
import co.elastic.clients.elasticsearch._core.SearchTemplateRequest;
import co.elastic.clients.elasticsearch._core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch._core.UpdateByQueryRequest;
import co.elastic.clients.elasticsearch._core.UpdateByQueryResponse;
import co.elastic.clients.elasticsearch._core.UpdateRequest;
import co.elastic.clients.elasticsearch._core.UpdateResponse;
import co.elastic.clients.elasticsearch._types.InlineScript;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

@Weave
public abstract class ElasticsearchClient  extends ApiClient {
	
	public ElasticsearchClient(Transport transport) {
		super(transport);
	}

	@Trace(leaf = true)
	public <TSource> BulkResponse bulk(BulkRequest<TSource> request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		Endpoint<BulkRequest<?>, BulkResponse, ElasticsearchError> endPoint = BulkRequest.ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		Endpoint<CountRequest, CountResponse, ElasticsearchError> endPoint = CountRequest.ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), query);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		
		Endpoint<CreateRequest<?>, CreateResponse, ElasticsearchError> endPoint = CreateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		 Endpoint<DeleteRequest, DeleteResponse, ElasticsearchError> endPoint = DeleteRequest.ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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

		Endpoint<DeleteByQueryRequest, DeleteByQueryResponse, ElasticsearchError> endPoint = DeleteByQueryRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, DeleteByQueryRequest.ENDPOINT.queryParameters(request), query);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		Endpoint<DeleteByQueryRethrottleRequest, DeleteByQueryRethrottleResponse, ElasticsearchError> endPoint = DeleteByQueryRethrottleRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		Endpoint<DeleteScriptRequest, DeleteScriptResponse, ElasticsearchError> endPoint = DeleteScriptRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		Endpoint<ExistsRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		Endpoint<ExistsSourceRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsSourceRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);
		traced.reportAsExternal(params);
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
		Endpoint<GetScriptRequest, GetScriptResponse, ElasticsearchError> endPoint = GetScriptRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);
		traced.reportAsExternal(params);
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
		Endpoint<IndexRequest<?>, IndexResponse, ElasticsearchError> endPoint = IndexRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);
		traced.reportAsExternal(params);
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
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);
		traced.reportAsExternal(params);
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
		Endpoint<PutScriptRequest, PutScriptResponse, ElasticsearchError> endPoint = PutScriptRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		Endpoint<ReindexRequest, ReindexResponse, ElasticsearchError> endPoint = ReindexRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);
		traced.reportAsExternal(params);
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
		DatastoreParameters params = Utils.getParams(request,collectionAttr, null, query);
		traced.reportAsExternal(params);
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
		Endpoint<SearchShardsRequest, SearchShardsResponse, ElasticsearchError> endPoint = SearchShardsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);
		traced.reportAsExternal(params);
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
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null , null);
		traced.reportAsExternal(params);
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
		Endpoint<UpdateByQueryRequest, UpdateByQueryResponse, ElasticsearchError> endPoint = UpdateByQueryRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), query);
		traced.reportAsExternal(params);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
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
