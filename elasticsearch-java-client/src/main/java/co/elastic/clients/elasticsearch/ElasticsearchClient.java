package co.elastic.clients.elasticsearch;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.elasticsearch.javaclient.Utils;

import co.elastic.clients.base.BooleanResponse;
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
import co.elastic.clients.elasticsearch._core.SearchMvtRequest;
import co.elastic.clients.elasticsearch._core.SearchMvtResponse;
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

@Weave
public abstract class ElasticsearchClient {
	
//	@Trace(leaf = true)
//	public CountResponse count(CountRequest request) {
//		DatastoreParameters params = Utils.getParams("Count", null, request.index(),request.query(), null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument> CreateResponse create(CreateRequest<TDocument> request) {
//		DatastoreParameters params = Utils.getParams("Create", request.index(), null, null, request.document().getClass());
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public DeleteResponse delete(DeleteRequest request) {
//		DatastoreParameters params = Utils.getParams("Delete", request.index(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public DeleteByQueryResponse deleteByQuery(DeleteByQueryRequest request) {
//		DatastoreParameters params = Utils.getParams("DeleteByQuery", null, request.index(), request.query(), null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public DeleteByQueryRethrottleResponse deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request) {
//		DatastoreParameters params = Utils.getParams("DeleteByQueryRethrottle", request.taskId(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public DeleteScriptResponse deleteScript(DeleteScriptRequest request) {
//		DatastoreParameters params = Utils.getParams("DeleteScript", request.id(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public BooleanResponse exists(ExistsRequest request) {
//		DatastoreParameters params = Utils.getParams("Exists", request.index(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public BooleanResponse existsSource(ExistsSourceRequest request) {
//		DatastoreParameters params = Utils.getParams("ExistsSource", request.index(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument> GetResponse<TDocument> get(GetRequest request, Class<TDocument> tDocumentClass) {
//		DatastoreParameters params = Utils.getParams("Get", request.index(), null, null, tDocumentClass);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public GetScriptResponse getScript(GetScriptRequest request) {
//		DatastoreParameters params = Utils.getParams("GetScript", request.id(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument> GetSourceResponse<TDocument> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass) {
//		DatastoreParameters params = Utils.getParams("GetSource", request.index(), null, null, tDocumentClass);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument> MgetResponse<TDocument> mget(MgetRequest request, Class<TDocument> tDocumentClass) {
//		DatastoreParameters params = Utils.getParams("MGet", request.index(), null, null, tDocumentClass);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument> MsearchResponse<TDocument> msearch(MsearchRequest request, Class<TDocument> tDocumentClass) {
//		DatastoreParameters params = Utils.getParams("MSearch", null, request.index(), null, tDocumentClass);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public PutScriptResponse putScript(PutScriptRequest request) {
//		DatastoreParameters params = Utils.getParams("MSearch", request.id(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public ReindexResponse reindex(ReindexRequest request) {
//		DatastoreParameters params = Utils.getParams("Reindex", request.dest().index(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass) {
//		DatastoreParameters params = Utils.getParams("ScriptsPainlessExecute", request.script().source(), null, null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument> SearchResponse<TDocument> search(SearchRequest request, Class<TDocument> tDocumentClass) {
//		DatastoreParameters params = Utils.getParams("Search", null, request.index(), request.query(), tDocumentClass);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public SearchMvtResponse searchMvt(SearchMvtRequest request) {
//		DatastoreParameters params = Utils.getParams("SearchMvt", null, request.index(), request.query(), null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public SearchShardsResponse searchShards(SearchShardsRequest request) {
//		DatastoreParameters params = Utils.getParams("SearchShards", null, request.index(), null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument> SearchTemplateResponse<TDocument> searchTemplate(SearchTemplateRequest request, Class<TDocument> tDocumentClass) {
//		DatastoreParameters params = Utils.getParams("SearchTemplate", null, request.index(), null, null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public <TDocument, TPartialDocument> UpdateResponse<TDocument> update(UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass) {
//		DatastoreParameters params = Utils.getParams("Update", request.index(), null, null, tDocumentClass);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
//	
//	@Trace(leaf = true)
//	public UpdateByQueryResponse updateByQuery(UpdateByQueryRequest request) {
//		DatastoreParameters params = Utils.getParams("UpdateByQuery", null, request.index(), request.query(), null);
//		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//		return Weaver.callOriginal();
//	}
}
