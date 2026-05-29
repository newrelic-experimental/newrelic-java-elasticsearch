package co.elastic.clients.elasticsearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.elasticsearch.javaclient.NRCompetionConsumer;
import com.newrelic.instrumentation.labs.elasticsearch.javaclient.Utils;

import co.elastic.clients.base.ApiClient;
import co.elastic.clients.base.BooleanResponse;
import co.elastic.clients.base.ElasticsearchError;
import co.elastic.clients.base.Endpoint;
import co.elastic.clients.base.Transport;
import co.elastic.clients.elasticsearch._core.BulkRequest;
import co.elastic.clients.elasticsearch._core.BulkResponse;
import co.elastic.clients.elasticsearch._core.ClearScrollRequest;
import co.elastic.clients.elasticsearch._core.ClearScrollResponse;
import co.elastic.clients.elasticsearch._core.ClosePointInTimeRequest;
import co.elastic.clients.elasticsearch._core.ClosePointInTimeResponse;
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
import co.elastic.clients.elasticsearch._core.ExplainRequest;
import co.elastic.clients.elasticsearch._core.ExplainResponse;
import co.elastic.clients.elasticsearch._core.FieldCapsRequest;
import co.elastic.clients.elasticsearch._core.FieldCapsResponse;
import co.elastic.clients.elasticsearch._core.GetRequest;
import co.elastic.clients.elasticsearch._core.GetResponse;
import co.elastic.clients.elasticsearch._core.GetScriptContextResponse;
import co.elastic.clients.elasticsearch._core.GetScriptLanguagesResponse;
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
import co.elastic.clients.elasticsearch._core.MsearchTemplateRequest;
import co.elastic.clients.elasticsearch._core.MsearchTemplateResponse;
import co.elastic.clients.elasticsearch._core.MtermvectorsRequest;
import co.elastic.clients.elasticsearch._core.MtermvectorsResponse;
import co.elastic.clients.elasticsearch._core.OpenPointInTimeRequest;
import co.elastic.clients.elasticsearch._core.OpenPointInTimeResponse;
import co.elastic.clients.elasticsearch._core.PutScriptRequest;
import co.elastic.clients.elasticsearch._core.PutScriptResponse;
import co.elastic.clients.elasticsearch._core.RankEvalRequest;
import co.elastic.clients.elasticsearch._core.RankEvalResponse;
import co.elastic.clients.elasticsearch._core.ReindexRequest;
import co.elastic.clients.elasticsearch._core.ReindexResponse;
import co.elastic.clients.elasticsearch._core.ReindexRethrottleRequest;
import co.elastic.clients.elasticsearch._core.ReindexRethrottleResponse;
import co.elastic.clients.elasticsearch._core.ScriptsPainlessExecuteRequest;
import co.elastic.clients.elasticsearch._core.ScriptsPainlessExecuteResponse;
import co.elastic.clients.elasticsearch._core.SearchRequest;
import co.elastic.clients.elasticsearch._core.SearchResponse;
import co.elastic.clients.elasticsearch._core.SearchShardsRequest;
import co.elastic.clients.elasticsearch._core.SearchShardsResponse;
import co.elastic.clients.elasticsearch._core.SearchTemplateRequest;
import co.elastic.clients.elasticsearch._core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch._core.TermsEnumRequest;
import co.elastic.clients.elasticsearch._core.TermsEnumResponse;
import co.elastic.clients.elasticsearch._core.TermvectorsRequest;
import co.elastic.clients.elasticsearch._core.TermvectorsResponse;
import co.elastic.clients.elasticsearch._core.UpdateByQueryRequest;
import co.elastic.clients.elasticsearch._core.UpdateByQueryResponse;
import co.elastic.clients.elasticsearch._core.UpdateByQueryRethrottleRequest;
import co.elastic.clients.elasticsearch._core.UpdateByQueryRethrottleResponse;
import co.elastic.clients.elasticsearch._core.UpdateRequest;
import co.elastic.clients.elasticsearch._core.UpdateResponse;
import co.elastic.clients.elasticsearch._types.InlineScript;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

@Weave
public abstract class ElasticsearchAsyncClient extends ApiClient {

	public ElasticsearchAsyncClient(Transport transport) {
		super(transport);
	}


	public <TSource> CompletableFuture<BulkResponse> bulk(BulkRequest<TSource> request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		Endpoint<BulkRequest<?>, BulkResponse, ElasticsearchError> endPoint = BulkRequest.ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, null);
		CompletableFuture<BulkResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<BulkResponse> completionListener = new NRCompetionConsumer<BulkResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String scrollId = Utils.getObjectString(request.scrollId());
		if(scrollId != null && !scrollId.isEmpty()) {
			collectionAttr.put("scrollId", scrollId);
		}
		Endpoint<ClearScrollRequest, ClearScrollResponse, ElasticsearchError> endPoint = ClearScrollRequest.ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ClearScrollResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<ClearScrollResponse> completionListener = new NRCompetionConsumer<ClearScrollResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}


	public CompletableFuture<ClosePointInTimeResponse> closePointInTime(ClosePointInTimeRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String closeId = Utils.getObjectString(request.id());
		if(closeId != null && !closeId.isEmpty()) {
			collectionAttr.put("closeId", closeId);
		}
		Endpoint<ClosePointInTimeRequest, ClosePointInTimeResponse, ElasticsearchError> endPoint = ClosePointInTimeRequest.ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ClosePointInTimeResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<ClosePointInTimeResponse> completionListener = new NRCompetionConsumer<ClosePointInTimeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<CountResponse> count(CountRequest request) {
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
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CountResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<CountResponse> completionListener = new NRCompetionConsumer<CountResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<CreateResponse> create(CreateRequest<TDocument> request) {
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
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CreateResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<CreateResponse> completionListener = new NRCompetionConsumer<CreateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<DeleteResponse> delete(DeleteRequest request) {
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
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<DeleteResponse> completionListener = new NRCompetionConsumer<DeleteResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<DeleteByQueryResponse> deleteByQuery(DeleteByQueryRequest request) {
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
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteByQueryResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<DeleteByQueryResponse> completionListener = new NRCompetionConsumer<DeleteByQueryResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String taskId = request.taskId();
		if(taskId != null) {
			collectionAttr.put("taskid", taskId);
		}
		Endpoint<DeleteByQueryRethrottleRequest, DeleteByQueryRethrottleResponse, ElasticsearchError> endPoint = DeleteByQueryRethrottleRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteByQueryRethrottleResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<DeleteByQueryRethrottleResponse> completionListener = new NRCompetionConsumer<DeleteByQueryRethrottleResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<DeleteScriptResponse> deleteScript(DeleteScriptRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String scriptId = request.id();
		collectionAttr.put("scriptid", scriptId);
		Endpoint<DeleteScriptRequest, DeleteScriptResponse, ElasticsearchError> endPoint = DeleteScriptRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteScriptResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<DeleteScriptResponse> completionListener = new NRCompetionConsumer<DeleteScriptResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<BooleanResponse> exists(ExistsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ExistsRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<BooleanResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<BooleanResponse> existsSource(ExistsSourceRequest request) {
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
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<BooleanResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(ExplainRequest request, Class<TDocument> tDocumentClass) {
		DatastoreParameters params = null;
		CompletableFuture<ExplainResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<ExplainResponse<TDocument>> completionListener = new NRCompetionConsumer<ExplainResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<FieldCapsResponse> fieldCaps(FieldCapsRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<FieldCapsResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<FieldCapsResponse> completionListener = new NRCompetionConsumer<FieldCapsResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<GetResponse<TDocument>> get(GetRequest request, Class<TDocument> tDocumentClass) {
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
		CompletableFuture<GetResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<GetResponse<TDocument>> completionListener = new NRCompetionConsumer<GetResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<GetScriptResponse> getScript(GetScriptRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String id = request.id();
		if(id != null) {
			collectionAttr.put("scriptid", id);
		}
		Endpoint<GetScriptRequest, GetScriptResponse, ElasticsearchError> endPoint = GetScriptRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetScriptResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<GetScriptResponse> completionListener = new NRCompetionConsumer<GetScriptResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<GetScriptContextResponse> getScriptContext() {
		DatastoreParameters params = null;
		CompletableFuture<GetScriptContextResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<GetScriptContextResponse> completionListener = new NRCompetionConsumer<GetScriptContextResponse>("GetScriptContext", params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<GetScriptLanguagesResponse> getScriptLanguages() {
		DatastoreParameters params = null;
		CompletableFuture<GetScriptLanguagesResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<GetScriptLanguagesResponse> completionListener = new NRCompetionConsumer<GetScriptLanguagesResponse>("GetScriptLanguates", params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass) {
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
		CompletableFuture<GetSourceResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<GetSourceResponse<TDocument>> completionListener = new NRCompetionConsumer<GetSourceResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<IndexResponse> index(IndexRequest<TDocument> request) {
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
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<IndexResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<IndexResponse> completionListener = new NRCompetionConsumer<IndexResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<InfoResponse> info() {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		DatastoreParameters params = Utils.getParams("InfoRequest", collectionAttr, Collections.emptyMap(), null);
		CompletableFuture<InfoResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<InfoResponse> completionListener = new NRCompetionConsumer<InfoResponse>("Info", params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<MgetResponse<TDocument>> mget(MgetRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);
		CompletableFuture<MgetResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<MgetResponse<TDocument>> completionListener = new NRCompetionConsumer<MgetResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<MsearchResponse<TDocument>> msearch(MsearchRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index =  Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		DatastoreParameters params = Utils.getParams(request, collectionAttr, null, null);

		CompletableFuture<MsearchResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<MsearchResponse<TDocument>> completionListener = new NRCompetionConsumer<MsearchResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<MsearchTemplateResponse<TDocument>> msearchTemplate(MsearchTemplateRequest request, Class<TDocument> tDocumentClass) {
		DatastoreParameters params = null;
		CompletableFuture<MsearchTemplateResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<MsearchTemplateResponse<TDocument>> completionListener = new NRCompetionConsumer<MsearchTemplateResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<MtermvectorsResponse> mtermvectors(MtermvectorsRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<MtermvectorsResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<MtermvectorsResponse> completionListener = new NRCompetionConsumer<MtermvectorsResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<OpenPointInTimeResponse> openPointInTime(OpenPointInTimeRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<OpenPointInTimeResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<OpenPointInTimeResponse> completionListener = new NRCompetionConsumer<OpenPointInTimeResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<BooleanResponse> ping() {
		DatastoreParameters params = null;
		CompletableFuture<BooleanResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>("Ping", params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<PutScriptResponse> putScript(PutScriptRequest request) {
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
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutScriptResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<PutScriptResponse> completionListener = new NRCompetionConsumer<PutScriptResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<RankEvalResponse> rankEval(RankEvalRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<RankEvalResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<RankEvalResponse> completionListener = new NRCompetionConsumer<RankEvalResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<ReindexResponse> reindex(ReindexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("collection", "");
		Endpoint<ReindexRequest, ReindexResponse, ElasticsearchError> endPoint = ReindexRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ReindexResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<ReindexResponse> completionListener = new NRCompetionConsumer<ReindexResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(ReindexRethrottleRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<ReindexRethrottleResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<ReindexRethrottleResponse> completionListener = new NRCompetionConsumer<ReindexRethrottleResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass) {
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
		CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> future = Weaver.callOriginal();
		NRCompetionConsumer<ScriptsPainlessExecuteResponse<TResult>> completionListener = new NRCompetionConsumer<ScriptsPainlessExecuteResponse<TResult>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<SearchResponse<TDocument>> search(SearchRequest request, Class<TDocument> tDocumentClass) {
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
		CompletableFuture<SearchResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<SearchResponse<TDocument>> completionListener = new NRCompetionConsumer<SearchResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<SearchShardsResponse> searchShards(SearchShardsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		} else {
			collectionAttr.put(" ", "");
		}
		Endpoint<SearchShardsRequest, SearchShardsResponse, ElasticsearchError> endPoint = SearchShardsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SearchShardsResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<SearchShardsResponse> completionListener = new NRCompetionConsumer<SearchShardsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(SearchTemplateRequest request, Class<TDocument> tDocumentClass) {
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
		CompletableFuture<SearchTemplateResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<SearchTemplateResponse<TDocument>> completionListener = new NRCompetionConsumer<SearchTemplateResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<TermsEnumResponse> termsEnum(TermsEnumRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<TermsEnumResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<TermsEnumResponse> completionListener = new NRCompetionConsumer<TermsEnumResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument> CompletableFuture<TermvectorsResponse> termvectors(TermvectorsRequest<TDocument> request) {
		DatastoreParameters params = null;
		CompletableFuture<TermvectorsResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<TermvectorsResponse> completionListener = new NRCompetionConsumer<TermvectorsResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public <TDocument, TPartialDocument> CompletableFuture<UpdateResponse<TDocument>> update(UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass) {
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
		CompletableFuture<UpdateResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<UpdateResponse<TDocument>> completionListener = new NRCompetionConsumer<UpdateResponse<TDocument>>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<UpdateByQueryResponse> updateByQuery(UpdateByQueryRequest request) {
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
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<UpdateByQueryResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<UpdateByQueryResponse> completionListener = new NRCompetionConsumer<UpdateByQueryResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(UpdateByQueryRethrottleRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<UpdateByQueryRethrottleResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<UpdateByQueryRethrottleResponse> completionListener = new NRCompetionConsumer<UpdateByQueryRethrottleResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);	
	}

}
