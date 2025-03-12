package co.elastic.clients.elasticsearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.elasticsearch.javaclient.Utils;

import co.elastic.clients.elasticsearch._types.InlineScript;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
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
import co.elastic.clients.elasticsearch.core.SearchMvtRequest;
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
import co.elastic.clients.transport.endpoints.BinaryResponse;
import co.elastic.clients.transport.endpoints.BooleanResponse;

@Weave
public abstract class ElasticsearchClient {
	
	@Trace(leaf = true)
	public CountResponse count(CountRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("index", Utils.getCollectionFromList(request.index()));
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("query",Utils.getCollectionFromQuery(query, null));
		}
		DatastoreParameters params = Utils.getParams("Count", collectionAttr, CountRequest._ENDPOINT.queryParameters(request));
		
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> CreateResponse create(CreateRequest<TDocument> request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		TDocument doc = request.document();
		if(doc != null) {
			collectionAttr.put("documentType", doc.getClass().getSimpleName());
		}
		
		DatastoreParameters params = Utils.getParams("Create", collectionAttr, CreateRequest._ENDPOINT.queryParameters(request));
		
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteResponse delete(DeleteRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		DatastoreParameters params = Utils.getParams("Delete", collectionAttr, DeleteRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteByQueryResponse deleteByQuery(DeleteByQueryRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("index", Utils.getCollectionFromList(indices));
		}
		List<String> types = request.type();
		if(types != null && !types.isEmpty()) {
			collectionAttr.put("type", Utils.getCollectionFromList(types));
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("Query", Utils.getCollectionFromQuery(query, null));
		}

		DatastoreParameters params = Utils.getParams("DeleteByQuery", collectionAttr, DeleteByQueryRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteByQueryRethrottleResponse deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String taskId = request.taskId();
		if(taskId != null) {
			collectionAttr.put("taskid", taskId);
		}
		DatastoreParameters params = Utils.getParams("DeleteByQueryRethrottle", collectionAttr, DeleteByQueryRethrottleRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public DeleteScriptResponse deleteScript(DeleteScriptRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String scriptId = request.id();
		collectionAttr.put("scriptid", scriptId);
		DatastoreParameters params = Utils.getParams("DeleteScript", collectionAttr, DeleteScriptRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public BooleanResponse exists(ExistsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		
		DatastoreParameters params = Utils.getParams("Exists", collectionAttr, ExistsRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public BooleanResponse existsSource(ExistsSourceRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		DatastoreParameters params = Utils.getParams("ExistsSource", collectionAttr, ExistsSourceRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> GetResponse<TDocument> get(GetRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type",tDocumentClass.getSimpleName());
		}
		DatastoreParameters params = Utils.getParams("Get", collectionAttr, GetRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public GetScriptResponse getScript(GetScriptRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String id = request.id();
		if(id != null) {
			collectionAttr.put("scriptid", id);
		}
		DatastoreParameters params = Utils.getParams("GetScript", collectionAttr, GetScriptRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> GetSourceResponse<TDocument> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
		}
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		DatastoreParameters params = Utils.getParams("GetSource", collectionAttr, GetSourceRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> MgetResponse<TDocument> mget(MgetRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		DatastoreParameters params = Utils.getParams("MGet", collectionAttr, MgetRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> MsearchResponse<TDocument> msearch(MsearchRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("indices", Utils.getCollectionFromList(indices));
		}
		List<String> types = request.type();
		if(types != null && !types.isEmpty()) {
			collectionAttr.put("types", Utils.getCollectionFromList(types));
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		DatastoreParameters params = Utils.getParams("MSearch", collectionAttr, MsearchRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public PutScriptResponse putScript(PutScriptRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		String context = request.context();
		if(context != null) {
			collectionAttr.put("context", context);
		}
		
		DatastoreParameters params = Utils.getParams("PutScript", collectionAttr, PutScriptRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public ReindexResponse reindex(ReindexRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		collectionAttr.put("collection", "");
		DatastoreParameters params = Utils.getParams("Reindex", collectionAttr, ReindexRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass) {
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
		DatastoreParameters params = Utils.getParams("ScriptsPainlessExecute", collectionAttr, ScriptsPainlessExecuteRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> SearchResponse<TDocument> search(SearchRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("indices", Utils.getCollectionFromList(indices));
		}
		List<String> types = request.type();
		if(types != null && !types.isEmpty()) {
			collectionAttr.put("types", Utils.getCollectionFromList(types));
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("query", Utils.getCollectionFromQuery(query,null));
		}
		if(tDocumentClass != null) {
			collectionAttr.put("document-type", tDocumentClass.getSimpleName());
		}
		DatastoreParameters params = Utils.getParams("Search",collectionAttr, SearchRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public BinaryResponse searchMvt(SearchMvtRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("indices", Utils.getCollectionFromList(indices));
		}
	
		List<String> fields = request.fields();
		if(fields != null && !fields.isEmpty()) {
			collectionAttr.put("fields", Utils.getCollectionFromList(fields));
		}
		
		DatastoreParameters params = Utils.getParams("SearchMvt", collectionAttr, SearchMvtRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public SearchShardsResponse searchShards(SearchShardsRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("indices", Utils.getCollectionFromList(indices));
		} else {
			collectionAttr.put(" ", "");
		}
		DatastoreParameters params = Utils.getParams("SearchShards", collectionAttr, SearchShardsRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument> SearchTemplateResponse<TDocument> searchTemplate(SearchTemplateRequest request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("indices", Utils.getCollectionFromList(indices));
		}		
		String id = request.id();
		if(id != null) {
			collectionAttr.put("id", id);
		}
		List<String> types = request.type();
		if(types != null && !types.isEmpty()) {
			collectionAttr.put("types", Utils.getCollectionFromList(types));
		}
		
		DatastoreParameters params = Utils.getParams("SearchTemplate", collectionAttr, SearchTemplateRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public <TDocument, TPartialDocument> UpdateResponse<TDocument> update(UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		String index = request.index();
		if(index != null) {
			collectionAttr.put("index", index);
		}
		String type = request.type();
		if(type != null) {
			collectionAttr.put("type", type);
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
		DatastoreParameters params = Utils.getParams("Update", request.index(), null, null, tDocumentClass);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
	
	@Trace(leaf = true)
	public UpdateByQueryResponse updateByQuery(UpdateByQueryRequest request) {
		Map<String, String> collectionAttr = new HashMap<String, String>();
		List<String> indices = request.index();
		if(indices != null && !indices.isEmpty()) {
			collectionAttr.put("indices", Utils.getCollectionFromList(indices));
		}
		Query query = request.query();
		if(query != null) {
			collectionAttr.put("query", Utils.getCollectionFromQuery(query, null));
		}
		DatastoreParameters params = Utils.getParams("UpdateByQuery", collectionAttr, UpdateByQueryRequest._ENDPOINT.queryParameters(request));
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
	}
}
