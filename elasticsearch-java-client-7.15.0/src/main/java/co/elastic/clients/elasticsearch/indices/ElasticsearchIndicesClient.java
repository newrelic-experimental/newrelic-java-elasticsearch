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

import co.elastic.clients.base.ApiClient;
import co.elastic.clients.base.BooleanResponse;
import co.elastic.clients.base.ElasticsearchError;
import co.elastic.clients.base.Endpoint;
import co.elastic.clients.base.Transport;
import co.elastic.clients.elasticsearch.indices.add_block.IndicesBlockOptions;

@Weave
public abstract class ElasticsearchIndicesClient extends ApiClient {

	public ElasticsearchIndicesClient(Transport transport) {
		super(transport);
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
		Endpoint<AddBlockRequest, AddBlockResponse, ElasticsearchError> endPoint = AddBlockRequest.ENDPOINT;
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
	public AnalyzeResponse analyze(AnalyzeRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<AnalyzeRequest, AnalyzeResponse, ElasticsearchError> endPoint = AnalyzeRequest.ENDPOINT;
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
		Endpoint<ClearCacheRequest, ClearCacheResponse, ElasticsearchError> endPoint = ClearCacheRequest.ENDPOINT;
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
	public CloneResponse clone(CloneRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloneRequest, CloneResponse, ElasticsearchError> endPoint = CloneRequest.ENDPOINT;
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
	public CloseResponse close(CloseRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CloseRequest, CloseResponse, ElasticsearchError> endPoint = CloseRequest.ENDPOINT;
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
	public CreateResponse create(CreateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<CreateRequest, CreateResponse, ElasticsearchError> endPoint = CreateRequest.ENDPOINT;
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
	public CreateDataStreamResponse createDataStream(CreateDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<CreateDataStreamRequest, CreateDataStreamResponse, ElasticsearchError> endPoint = CreateDataStreamRequest.ENDPOINT;
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
	public DataStreamsStatsResponse dataStreamsStats(DataStreamsStatsRequest request)  {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ElasticsearchError> endPoint = DataStreamsStatsRequest.ENDPOINT;
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
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
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
		Endpoint<DeleteAliasRequest, DeleteAliasResponse, ElasticsearchError> endPoint = DeleteAliasRequest.ENDPOINT;
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
	public DeleteDataStreamResponse deleteDataStream(DeleteDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String names = Utils.getObjectString(request.name());
		if(names != null) {
			collectionAttr.put("names", names);
		}
		Endpoint<DeleteDataStreamRequest, DeleteDataStreamResponse, ElasticsearchError> endPoint = DeleteDataStreamRequest.ENDPOINT;
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
	public DeleteTemplateResponse deleteTemplate(DeleteTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = request.name();
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<DeleteTemplateRequest, DeleteTemplateResponse, ElasticsearchError> endPoint = DeleteTemplateRequest.ENDPOINT;
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
	public DiskUsageResponse diskUsage(DiskUsageRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		Endpoint<DiskUsageRequest, DiskUsageResponse, ElasticsearchError> endPoint = DiskUsageRequest.ENDPOINT;
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
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("index", indices);
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
		Endpoint<ExistsAliasRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsAliasRequest.ENDPOINT;
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
	public BooleanResponse existsIndexTemplate(ExistsIndexTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ExistsIndexTemplateRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsIndexTemplateRequest.ENDPOINT;
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
	public BooleanResponse existsTemplate(ExistsTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ExistsTemplateRequest, BooleanResponse, ElasticsearchError> endPoint = ExistsTemplateRequest.ENDPOINT;
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
	public FlushResponse flush(FlushRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String indices = Utils.getObjectString(request.index());
		if(indices != null) {
			collectionAttr.put("indices", indices);
		}
		Endpoint<FlushRequest, FlushResponse, ElasticsearchError> endPoint = FlushRequest.ENDPOINT;
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
	public ForcemergeResponse forcemerge(ForcemergeRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ForcemergeRequest, ForcemergeResponse, ElasticsearchError> endPoint = ForcemergeRequest.ENDPOINT;
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
	public GetResponse get(GetRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetRequest, GetResponse, ElasticsearchError> endPoint = GetRequest.ENDPOINT;
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
		Endpoint<GetAliasRequest, GetAliasResponse, ElasticsearchError> endPoint = GetAliasRequest.ENDPOINT;
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
	public GetDataStreamResponse getDataStream(GetDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetDataStreamRequest, GetDataStreamResponse, ElasticsearchError> endPoint = GetDataStreamRequest.ENDPOINT;
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
		Endpoint<GetFieldMappingRequest, GetFieldMappingResponse, ElasticsearchError> endPoint = GetFieldMappingRequest.ENDPOINT;
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
	public GetMappingResponse getMapping(GetMappingRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<GetMappingRequest, GetMappingResponse, ElasticsearchError> endPoint = GetMappingRequest.ENDPOINT;
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
	public GetSettingsResponse getSettings(GetSettingsRequest request) {
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
		Endpoint<GetSettingsRequest, GetSettingsResponse, ElasticsearchError> endPoint = GetSettingsRequest.ENDPOINT;
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
	public GetTemplateResponse getTemplate(GetTemplateRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<GetTemplateRequest, GetTemplateResponse, ElasticsearchError> endPoint = GetTemplateRequest.ENDPOINT;
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
	public MigrateToDataStreamResponse migrateToDataStream(MigrateToDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<MigrateToDataStreamRequest, MigrateToDataStreamResponse, ElasticsearchError> endPoint = MigrateToDataStreamRequest.ENDPOINT;
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
	public OpenResponse open(OpenRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<OpenRequest, OpenResponse, ElasticsearchError> endPoint = OpenRequest.ENDPOINT;
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
	public PromoteDataStreamResponse promoteDataStream(PromoteDataStreamRequest request) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PromoteDataStreamRequest, PromoteDataStreamResponse, ElasticsearchError> endPoint = PromoteDataStreamRequest.ENDPOINT;
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
		Endpoint<PutAliasRequest, PutAliasResponse, ElasticsearchError> endPoint = PutAliasRequest.ENDPOINT;
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
	public PutIndexTemplateResponse putIndexTemplate(PutIndexTemplateRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutIndexTemplateRequest, PutIndexTemplateResponse, ElasticsearchError> endPoint = PutIndexTemplateRequest.ENDPOINT;
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
	public PutMappingResponse putMapping(PutMappingRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutMappingRequest, PutMappingResponse, ElasticsearchError> endPoint = PutMappingRequest.ENDPOINT;
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
	public PutSettingsResponse putSettings(PutSettingsRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<PutSettingsRequest, PutSettingsResponse, ElasticsearchError> endPoint = PutSettingsRequest.ENDPOINT;
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
	public final PutTemplateResponse putTemplate(PutTemplateRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<PutTemplateRequest, PutTemplateResponse, ElasticsearchError> endPoint = PutTemplateRequest.ENDPOINT;
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
	public RecoveryResponse recovery(RecoveryRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RecoveryRequest, RecoveryResponse, ElasticsearchError> endPoint = RecoveryRequest.ENDPOINT;
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
	public RefreshResponse refresh(RefreshRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<RefreshRequest, RefreshResponse, ElasticsearchError> endPoint = RefreshRequest.ENDPOINT;
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
	public ReloadSearchAnalyzersResponse reloadSearchAnalyzers(ReloadSearchAnalyzersRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ReloadSearchAnalyzersRequest, ReloadSearchAnalyzersResponse, ElasticsearchError> endPoint = ReloadSearchAnalyzersRequest.ENDPOINT;
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
	public ResolveIndexResponse resolveIndex(ResolveIndexRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<ResolveIndexRequest, ResolveIndexResponse, ElasticsearchError> endPoint = ResolveIndexRequest.ENDPOINT;
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
	public RolloverResponse rollover(RolloverRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
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
		Endpoint<RolloverRequest, RolloverResponse, ElasticsearchError> endPoint = RolloverRequest.ENDPOINT;
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
	public SegmentsResponse segments(SegmentsRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<SegmentsRequest, SegmentsResponse, ElasticsearchError> endPoint = SegmentsRequest.ENDPOINT;
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
	public ShardStoresResponse shardStores(ShardStoresRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ShardStoresRequest, ShardStoresResponse, ElasticsearchError> endPoint = ShardStoresRequest.ENDPOINT;
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
	public ShrinkResponse shrink(ShrinkRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
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
		Endpoint<ShrinkRequest, ShrinkResponse, ElasticsearchError> endPoint = ShrinkRequest.ENDPOINT;
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
	public SimulateIndexTemplateResponse simulateIndexTemplate(SimulateIndexTemplateRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateIndexTemplateRequest, SimulateIndexTemplateResponse, ElasticsearchError> endPoint = SimulateIndexTemplateRequest.ENDPOINT;
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
	public SimulateTemplateResponse simulateTemplate(SimulateTemplateRequest request)  {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String name = Utils.getObjectString(request.name());
		if(name != null) {
			collectionAttr.put("name", name);
		}
		Endpoint<SimulateTemplateRequest, SimulateTemplateResponse, ElasticsearchError> endPoint = SimulateTemplateRequest.ENDPOINT;
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
	public SplitResponse split(SplitRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
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
		Endpoint<SplitRequest, SplitResponse, ElasticsearchError> endPoint = SplitRequest.ENDPOINT;
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
	public StatsResponse stats(StatsRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
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
		Endpoint<StatsRequest, StatsResponse, ElasticsearchError> endPoint = StatsRequest.ENDPOINT;
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
	public UnfreezeResponse unfreeze(UnfreezeRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<UnfreezeRequest, UnfreezeResponse, ElasticsearchError> endPoint = UnfreezeRequest.ENDPOINT;
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
	public UpdateAliasesResponse updateAliases(UpdateAliasesRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("", "");
		Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ElasticsearchError> endPoint = UpdateAliasesRequest.ENDPOINT;
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
	public ValidateQueryResponse validateQuery(ValidateQueryRequest request) {
		request.getClass().getSimpleName().replace("Request", "");
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = Utils.getObjectString(request.index());
		if(index != null) {
			collectionAttr.put("index", index);
		}
		Endpoint<ValidateQueryRequest, ValidateQueryResponse, ElasticsearchError> endPoint = ValidateQueryRequest.ENDPOINT;
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

}
