package co.elastic.clients.elasticsearch.indices;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.elasticsearch.javaclient.NRCompetionConsumer;
import com.newrelic.instrumentation.labs.elasticsearch.javaclient.Utils;

import co.elastic.clients.ApiClient;
import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch.indices.add_block.IndicesBlockOptions;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.TransportOptions;
import co.elastic.clients.transport.endpoints.BooleanResponse;

@Weave
public abstract class ElasticsearchIndicesAsyncClient extends ApiClient<ElasticsearchTransport, ElasticsearchIndicesAsyncClient> {

	public ElasticsearchIndicesAsyncClient(ElasticsearchTransport transport) {
		super(transport, null);
	}

	public ElasticsearchIndicesAsyncClient(ElasticsearchTransport transport, TransportOptions transportOptions) {
		super(transport, transportOptions);
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
		Endpoint<AddBlockRequest, AddBlockResponse, ErrorResponse> endPoint = AddBlockRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<AnalyzeRequest, AnalyzeResponse, ErrorResponse> endPoint = AnalyzeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<AnalyzeResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<AnalyzeResponse> completionListener = new NRCompetionConsumer<AnalyzeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<AnalyzeResponse> analyze() {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		AnalyzeRequest request = new AnalyzeRequest.Builder().build();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<AnalyzeRequest, AnalyzeResponse, ErrorResponse> endPoint = AnalyzeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ClearCacheRequest, ClearCacheResponse, ErrorResponse> endPoint = ClearCacheRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ClearCacheResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ClearCacheResponse> completionListener = new NRCompetionConsumer<ClearCacheResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);

	}

	public CompletableFuture<ClearCacheResponse> clearCache() {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		ClearCacheRequest request = new ClearCacheRequest.Builder().build();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ClearCacheRequest, ClearCacheResponse, ErrorResponse> endPoint = ClearCacheRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ClearCacheResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ClearCacheResponse> completionListener = new NRCompetionConsumer<ClearCacheResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<CloneIndexResponse> clone(CloneIndexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloneIndexRequest, CloneIndexResponse, ErrorResponse> endPoint = CloneIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CloneIndexResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<CloneIndexResponse> completionListener = new NRCompetionConsumer<CloneIndexResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<CloseIndexResponse> close(CloseIndexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloseIndexRequest, CloseIndexResponse, ErrorResponse> endPoint = CloseIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CloseIndexResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<CloseIndexResponse> completionListener = new NRCompetionConsumer<CloseIndexResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<CreateIndexResponse> create(CreateIndexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CreateIndexRequest, CreateIndexResponse, ErrorResponse> endPoint = CreateIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<CreateIndexResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<CreateIndexResponse> completionListener = new NRCompetionConsumer<CreateIndexResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<CreateDataStreamResponse> createDataStream(CreateDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<CreateDataStreamRequest, CreateDataStreamResponse, ErrorResponse> endPoint = CreateDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ErrorResponse> endPoint = DataStreamsStatsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DataStreamsStatsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DataStreamsStatsResponse> completionListener = new NRCompetionConsumer<DataStreamsStatsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DataStreamsStatsResponse> dataStreamsStats() {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		DataStreamsStatsRequest request = new DataStreamsStatsRequest.Builder().build();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ErrorResponse> endPoint = DataStreamsStatsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DataStreamsStatsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DataStreamsStatsResponse> completionListener = new NRCompetionConsumer<DataStreamsStatsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteIndexResponse> delete(DeleteIndexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<DeleteIndexRequest, DeleteIndexResponse, ErrorResponse> endPoint = DeleteIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteIndexResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteIndexResponse> completionListener = new NRCompetionConsumer<DeleteIndexResponse>(Utils.getOperationFromRequest(request), params, attributes);
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
		Endpoint<DeleteAliasRequest, DeleteAliasResponse, ErrorResponse> endPoint = DeleteAliasRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DeleteAliasResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteAliasResponse> completionListener = new NRCompetionConsumer<DeleteAliasResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteDataLifecycleResponse> deleteDataLifecycle(DeleteDataLifecycleRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<DeleteDataLifecycleResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DeleteDataLifecycleResponse> completionListener = new NRCompetionConsumer<DeleteDataLifecycleResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DeleteDataStreamResponse> deleteDataStream(DeleteDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String names = Utils.getObjectString(request.name());
		if(names != null) {
			collectionAttr.put("names", names);
		}
		Endpoint<DeleteDataStreamRequest, DeleteDataStreamResponse, ErrorResponse> endPoint = DeleteDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<DeleteIndexTemplateRequest, DeleteIndexTemplateResponse, ErrorResponse> endPoint = DeleteIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<DeleteTemplateRequest, DeleteTemplateResponse, ErrorResponse> endPoint = DeleteTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<DiskUsageRequest, DiskUsageResponse, ErrorResponse> endPoint = DiskUsageRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<DiskUsageResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DiskUsageResponse> completionListener = new NRCompetionConsumer<DiskUsageResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<DownsampleResponse> downsample(DownsampleRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<DownsampleResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<DownsampleResponse> completionListener = new NRCompetionConsumer<DownsampleResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<BooleanResponse> exists(ExistsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("index", indices);
		}
		Endpoint<ExistsRequest, BooleanResponse, ErrorResponse> endPoint = ExistsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ExistsAliasRequest, BooleanResponse, ErrorResponse> endPoint = ExistsAliasRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ExistsIndexTemplateRequest, BooleanResponse, ErrorResponse> endPoint = ExistsIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ExistsTemplateRequest, BooleanResponse, ErrorResponse> endPoint = ExistsTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<BooleanResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<BooleanResponse> completionListener = new NRCompetionConsumer<BooleanResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ExplainDataLifecycleResponse> explainDataLifecycle(ExplainDataLifecycleRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<ExplainDataLifecycleResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ExplainDataLifecycleResponse> completionListener = new NRCompetionConsumer<ExplainDataLifecycleResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<FieldUsageStatsResponse> fieldUsageStats(FieldUsageStatsRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<FieldUsageStatsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<FieldUsageStatsResponse> completionListener = new NRCompetionConsumer<FieldUsageStatsResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<FlushResponse> flush(FlushRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		Endpoint<FlushRequest, FlushResponse, ErrorResponse> endPoint = FlushRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<FlushResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<FlushResponse> completionListener = new NRCompetionConsumer<FlushResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<FlushResponse> flush() {
		FlushRequest request = new FlushRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<FlushRequest, FlushResponse, ErrorResponse> endPoint = FlushRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ForcemergeRequest, ForcemergeResponse, ErrorResponse> endPoint = ForcemergeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ForcemergeResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ForcemergeResponse> completionListener = new NRCompetionConsumer<ForcemergeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ForcemergeResponse> forcemerge() {
		ForcemergeRequest request = new ForcemergeRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ForcemergeRequest, ForcemergeResponse, ErrorResponse> endPoint = ForcemergeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ForcemergeResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ForcemergeResponse> completionListener = new NRCompetionConsumer<ForcemergeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetIndexResponse> get(GetIndexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetIndexRequest, GetIndexResponse, ErrorResponse> endPoint = GetIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetIndexResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetIndexResponse> completionListener = new NRCompetionConsumer<GetIndexResponse>(Utils.getOperationFromRequest(request), params, attributes);
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
		Endpoint<GetAliasRequest, GetAliasResponse, ErrorResponse> endPoint = GetAliasRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetAliasResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetAliasResponse> completionListener = new NRCompetionConsumer<GetAliasResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetAliasResponse> getAlias() {
		GetAliasRequest request = new GetAliasRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetAliasRequest, GetAliasResponse, ErrorResponse> endPoint = GetAliasRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetAliasResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetAliasResponse> completionListener = new NRCompetionConsumer<GetAliasResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetDataLifecycleResponse> getDataLifecycle(GetDataLifecycleRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<GetDataLifecycleResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetDataLifecycleResponse> completionListener = new NRCompetionConsumer<GetDataLifecycleResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetDataStreamResponse> getDataStream(GetDataStreamRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetDataStreamRequest, GetDataStreamResponse, ErrorResponse> endPoint = GetDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetDataStreamResponse> completionListener = new NRCompetionConsumer<GetDataStreamResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetDataStreamResponse> getDataStream() {
		GetDataStreamRequest request = new GetDataStreamRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetDataStreamRequest, GetDataStreamResponse, ErrorResponse> endPoint = GetDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<GetFieldMappingRequest, GetFieldMappingResponse, ErrorResponse> endPoint = GetFieldMappingRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<GetIndexTemplateRequest, GetIndexTemplateResponse, ErrorResponse> endPoint = GetIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetIndexTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetIndexTemplateResponse> completionListener = new NRCompetionConsumer<GetIndexTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetIndexTemplateResponse> getIndexTemplate() {
		GetIndexTemplateRequest request = new GetIndexTemplateRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetIndexTemplateRequest, GetIndexTemplateResponse, ErrorResponse> endPoint = GetIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<GetMappingRequest, GetMappingResponse, ErrorResponse> endPoint = GetMappingRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetMappingResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetMappingResponse> completionListener = new NRCompetionConsumer<GetMappingResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetMappingResponse> getMapping() {
		GetMappingRequest request = new GetMappingRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetMappingRequest, GetMappingResponse, ErrorResponse> endPoint = GetMappingRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetMappingResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetMappingResponse> completionListener = new NRCompetionConsumer<GetMappingResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetIndicesSettingsResponse> getSettings(GetIndicesSettingsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetIndicesSettingsRequest, GetIndicesSettingsResponse, ErrorResponse> endPoint = GetIndicesSettingsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetIndicesSettingsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetIndicesSettingsResponse> completionListener = new NRCompetionConsumer<GetIndicesSettingsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetIndicesSettingsResponse> getSettings() {
		GetIndicesSettingsRequest request = new GetIndicesSettingsRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetIndicesSettingsRequest, GetIndicesSettingsResponse, ErrorResponse> endPoint = GetIndicesSettingsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetIndicesSettingsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetIndicesSettingsResponse> completionListener = new NRCompetionConsumer<GetIndicesSettingsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetTemplateResponse> getTemplate(GetTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetTemplateRequest, GetTemplateResponse, ErrorResponse> endPoint = GetTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<GetTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<GetTemplateResponse> completionListener = new NRCompetionConsumer<GetTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<GetTemplateResponse> getTemplate() {
		GetTemplateRequest request = new GetTemplateRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetTemplateRequest, GetTemplateResponse, ErrorResponse> endPoint = GetTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<MigrateToDataStreamRequest, MigrateToDataStreamResponse, ErrorResponse> endPoint = MigrateToDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<MigrateToDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<MigrateToDataStreamResponse> completionListener = new NRCompetionConsumer<MigrateToDataStreamResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ModifyDataStreamResponse> modifyDataStream(ModifyDataStreamRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<ModifyDataStreamResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ModifyDataStreamResponse> completionListener = new NRCompetionConsumer<ModifyDataStreamResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<OpenResponse> open(OpenRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<OpenRequest, OpenResponse, ErrorResponse> endPoint = OpenRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<PromoteDataStreamRequest, PromoteDataStreamResponse, ErrorResponse> endPoint = PromoteDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<PutAliasRequest, PutAliasResponse, ErrorResponse> endPoint = PutAliasRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutAliasResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutAliasResponse> completionListener = new NRCompetionConsumer<PutAliasResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutDataLifecycleResponse> putDataLifecycle(PutDataLifecycleRequest request) {
		DatastoreParameters params = null;
		CompletableFuture<PutDataLifecycleResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutDataLifecycleResponse> completionListener = new NRCompetionConsumer<PutDataLifecycleResponse>(Utils.getOperationFromRequest(request), params, null);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(PutIndexTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutIndexTemplateRequest, PutIndexTemplateResponse, ErrorResponse> endPoint = PutIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<PutMappingRequest, PutMappingResponse, ErrorResponse> endPoint = PutMappingRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutMappingResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutMappingResponse> completionListener = new NRCompetionConsumer<PutMappingResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutIndicesSettingsResponse> putSettings(PutIndicesSettingsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutIndicesSettingsRequest, PutIndicesSettingsResponse, ErrorResponse> endPoint = PutIndicesSettingsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutIndicesSettingsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutIndicesSettingsResponse> completionListener = new NRCompetionConsumer<PutIndicesSettingsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutIndicesSettingsResponse> putSettings() {
		PutIndicesSettingsRequest request = new PutIndicesSettingsRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutIndicesSettingsRequest, PutIndicesSettingsResponse, ErrorResponse> endPoint = PutIndicesSettingsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<PutIndicesSettingsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<PutIndicesSettingsResponse> completionListener = new NRCompetionConsumer<PutIndicesSettingsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<PutTemplateResponse> putTemplate(PutTemplateRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutTemplateRequest, PutTemplateResponse, ErrorResponse> endPoint = PutTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<RecoveryRequest, RecoveryResponse, ErrorResponse> endPoint = RecoveryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<RecoveryResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<RecoveryResponse> completionListener = new NRCompetionConsumer<RecoveryResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<RecoveryResponse> recovery() {
		RecoveryRequest request = new RecoveryRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RecoveryRequest, RecoveryResponse, ErrorResponse> endPoint = RecoveryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<RefreshRequest, RefreshResponse, ErrorResponse> endPoint = RefreshRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<RefreshResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<RefreshResponse> completionListener = new NRCompetionConsumer<RefreshResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<RefreshResponse> refresh() {
		RefreshRequest request = new RefreshRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RefreshRequest, RefreshResponse, ErrorResponse> endPoint = RefreshRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ReloadSearchAnalyzersRequest, ReloadSearchAnalyzersResponse, ErrorResponse> endPoint = ReloadSearchAnalyzersRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ResolveIndexRequest, ResolveIndexResponse, ErrorResponse> endPoint = ResolveIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<RolloverRequest, RolloverResponse, ErrorResponse> endPoint = RolloverRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<SegmentsRequest, SegmentsResponse, ErrorResponse> endPoint = SegmentsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SegmentsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<SegmentsResponse> completionListener = new NRCompetionConsumer<SegmentsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<SegmentsResponse> segments() {
		SegmentsRequest request = new SegmentsRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<SegmentsRequest, SegmentsResponse, ErrorResponse> endPoint = SegmentsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ShardStoresRequest, ShardStoresResponse, ErrorResponse> endPoint = ShardStoresRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ShardStoresResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ShardStoresResponse> completionListener = new NRCompetionConsumer<ShardStoresResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ShardStoresResponse> shardStores() {
		ShardStoresRequest request = new ShardStoresRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ShardStoresRequest, ShardStoresResponse, ErrorResponse> endPoint = ShardStoresRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ShrinkRequest, ShrinkResponse, ErrorResponse> endPoint = ShrinkRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<SimulateIndexTemplateRequest, SimulateIndexTemplateResponse, ErrorResponse> endPoint = SimulateIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<SimulateTemplateRequest, SimulateTemplateResponse, ErrorResponse> endPoint = SimulateTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SimulateTemplateResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<SimulateTemplateResponse> completionListener = new NRCompetionConsumer<SimulateTemplateResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<SimulateTemplateResponse> simulateTemplate() {
		SimulateTemplateRequest request = new SimulateTemplateRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateTemplateRequest, SimulateTemplateResponse, ErrorResponse> endPoint = SimulateTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<SplitRequest, SplitResponse, ErrorResponse> endPoint = SplitRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<SplitResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<SplitResponse> completionListener = new NRCompetionConsumer<SplitResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<IndicesStatsResponse> stats(IndicesStatsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String metric = Utils.getObjectString(request.metric());
		if(metric != null) {
			collectionAttr.put("metric", metric);
		}
		Endpoint<IndicesStatsRequest, IndicesStatsResponse, ErrorResponse> endPoint = IndicesStatsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<IndicesStatsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<IndicesStatsResponse> completionListener = new NRCompetionConsumer<IndicesStatsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<IndicesStatsResponse> stats() {
		IndicesStatsRequest request = new IndicesStatsRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String metric = Utils.getObjectString(request.metric());
		if(metric != null) {
			collectionAttr.put("metric", metric);
		}
		Endpoint<IndicesStatsRequest, IndicesStatsResponse, ErrorResponse> endPoint = IndicesStatsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<IndicesStatsResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<IndicesStatsResponse> completionListener = new NRCompetionConsumer<IndicesStatsResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<UnfreezeResponse> unfreeze(UnfreezeRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<UnfreezeRequest, UnfreezeResponse, ErrorResponse> endPoint = UnfreezeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<UnfreezeResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<UnfreezeResponse> completionListener = new NRCompetionConsumer<UnfreezeResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<UpdateAliasesResponse> updateAliases(UpdateAliasesRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ErrorResponse> endPoint = UpdateAliasesRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<UpdateAliasesResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<UpdateAliasesResponse> completionListener = new NRCompetionConsumer<UpdateAliasesResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<UpdateAliasesResponse> updateAliases() {
		UpdateAliasesRequest request = new UpdateAliasesRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ErrorResponse> endPoint = UpdateAliasesRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
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
		Endpoint<ValidateQueryRequest, ValidateQueryResponse, ErrorResponse> endPoint = ValidateQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ValidateQueryResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ValidateQueryResponse> completionListener = new NRCompetionConsumer<ValidateQueryResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

	public CompletableFuture<ValidateQueryResponse> validateQuery() {
		ValidateQueryRequest request = new ValidateQueryRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ValidateQueryRequest, ValidateQueryResponse, ErrorResponse> endPoint = ValidateQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		CompletableFuture<ValidateQueryResponse> future =  Weaver.callOriginal();
		NRCompetionConsumer<ValidateQueryResponse> completionListener = new NRCompetionConsumer<ValidateQueryResponse>(Utils.getOperationFromRequest(request), params, attributes);
		return future.whenComplete(completionListener);
	}

}

