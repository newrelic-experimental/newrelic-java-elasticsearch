package co.elastic.clients.elasticsearch;

import com.newrelic.api.agent.weaver.Weave;

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
	
	/**
	 * 
	 * Remove abstract and provide a body.  report the method as ElasticSearch DB call
	 * Instrument these methods and create a DataStoreParameters object to report as external
	 *  using xxxxxx from the input xxxxxxRequest as the operation name
	 *  for most of the requests we should be able to use the index() value
	 */

	public abstract CountResponse count(CountRequest request);
	public abstract <TDocument> CreateResponse create(CreateRequest<TDocument> request);
	public abstract DeleteResponse delete(DeleteRequest request);
	public abstract DeleteByQueryResponse deleteByQuery(DeleteByQueryRequest request);
	public abstract DeleteByQueryRethrottleResponse deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request);
	public abstract DeleteScriptResponse deleteScript(DeleteScriptRequest request);
	public abstract BooleanResponse exists(ExistsRequest request);
	public abstract BooleanResponse existsSource(ExistsSourceRequest request);
	public abstract <TDocument> GetResponse<TDocument> get(GetRequest request, Class<TDocument> tDocumentClass);
	public abstract GetScriptResponse getScript(GetScriptRequest request);
	public abstract <TDocument> GetSourceResponse<TDocument> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass);
	public abstract <TDocument> MgetResponse<TDocument> mget(MgetRequest request, Class<TDocument> tDocumentClass);
	public abstract <TDocument> MsearchResponse<TDocument> msearch(MsearchRequest request, Class<TDocument> tDocumentClass);
	public abstract PutScriptResponse putScript(PutScriptRequest request);
	public abstract ReindexResponse reindex(ReindexRequest request);
	public abstract <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass) ;
	public abstract <TDocument> SearchResponse<TDocument> search(SearchRequest request, Class<TDocument> tDocumentClass);
	public abstract SearchMvtResponse searchMvt(SearchMvtRequest request);
	public abstract SearchShardsResponse searchShards(SearchShardsRequest request);
	public abstract <TDocument> SearchTemplateResponse<TDocument> searchTemplate(SearchTemplateRequest request, Class<TDocument> tDocumentClass);
	public abstract <TDocument, TPartialDocument> UpdateResponse<TDocument> update(UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass);
	public abstract UpdateByQueryResponse updateByQuery(UpdateByQueryRequest request);
}
