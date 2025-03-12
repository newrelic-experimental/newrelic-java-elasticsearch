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

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.InlineScript;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.ClearScrollRequest;
import co.elastic.clients.elasticsearch.core.ClearScrollResponse;
import co.elastic.clients.elasticsearch.core.ClosePointInTimeRequest;
import co.elastic.clients.elasticsearch.core.ClosePointInTimeResponse;
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
import co.elastic.clients.elasticsearch.core.ExplainRequest;
import co.elastic.clients.elasticsearch.core.ExplainResponse;
import co.elastic.clients.elasticsearch.core.FieldCapsRequest;
import co.elastic.clients.elasticsearch.core.FieldCapsResponse;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.GetScriptContextResponse;
import co.elastic.clients.elasticsearch.core.GetScriptLanguagesResponse;
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
import co.elastic.clients.elasticsearch.core.MsearchTemplateRequest;
import co.elastic.clients.elasticsearch.core.MsearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.MtermvectorsRequest;
import co.elastic.clients.elasticsearch.core.MtermvectorsResponse;
import co.elastic.clients.elasticsearch.core.OpenPointInTimeRequest;
import co.elastic.clients.elasticsearch.core.OpenPointInTimeResponse;
import co.elastic.clients.elasticsearch.core.PutScriptRequest;
import co.elastic.clients.elasticsearch.core.PutScriptResponse;
import co.elastic.clients.elasticsearch.core.RankEvalRequest;
import co.elastic.clients.elasticsearch.core.RankEvalResponse;
import co.elastic.clients.elasticsearch.core.ReindexRequest;
import co.elastic.clients.elasticsearch.core.ReindexResponse;
import co.elastic.clients.elasticsearch.core.ReindexRethrottleRequest;
import co.elastic.clients.elasticsearch.core.ReindexRethrottleResponse;
import co.elastic.clients.elasticsearch.core.ScriptsPainlessExecuteRequest;
import co.elastic.clients.elasticsearch.core.ScriptsPainlessExecuteResponse;
import co.elastic.clients.elasticsearch.core.SearchMvtRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.SearchShardsRequest;
import co.elastic.clients.elasticsearch.core.SearchShardsResponse;
import co.elastic.clients.elasticsearch.core.SearchTemplateRequest;
import co.elastic.clients.elasticsearch.core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.TermsEnumRequest;
import co.elastic.clients.elasticsearch.core.TermsEnumResponse;
import co.elastic.clients.elasticsearch.core.TermvectorsRequest;
import co.elastic.clients.elasticsearch.core.TermvectorsResponse;
import co.elastic.clients.elasticsearch.core.UpdateByQueryRequest;
import co.elastic.clients.elasticsearch.core.UpdateByQueryResponse;
import co.elastic.clients.elasticsearch.core.UpdateByQueryRethrottleRequest;
import co.elastic.clients.elasticsearch.core.UpdateByQueryRethrottleResponse;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.BinaryResponse;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;

@Weave
public abstract class ElasticsearchAsyncClient {


	public CompletableFuture<BulkResponse> bulk(BulkRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null && !index.isEmpty()) {
			collectionAttr.put("index", index);
		}
		Endpoint<BulkRequest, BulkResponse, ErrorResponse> endPoint = BulkRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
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
		Endpoint<ClearScrollRequest, ClearScrollResponse, ErrorResponse> endPoint = ClearScrollRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ClosePointInTimeRequest, ClosePointInTimeResponse, ErrorResponse> endPoint = ClosePointInTimeRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<CountRequest, CountResponse, ErrorResponse> endPoint = CountRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		
		Endpoint<CreateRequest<?>, CreateResponse, ErrorResponse> endPoint = CreateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		 Endpoint<DeleteRequest, DeleteResponse, ErrorResponse> endPoint = DeleteRequest._ENDPOINT;
		
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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

		Endpoint<DeleteByQueryRequest, DeleteByQueryResponse, ErrorResponse> endPoint = DeleteByQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, DeleteByQueryRequest._ENDPOINT.queryParameters(request), query);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<DeleteByQueryRethrottleRequest, DeleteByQueryRethrottleResponse, ErrorResponse> endPoint = DeleteByQueryRethrottleRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<DeleteScriptRequest, DeleteScriptResponse, ErrorResponse> endPoint = DeleteScriptRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteScriptResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<DeleteScriptResponse> completionListener = new NRCompetionConsumer<DeleteScriptResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<BooleanResponse> exists(ExistsRequest request) {
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
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ExistsSourceRequest, BooleanResponse, ErrorResponse> endPoint = ExistsSourceRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		SimpleEndpoint<GetRequest, ?> endPoint = GetRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<GetResponse<TDocument>> completionListener = new NRCompetionConsumer<GetResponse<TDocument>>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<GetScriptResponse> getScript(GetScriptRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String id = request.id();
		if(id != null) {
			collectionAttr.put("scriptid", id);
		}
		Endpoint<GetScriptRequest, GetScriptResponse, ErrorResponse> endPoint = GetScriptRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		SimpleEndpoint<GetSourceRequest, ?> endPoint = GetSourceRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetSourceResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<GetSourceResponse<TDocument>> completionListener = new NRCompetionConsumer<GetSourceResponse<TDocument>>(Utils.getOperationFromRequest(request), params, attributes);
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
		Endpoint<IndexRequest<?>, IndexResponse, ErrorResponse> endPoint = IndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		SimpleEndpoint<MgetRequest, ?> endPoint = MgetRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<MgetResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<MgetResponse<TDocument>> completionListener = new NRCompetionConsumer<MgetResponse<TDocument>>(Utils.getOperationFromRequest(request), params, attributes);
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
		SimpleEndpoint<MsearchRequest, ?> endPoint = MsearchRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<MsearchResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<MsearchResponse<TDocument>> completionListener = new NRCompetionConsumer<MsearchResponse<TDocument>>(Utils.getOperationFromRequest(request), params, attributes);
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
		Endpoint<PutScriptRequest, PutScriptResponse, ErrorResponse> endPoint = PutScriptRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ReindexRequest, ReindexResponse, ErrorResponse> endPoint = ReindexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		 SimpleEndpoint<ScriptsPainlessExecuteRequest, ?> endPoint = ScriptsPainlessExecuteRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> future = Weaver.callOriginal();
		NRCompetionConsumer<ScriptsPainlessExecuteResponse<TResult>> completionListener = new NRCompetionConsumer<ScriptsPainlessExecuteResponse<TResult>>(Utils.getOperationFromRequest(request), params, attributes);
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
		SimpleEndpoint<SearchRequest, ?> endPoint = SearchRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request,collectionAttr, endPoint.queryParameters(request), query);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SearchResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<SearchResponse<TDocument>> completionListener = new NRCompetionConsumer<SearchResponse<TDocument>>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);	
	}

	public CompletableFuture<BinaryResponse> searchMvt(SearchMvtRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<BinaryResponse> future = Weaver.callOriginal();
		NRCompetionConsumer<BinaryResponse> completionListener = new NRCompetionConsumer<BinaryResponse>(Utils.getOperationFromRequest(request), params, null);
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
		Endpoint<SearchShardsRequest, SearchShardsResponse, ErrorResponse> endPoint = SearchShardsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		SimpleEndpoint<SearchTemplateRequest, ?> endPoint = SearchTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SearchTemplateResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<SearchTemplateResponse<TDocument>> completionListener = new NRCompetionConsumer<SearchTemplateResponse<TDocument>>(Utils.getOperationFromRequest(request), params, attributes);
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
		SimpleEndpoint<UpdateRequest<?, ?>, ?> endPoint = UpdateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request) , null);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<UpdateResponse<TDocument>> future = Weaver.callOriginal();
		NRCompetionConsumer<UpdateResponse<TDocument>> completionListener = new NRCompetionConsumer<UpdateResponse<TDocument>>(Utils.getOperationFromRequest(request), params, attributes);
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
		Endpoint<UpdateByQueryRequest, UpdateByQueryResponse, ErrorResponse> endPoint = UpdateByQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), query);
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
