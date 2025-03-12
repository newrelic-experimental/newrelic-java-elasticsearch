package co.elastic.clients.elasticsearch.indices;

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
import co.elastic.clients.elasticsearch.indices.add_block.IndicesBlockOptions;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.TransportOptions;
import co.elastic.clients.transport.endpoints.BooleanResponse;

@Weave
public abstract class ElasticsearchIndicesClient extends ApiClient<ElasticsearchTransport, ElasticsearchIndicesClient> {

	public ElasticsearchIndicesClient(ElasticsearchTransport transport) {
		super(transport, null);
	}

	public ElasticsearchIndicesClient(ElasticsearchTransport transport, TransportOptions transportOptions) {
		super(transport, transportOptions);
	}


	@Trace(leaf = true)
	public AddBlockResponse addBlock(AddBlockRequest request)  {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);
		
		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public AnalyzeResponse analyze(AnalyzeRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<AnalyzeRequest, AnalyzeResponse, ErrorResponse> endPoint = AnalyzeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public AnalyzeResponse analyze() {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		AnalyzeRequest request = new AnalyzeRequest.Builder().build();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<AnalyzeRequest, AnalyzeResponse, ErrorResponse> endPoint = AnalyzeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ClearCacheResponse clearCache(ClearCacheRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ClearCacheResponse clearCache() {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		ClearCacheRequest request = new ClearCacheRequest.Builder().build();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ClearCacheRequest, ClearCacheResponse, ErrorResponse> endPoint = ClearCacheRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public CloneIndexResponse clone(CloneIndexRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloneIndexRequest, CloneIndexResponse, ErrorResponse> endPoint = CloneIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public CloseIndexResponse close(CloseIndexRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloseIndexRequest, CloseIndexResponse, ErrorResponse> endPoint = CloseIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public CreateIndexResponse create(CreateIndexRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CreateIndexRequest, CreateIndexResponse, ErrorResponse> endPoint = CreateIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public CreateDataStreamResponse createDataStream(CreateDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<CreateDataStreamRequest, CreateDataStreamResponse, ErrorResponse> endPoint = CreateDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DataStreamsStatsResponse dataStreamsStats(DataStreamsStatsRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ErrorResponse> endPoint = DataStreamsStatsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DataStreamsStatsResponse dataStreamsStats() {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		DataStreamsStatsRequest request = new DataStreamsStatsRequest.Builder().build();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ErrorResponse> endPoint = DataStreamsStatsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DeleteIndexResponse delete(DeleteIndexRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<DeleteIndexRequest, DeleteIndexResponse, ErrorResponse> endPoint = DeleteIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DeleteAliasResponse deleteAlias(DeleteAliasRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DeleteDataStreamResponse deleteDataStream(DeleteDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String names = Utils.getObjectString(request.name());
		if(names != null) {
			collectionAttr.put("names", names);
		}
		Endpoint<DeleteDataStreamRequest, DeleteDataStreamResponse, ErrorResponse> endPoint = DeleteDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DeleteIndexTemplateResponse deleteIndexTemplate(DeleteIndexTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String names = Utils.getObjectString(request.name());
		if(names != null) {
			collectionAttr.put("names", names);
		}
		Endpoint<DeleteIndexTemplateRequest, DeleteIndexTemplateResponse, ErrorResponse> endPoint = DeleteIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DeleteTemplateResponse deleteTemplate(DeleteTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DeleteTemplateRequest, DeleteTemplateResponse, ErrorResponse> endPoint = DeleteTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public DiskUsageResponse diskUsage(DiskUsageRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		Endpoint<DiskUsageRequest, DiskUsageResponse, ErrorResponse> endPoint = DiskUsageRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
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
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("index", indices);
		}
		Endpoint<ExistsRequest, BooleanResponse, ErrorResponse> endPoint = ExistsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public BooleanResponse existsAlias(ExistsAliasRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public BooleanResponse existsIndexTemplate(ExistsIndexTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ExistsIndexTemplateRequest, BooleanResponse, ErrorResponse> endPoint = ExistsIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public BooleanResponse existsTemplate(ExistsTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ExistsTemplateRequest, BooleanResponse, ErrorResponse> endPoint = ExistsTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public FlushResponse flush(FlushRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		Endpoint<FlushRequest, FlushResponse, ErrorResponse> endPoint = FlushRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public FlushResponse flush() {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		FlushRequest request = new FlushRequest.Builder().build();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<FlushRequest, FlushResponse, ErrorResponse> endPoint = FlushRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ForcemergeResponse forcemerge(ForcemergeRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ForcemergeRequest, ForcemergeResponse, ErrorResponse> endPoint = ForcemergeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ForcemergeResponse forcemerge() {
		ForcemergeRequest request = new ForcemergeRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ForcemergeRequest, ForcemergeResponse, ErrorResponse> endPoint = ForcemergeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetIndexResponse get(GetIndexRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetIndexRequest, GetIndexResponse, ErrorResponse> endPoint = GetIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetAliasResponse getAlias(GetAliasRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetAliasResponse getAlias() {
		GetAliasRequest request = new GetAliasRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetDataStreamResponse getDataStream(GetDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetDataStreamRequest, GetDataStreamResponse, ErrorResponse> endPoint = GetDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetDataStreamResponse getDataStream() {
		GetDataStreamRequest request = new GetDataStreamRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetDataStreamRequest, GetDataStreamResponse, ErrorResponse> endPoint = GetDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetFieldMappingResponse getFieldMapping(GetFieldMappingRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetIndexTemplateResponse getIndexTemplate(GetIndexTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetIndexTemplateRequest, GetIndexTemplateResponse, ErrorResponse> endPoint = GetIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetIndexTemplateResponse getIndexTemplate() {
		GetIndexTemplateRequest request = new GetIndexTemplateRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetIndexTemplateRequest, GetIndexTemplateResponse, ErrorResponse> endPoint = GetIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetMappingResponse getMapping(GetMappingRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetMappingRequest, GetMappingResponse, ErrorResponse> endPoint = GetMappingRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetMappingResponse getMapping() {
		GetMappingRequest request = new GetMappingRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetMappingRequest, GetMappingResponse, ErrorResponse> endPoint = GetMappingRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetIndicesSettingsResponse getSettings(GetIndicesSettingsRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetIndicesSettingsResponse getSettings() {
		GetIndicesSettingsRequest request = new GetIndicesSettingsRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetIndicesSettingsRequest, GetIndicesSettingsResponse, ErrorResponse> endPoint = GetIndicesSettingsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetTemplateResponse getTemplate(GetTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetTemplateRequest, GetTemplateResponse, ErrorResponse> endPoint = GetTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public GetTemplateResponse getTemplate() {
		GetTemplateRequest request = new GetTemplateRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetTemplateRequest, GetTemplateResponse, ErrorResponse> endPoint = GetTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public MigrateToDataStreamResponse migrateToDataStream(MigrateToDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<MigrateToDataStreamRequest, MigrateToDataStreamResponse, ErrorResponse> endPoint = MigrateToDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public OpenResponse open(OpenRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<OpenRequest, OpenResponse, ErrorResponse> endPoint = OpenRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public PromoteDataStreamResponse promoteDataStream(PromoteDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PromoteDataStreamRequest, PromoteDataStreamResponse, ErrorResponse> endPoint = PromoteDataStreamRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public PutAliasResponse putAlias(PutAliasRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public PutIndexTemplateResponse putIndexTemplate(PutIndexTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutIndexTemplateRequest, PutIndexTemplateResponse, ErrorResponse> endPoint = PutIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public PutMappingResponse putMapping(PutMappingRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutMappingRequest, PutMappingResponse, ErrorResponse> endPoint = PutMappingRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public PutIndicesSettingsResponse putSettings(PutIndicesSettingsRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutIndicesSettingsRequest, PutIndicesSettingsResponse, ErrorResponse> endPoint = PutIndicesSettingsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public PutIndicesSettingsResponse putSettings() {
		PutIndicesSettingsRequest request = new PutIndicesSettingsRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutIndicesSettingsRequest, PutIndicesSettingsResponse, ErrorResponse> endPoint = PutIndicesSettingsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public final PutTemplateResponse putTemplate(PutTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutTemplateRequest, PutTemplateResponse, ErrorResponse> endPoint = PutTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public RecoveryResponse recovery(RecoveryRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RecoveryRequest, RecoveryResponse, ErrorResponse> endPoint = RecoveryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public RecoveryResponse recovery() {
		RecoveryRequest request = new RecoveryRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RecoveryRequest, RecoveryResponse, ErrorResponse> endPoint = RecoveryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public RefreshResponse refresh(RefreshRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RefreshRequest, RefreshResponse, ErrorResponse> endPoint = RefreshRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public RefreshResponse refresh() {
		RefreshRequest request = new RefreshRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RefreshRequest, RefreshResponse, ErrorResponse> endPoint = RefreshRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ReloadSearchAnalyzersResponse reloadSearchAnalyzers(ReloadSearchAnalyzersRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ReloadSearchAnalyzersRequest, ReloadSearchAnalyzersResponse, ErrorResponse> endPoint = ReloadSearchAnalyzersRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ResolveIndexResponse resolveIndex(ResolveIndexRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ResolveIndexRequest, ResolveIndexResponse, ErrorResponse> endPoint = ResolveIndexRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public RolloverResponse rollover(RolloverRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public SegmentsResponse segments(SegmentsRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<SegmentsRequest, SegmentsResponse, ErrorResponse> endPoint = SegmentsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public SegmentsResponse segments() {
		SegmentsRequest request = new SegmentsRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<SegmentsRequest, SegmentsResponse, ErrorResponse> endPoint = SegmentsRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ShardStoresResponse shardStores(ShardStoresRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ShardStoresRequest, ShardStoresResponse, ErrorResponse> endPoint = ShardStoresRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ShardStoresResponse shardStores() {
		ShardStoresRequest request = new ShardStoresRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ShardStoresRequest, ShardStoresResponse, ErrorResponse> endPoint = ShardStoresRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ShrinkResponse shrink(ShrinkRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public SimulateIndexTemplateResponse simulateIndexTemplate(SimulateIndexTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateIndexTemplateRequest, SimulateIndexTemplateResponse, ErrorResponse> endPoint = SimulateIndexTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public SimulateTemplateResponse simulateTemplate(SimulateTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateTemplateRequest, SimulateTemplateResponse, ErrorResponse> endPoint = SimulateTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public SimulateTemplateResponse simulateTemplate() {
		SimulateTemplateRequest request = new SimulateTemplateRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateTemplateRequest, SimulateTemplateResponse, ErrorResponse> endPoint = SimulateTemplateRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public SplitResponse split(SplitRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public IndicesStatsResponse stats(IndicesStatsRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public IndicesStatsResponse stats() {
		IndicesStatsRequest request = new IndicesStatsRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
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
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public UnfreezeResponse unfreeze(UnfreezeRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<UnfreezeRequest, UnfreezeResponse, ErrorResponse> endPoint = UnfreezeRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public UpdateAliasesResponse updateAliases(UpdateAliasesRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ErrorResponse> endPoint = UpdateAliasesRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public UpdateAliasesResponse updateAliases() {
		UpdateAliasesRequest request = new UpdateAliasesRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ErrorResponse> endPoint = UpdateAliasesRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ValidateQueryResponse validateQuery(ValidateQueryRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ValidateQueryRequest, ValidateQueryResponse, ErrorResponse> endPoint = ValidateQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}

	@Trace(leaf = true)
	public ValidateQueryResponse validateQuery() {
		ValidateQueryRequest request = new ValidateQueryRequest.Builder().build();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ValidateQueryRequest, ValidateQueryResponse, ErrorResponse> endPoint = ValidateQueryRequest._ENDPOINT;
		DatastoreParameters params = Utils.getParams(request, collectionAttr, endPoint.queryParameters(request), null);
		
		traced.reportAsExternal(params);

		Object payloadObj = endPoint.body(request);
		String requestUrl = endPoint.requestUrl(request);
		String method = endPoint.method(request);
		String endPtId = endPoint.id();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.recordRequest(attributes, payloadObj, requestUrl, method, endPtId);
		traced.addCustomAttributes(attributes);

		return Weaver.callOriginal();
	}
}
