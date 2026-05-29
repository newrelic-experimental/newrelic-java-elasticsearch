package co.elastic.clients.elasticsearch.indices;

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
import co.elastic.clients.elasticsearch.indices.add_block.IndicesBlockOptions;

@Weave
public abstract class ElasticsearchIndicesAsyncClient extends ApiClient{

	public ElasticsearchIndicesAsyncClient(Transport transport) {
		super(transport);
	}

	public CompletableFuture<AddBlockResponse> addBlock(AddBlockRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		IndicesBlockOptions block = request.block();
		if (block != null) {
			String blockName = block.name();
			if (blockName != null) {
				collectionAttr.put("block", blockName);
			} 
		}
		Endpoint<AddBlockRequest, AddBlockResponse, ElasticsearchError> endPoint = AddBlockRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<AddBlockResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<AddBlockResponse> completionListener = new NRCompetionConsumer<AddBlockResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<AnalyzeResponse> analyze(AnalyzeRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<AnalyzeRequest, AnalyzeResponse, ElasticsearchError> endPoint = AnalyzeRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<AnalyzeResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<AnalyzeResponse> completionListener = new NRCompetionConsumer<AnalyzeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ClearCacheResponse> clearCache(ClearCacheRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		String fields = Utils.getObjectString(request.fields());
		if(fields != null) {
			collectionAttr.put("fields", fields);
		}
		Endpoint<ClearCacheRequest, ClearCacheResponse, ElasticsearchError> endPoint = ClearCacheRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ClearCacheResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ClearCacheResponse> completionListener = new NRCompetionConsumer<ClearCacheResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);

	}

	public CompletableFuture<CloneResponse> clone(CloneRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloneRequest, CloneResponse, ElasticsearchError> endPoint = CloneRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CloneResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<CloneResponse> completionListener = new NRCompetionConsumer<CloneResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<CloseResponse> close(CloseRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloseRequest, CloseResponse, ElasticsearchError> endPoint = CloseRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CloseResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<CloseResponse> completionListener = new NRCompetionConsumer<CloseResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<CreateResponse> create(CreateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CreateRequest, CreateResponse, ElasticsearchError> endPoint = CreateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CreateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<CreateResponse> completionListener = new NRCompetionConsumer<CreateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<CreateDataStreamResponse> createDataStream(CreateDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<CreateDataStreamRequest, CreateDataStreamResponse, ElasticsearchError> endPoint = CreateDataStreamRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CreateDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<CreateDataStreamResponse> completionListener = new NRCompetionConsumer<CreateDataStreamResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DataStreamsStatsResponse> dataStreamsStats(DataStreamsStatsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ElasticsearchError> endPoint = DataStreamsStatsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DataStreamsStatsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DataStreamsStatsResponse> completionListener = new NRCompetionConsumer<DataStreamsStatsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteResponse> delete(DeleteRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<DeleteRequest, DeleteResponse, ElasticsearchError> endPoint = DeleteRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteResponse> completionListener = new NRCompetionConsumer<DeleteResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteAliasResponse> deleteAlias(DeleteAliasRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		String names = Utils.getObjectString(request.name());
		if(names != null) {
			collectionAttr.put("names", names);
		}
		Endpoint<DeleteAliasRequest, DeleteAliasResponse, ElasticsearchError> endPoint = DeleteAliasRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteAliasResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteAliasResponse> completionListener = new NRCompetionConsumer<DeleteAliasResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteDataStreamResponse> deleteDataStream(DeleteDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String names = Utils.getObjectString(request.name());
		if(names != null) {
			collectionAttr.put("names", names);
		}
		Endpoint<DeleteDataStreamRequest, DeleteDataStreamResponse, ElasticsearchError> endPoint = DeleteDataStreamRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteDataStreamResponse> completionListener = new NRCompetionConsumer<DeleteDataStreamResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(DeleteIndexTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String names = Utils.getObjectString(request.name());
		if(names != null) {
			collectionAttr.put("names", names);
		}
		Endpoint<DeleteIndexTemplateRequest, DeleteIndexTemplateResponse, ElasticsearchError> endPoint = DeleteIndexTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteIndexTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteIndexTemplateResponse> completionListener = new NRCompetionConsumer<DeleteIndexTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteTemplateResponse> deleteTemplate(DeleteTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DeleteTemplateRequest, DeleteTemplateResponse, ElasticsearchError> endPoint = DeleteTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteTemplateResponse> completionListener = new NRCompetionConsumer<DeleteTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DiskUsageResponse> diskUsage(DiskUsageRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		Endpoint<DiskUsageRequest, DiskUsageResponse, ElasticsearchError> endPoint = DiskUsageRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DiskUsageResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DiskUsageResponse> completionListener = new NRCompetionConsumer<DiskUsageResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<BooleanResponse> exists(ExistsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("index", indices);
		}
		Endpoint<ExistsRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<BooleanResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<BooleanResponse> existsAlias(ExistsAliasRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("index", indices);
		}
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ExistsAliasRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsAliasRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<BooleanResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<BooleanResponse> existsIndexTemplate(ExistsIndexTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ExistsIndexTemplateRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsIndexTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<BooleanResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<BooleanResponse> existsTemplate(ExistsTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ExistsTemplateRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<BooleanResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<FlushResponse> flush(FlushRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		Endpoint<FlushRequest, FlushResponse, ElasticsearchError> endPoint = FlushRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<FlushResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<FlushResponse> completionListener = new NRCompetionConsumer<FlushResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ForcemergeResponse> forcemerge(ForcemergeRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ForcemergeRequest, ForcemergeResponse, ElasticsearchError> endPoint = ForcemergeRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ForcemergeResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ForcemergeResponse> completionListener = new NRCompetionConsumer<ForcemergeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetResponse> get(GetRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetRequest, GetResponse, ElasticsearchError> endPoint = GetRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetResponse> completionListener = new NRCompetionConsumer<GetResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetAliasResponse> getAlias(GetAliasRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetAliasRequest, GetAliasResponse, ElasticsearchError> endPoint = GetAliasRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetAliasResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetAliasResponse> completionListener = new NRCompetionConsumer<GetAliasResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetDataStreamResponse> getDataStream(GetDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetDataStreamRequest, GetDataStreamResponse, ElasticsearchError> endPoint = GetDataStreamRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetDataStreamResponse> completionListener = new NRCompetionConsumer<GetDataStreamResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetFieldMappingResponse> getFieldMapping(GetFieldMappingRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String field = Utils.getObjectString(request.fields());
		if(field != null) {
			collectionAttr.put("field", field);
		}
		Endpoint<GetFieldMappingRequest, GetFieldMappingResponse, ElasticsearchError> endPoint = GetFieldMappingRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetFieldMappingResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetFieldMappingResponse> completionListener = new NRCompetionConsumer<GetFieldMappingResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(GetIndexTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetIndexTemplateRequest, GetIndexTemplateResponse, ElasticsearchError> endPoint = GetIndexTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetIndexTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetIndexTemplateResponse> completionListener = new NRCompetionConsumer<GetIndexTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetMappingResponse> getMapping(GetMappingRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetMappingRequest, GetMappingResponse, ElasticsearchError> endPoint = GetMappingRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetMappingResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetMappingResponse> completionListener = new NRCompetionConsumer<GetMappingResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetSettingsResponse> getSettings(GetSettingsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetSettingsRequest, GetSettingsResponse, ElasticsearchError> endPoint = GetSettingsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetSettingsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetSettingsResponse> completionListener = new NRCompetionConsumer<GetSettingsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetTemplateResponse> getTemplate(GetTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetTemplateRequest, GetTemplateResponse, ElasticsearchError> endPoint = GetTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetTemplateResponse> completionListener = new NRCompetionConsumer<GetTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<MigrateToDataStreamResponse> migrateToDataStream(MigrateToDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<MigrateToDataStreamRequest, MigrateToDataStreamResponse, ElasticsearchError> endPoint = MigrateToDataStreamRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<MigrateToDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<MigrateToDataStreamResponse> completionListener = new NRCompetionConsumer<MigrateToDataStreamResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<OpenResponse> open(OpenRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<OpenRequest, OpenResponse, ElasticsearchError> endPoint = OpenRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<OpenResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<OpenResponse> completionListener = new NRCompetionConsumer<OpenResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PromoteDataStreamResponse> promoteDataStream(PromoteDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PromoteDataStreamRequest, PromoteDataStreamResponse, ElasticsearchError> endPoint = PromoteDataStreamRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PromoteDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PromoteDataStreamResponse> completionListener = new NRCompetionConsumer<PromoteDataStreamResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutAliasResponse> putAlias(PutAliasRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutAliasRequest, PutAliasResponse, ElasticsearchError> endPoint = PutAliasRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutAliasResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutAliasResponse> completionListener = new NRCompetionConsumer<PutAliasResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(PutIndexTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutIndexTemplateRequest, PutIndexTemplateResponse, ElasticsearchError> endPoint = PutIndexTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutIndexTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutIndexTemplateResponse> completionListener = new NRCompetionConsumer<PutIndexTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutMappingResponse> putMapping(PutMappingRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutMappingRequest, PutMappingResponse, ElasticsearchError> endPoint = PutMappingRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutMappingResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutMappingResponse> completionListener = new NRCompetionConsumer<PutMappingResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutSettingsResponse> putSettings(PutSettingsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutSettingsRequest, PutSettingsResponse, ElasticsearchError> endPoint = PutSettingsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutSettingsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutSettingsResponse> completionListener = new NRCompetionConsumer<PutSettingsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutTemplateResponse> putTemplate(PutTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutTemplateRequest, PutTemplateResponse, ElasticsearchError> endPoint = PutTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutTemplateResponse> completionListener = new NRCompetionConsumer<PutTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<RecoveryResponse> recovery(RecoveryRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RecoveryRequest, RecoveryResponse, ElasticsearchError> endPoint = RecoveryRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<RecoveryResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<RecoveryResponse> completionListener = new NRCompetionConsumer<RecoveryResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<RefreshResponse> refresh(RefreshRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RefreshRequest, RefreshResponse, ElasticsearchError> endPoint = RefreshRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<RefreshResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<RefreshResponse> completionListener = new NRCompetionConsumer<RefreshResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ReloadSearchAnalyzersResponse> reloadSearchAnalyzers(ReloadSearchAnalyzersRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ReloadSearchAnalyzersRequest, ReloadSearchAnalyzersResponse, ElasticsearchError> endPoint = ReloadSearchAnalyzersRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ReloadSearchAnalyzersResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ReloadSearchAnalyzersResponse> completionListener = new NRCompetionConsumer<ReloadSearchAnalyzersResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ResolveIndexResponse> resolveIndex(ResolveIndexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ResolveIndexRequest, ResolveIndexResponse, ElasticsearchError> endPoint = ResolveIndexRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ResolveIndexResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ResolveIndexResponse> completionListener = new NRCompetionConsumer<ResolveIndexResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<RolloverResponse> rollover(RolloverRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String newIndex = request.newIndex();
		if(newIndex != null) {
			collectionAttr.put("newIndex", newIndex);
		}
		String alias = request.alias();
		if(alias != null) {
			collectionAttr.put("alias", alias);
		}
		Endpoint<RolloverRequest, RolloverResponse, ElasticsearchError> endPoint = RolloverRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<RolloverResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<RolloverResponse> completionListener = new NRCompetionConsumer<RolloverResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<SegmentsResponse> segments(SegmentsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<SegmentsRequest, SegmentsResponse, ElasticsearchError> endPoint = SegmentsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SegmentsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<SegmentsResponse> completionListener = new NRCompetionConsumer<SegmentsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ShardStoresResponse> shardStores(ShardStoresRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ShardStoresRequest, ShardStoresResponse, ElasticsearchError> endPoint = ShardStoresRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ShardStoresResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ShardStoresResponse> completionListener = new NRCompetionConsumer<ShardStoresResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ShrinkResponse> shrink(ShrinkRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String target = request.target();
		if(target != null) {
			collectionAttr.put("target", target);
		}
		Endpoint<ShrinkRequest, ShrinkResponse, ElasticsearchError> endPoint = ShrinkRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ShrinkResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ShrinkResponse> completionListener = new NRCompetionConsumer<ShrinkResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<SimulateIndexTemplateResponse> simulateIndexTemplate(SimulateIndexTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateIndexTemplateRequest, SimulateIndexTemplateResponse, ElasticsearchError> endPoint = SimulateIndexTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SimulateIndexTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<SimulateIndexTemplateResponse> completionListener = new NRCompetionConsumer<SimulateIndexTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<SimulateTemplateResponse> simulateTemplate(SimulateTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateTemplateRequest, SimulateTemplateResponse, ElasticsearchError> endPoint = SimulateTemplateRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SimulateTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<SimulateTemplateResponse> completionListener = new NRCompetionConsumer<SimulateTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<SplitResponse> split(SplitRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String target = request.target();
		if(target != null) {
			collectionAttr.put("target", target);
		}
		Endpoint<SplitRequest, SplitResponse, ElasticsearchError> endPoint = SplitRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SplitResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<SplitResponse> completionListener = new NRCompetionConsumer<SplitResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<StatsResponse> stats(StatsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String metric = Utils.getObjectString(request.metric());
		if(metric != null) {
			collectionAttr.put("metric", metric);
		}
		Endpoint<StatsRequest, StatsResponse, ElasticsearchError> endPoint = StatsRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<StatsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<StatsResponse> completionListener = new NRCompetionConsumer<StatsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<UnfreezeResponse> unfreeze(UnfreezeRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<UnfreezeRequest, UnfreezeResponse, ElasticsearchError> endPoint = UnfreezeRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<UnfreezeResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<UnfreezeResponse> completionListener = new NRCompetionConsumer<UnfreezeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<UpdateAliasesResponse> updateAliases(UpdateAliasesRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ElasticsearchError> endPoint = UpdateAliasesRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<UpdateAliasesResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<UpdateAliasesResponse> completionListener = new NRCompetionConsumer<UpdateAliasesResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ValidateQueryResponse> validateQuery(ValidateQueryRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ValidateQueryRequest, ValidateQueryResponse, ElasticsearchError> endPoint = ValidateQueryRequest.ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.hasRequestBody() ? Utils.getRequestBody(request, transport.jsonpMapper()) : null;
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ValidateQueryResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ValidateQueryResponse> completionListener = new NRCompetionConsumer<ValidateQueryResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

}

