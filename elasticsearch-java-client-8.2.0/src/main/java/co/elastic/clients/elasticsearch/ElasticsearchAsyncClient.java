package co.elastic.clients.elasticsearch;

import com.newrelic.api.agent.weaver.Weave;

@Weave
public abstract class ElasticsearchAsyncClient {

	/**
	 * See ElasticsearachClient and instrument the same methods.  The difference is that
	 * these methods return a CompletableFuture so we need to handle the async behavior.
	 * 
	 *  
	 * To do this create a custom New Relic BiConsumer <T, Throwable>  which contains a Segment which is ended in
	 * its accept method.  report the exception if the Throwable input is not null.
	 * 
	 * Instrument these methods and create a DataStoreParameters object to report as external
	 *  using xxxxxx from the input xxxxxxRequest as the operation name
	 *  for most of the requests we should be able to use the index() value
	 * 
	 * Example
	 * public CompletableFuture<DeleteResponse> delete(DeleteRequest request) {
	 * 		... setup of DataStoreParameters as done in ElasticsearchClient  ...
	 * 		NRBiConsumer<DeleteResponse> consumer = new NRBiConsumer<DeleteResponse>();
	 * 		CompletableFuture<DeleteResponse> result = Weaver.callOriginal();
	 * 
	 * 		return result.whenComplete(consumer);
	 * }
	 * 
	 * 
	 */
//
//	public <TSource> CompletableFuture<BulkResponse> bulk(BulkRequest<TSource> request) {
//		CompletableFuture<BulkResponse> future = Weaver.callOriginal();
//		NRCompetionConsumer<BulkResponse> completionListener = new NRCompetionConsumer<BulkResponse>(request.getClass().getSimpleName(), Utils.getParams("Bulk", request.index(), null, null, null));
//		return future.whenComplete(completionListener);
//	}
//
//	/**
//	 * Allows to perform multiple index/update/delete operations in a single
//	 * request.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-bulk.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TSource> CompletableFuture<BulkResponse> bulk(
//			Function<BulkRequest.Builder<TSource>, ObjectBuilder<BulkRequest<TSource>>> fn) {
//		return bulk(fn.apply(new BulkRequest.Builder<TSource>()).build());
//	}
//
//	// ----- Endpoint: clear_scroll
//
//	/**
//	 * Explicitly clears the search context for a scroll.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/clear-scroll-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request) {
//		return this.transport.performRequestAsync(request, ClearScrollRequest.ENDPOINT);
//	}
//
//	/**
//	 * Explicitly clears the search context for a scroll.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/clear-scroll-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<ClearScrollResponse> clearScroll(
//			Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn) {
//		return clearScroll(fn.apply(new ClearScrollRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: close_point_in_time
//
//	/**
//	 * Close a point in time
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<ClosePointInTimeResponse> closePointInTime(ClosePointInTimeRequest request)
//			{
//		return this.transport.performRequestAsync(request, ClosePointInTimeRequest.ENDPOINT);
//	}
//
//	/**
//	 * Close a point in time
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<ClosePointInTimeResponse> closePointInTime(
//			Function<ClosePointInTimeRequest.Builder, ObjectBuilder<ClosePointInTimeRequest>> fn) {
//		return closePointInTime(fn.apply(new ClosePointInTimeRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: count
//
//	/**
//	 * Returns number of documents matching a query.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-count.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<CountResponse> count(CountRequest request) {
//		return this.transport.performRequestAsync(request, CountRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns number of documents matching a query.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-count.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<CountResponse> count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn)
//			{
//		return count(fn.apply(new CountRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: create
//
//	/**
//	 * Creates a new document in the index.
//	 * <p>
//	 * Returns a 409 response when a document with a same ID already exists in the
//	 * index.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<CreateResponse> create(CreateRequest<TDocument> request) {
//		return this.transport.performRequestAsync(request, CreateRequest.ENDPOINT);
//	}
//
//	/**
//	 * Creates a new document in the index.
//	 * <p>
//	 * Returns a 409 response when a document with a same ID already exists in the
//	 * index.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<CreateResponse> create(
//			Function<CreateRequest.Builder<TDocument>, ObjectBuilder<CreateRequest<TDocument>>> fn) {
//		return create(fn.apply(new CreateRequest.Builder<TDocument>()).build());
//	}
//
//	// ----- Endpoint: delete
//
//	/**
//	 * Removes a document from the index.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<DeleteResponse> delete(DeleteRequest request) {
//		return this.transport.performRequestAsync(request, DeleteRequest.ENDPOINT);
//	}
//
//	/**
//	 * Removes a document from the index.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<DeleteResponse> delete(
//			Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn) {
//		return delete(fn.apply(new DeleteRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: delete_by_query
//
//	/**
//	 * Deletes documents matching the provided query.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<DeleteByQueryResponse> deleteByQuery(DeleteByQueryRequest request) {
//		return this.transport.performRequestAsync(request, DeleteByQueryRequest.ENDPOINT);
//	}
//
//	/**
//	 * Deletes documents matching the provided query.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<DeleteByQueryResponse> deleteByQuery(
//			Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn) {
//		return deleteByQuery(fn.apply(new DeleteByQueryRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: delete_by_query_rethrottle
//
//	/**
//	 * Changes the number of requests per second for a particular Delete By Query
//	 * operation.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-delete-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(
//			DeleteByQueryRethrottleRequest request) {
//		return this.transport.performRequestAsync(request, DeleteByQueryRethrottleRequest.ENDPOINT);
//	}
//
//	/**
//	 * Changes the number of requests per second for a particular Delete By Query
//	 * operation.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-delete-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(
//			Function<DeleteByQueryRethrottleRequest.Builder, ObjectBuilder<DeleteByQueryRethrottleRequest>> fn)
//			{
//		return deleteByQueryRethrottle(fn.apply(new DeleteByQueryRethrottleRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: delete_script
//
//	/**
//	 * Deletes a script.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<DeleteScriptResponse> deleteScript(DeleteScriptRequest request) {
//		return this.transport.performRequestAsync(request, DeleteScriptRequest.ENDPOINT);
//	}
//
//	/**
//	 * Deletes a script.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<DeleteScriptResponse> deleteScript(
//			Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn) {
//		return deleteScript(fn.apply(new DeleteScriptRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: exists
//
//	/**
//	 * Returns information about whether a document exists in an index.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<BooleanResponse> exists(ExistsRequest request) {
//		return this.transport.performRequestAsync(request, ExistsRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns information about whether a document exists in an index.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<BooleanResponse> exists(
//			Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn) {
//		return exists(fn.apply(new ExistsRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: exists_source
//
//	/**
//	 * Returns information about whether a document source exists in an index.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<BooleanResponse> existsSource(ExistsSourceRequest request) {
//		return this.transport.performRequestAsync(request, ExistsSourceRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns information about whether a document source exists in an index.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<BooleanResponse> existsSource(
//			Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn) {
//		return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: explain
//
//	/**
//	 * Returns information about why a specific matches (or doesn't match) a query.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-explain.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(ExplainRequest request,
//			Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				ExplainRequest.createExplainEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Returns information about why a specific matches (or doesn't match) a query.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-explain.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(
//			Function<ExplainRequest.Builder, ObjectBuilder<ExplainRequest>> fn, Class<TDocument> tDocumentClass)
//			{
//		return explain(fn.apply(new ExplainRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: field_caps
//
//	/**
//	 * Returns the information about the capabilities of fields among multiple
//	 * indices.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-field-caps.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<FieldCapsResponse> fieldCaps(FieldCapsRequest request) {
//		return this.transport.performRequestAsync(request, FieldCapsRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns the information about the capabilities of fields among multiple
//	 * indices.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-field-caps.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<FieldCapsResponse> fieldCaps(
//			Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn) {
//		return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: get
//
//	/**
//	 * Returns a document.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<GetResponse<TDocument>> get(GetRequest request,
//			Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				GetRequest.createGetEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Returns a document.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<GetResponse<TDocument>> get(
//			Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn, Class<TDocument> tDocumentClass)
//			{
//		return get(fn.apply(new GetRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: get_script
//
//	/**
//	 * Returns a script.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<GetScriptResponse> getScript(GetScriptRequest request) {
//		return this.transport.performRequestAsync(request, GetScriptRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns a script.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<GetScriptResponse> getScript(
//			Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn) {
//		return getScript(fn.apply(new GetScriptRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: get_script_context
//
//	/**
//	 * Returns all script contexts.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/painless/master/painless-contexts.html">Documentation
//	 *      on elastic.co</a>
//	 */
//	public CompletableFuture<GetScriptContextResponse> getScriptContext() {
//		return this.transport.performRequestAsync(GetScriptContextRequest._INSTANCE, GetScriptContextRequest.ENDPOINT);
//	}
//
//	// ----- Endpoint: get_script_languages
//
//	/**
//	 * Returns available script types, languages and contexts
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html">Documentation
//	 *      on elastic.co</a>
//	 */
//	public CompletableFuture<GetScriptLanguagesResponse> getScriptLanguages() {
//		return this.transport.performRequestAsync(GetScriptLanguagesRequest._INSTANCE,
//				GetScriptLanguagesRequest.ENDPOINT);
//	}
//
//	// ----- Endpoint: get_source
//
//	/**
//	 * Returns the source of a document.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(GetSourceRequest request,
//			Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				GetSourceRequest.createGetSourceEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Returns the source of a document.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(
//			Function<GetSourceRequest.Builder, ObjectBuilder<GetSourceRequest>> fn, Class<TDocument> tDocumentClass)
//			{
//		return getSource(fn.apply(new GetSourceRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: index
//
//	/**
//	 * Creates or updates a document in an index.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<IndexResponse> index(IndexRequest<TDocument> request) {
//		return this.transport.performRequestAsync(request, IndexRequest.ENDPOINT);
//	}
//
//	/**
//	 * Creates or updates a document in an index.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<IndexResponse> index(
//			Function<IndexRequest.Builder<TDocument>, ObjectBuilder<IndexRequest<TDocument>>> fn) {
//		return index(fn.apply(new IndexRequest.Builder<TDocument>()).build());
//	}
//
//	// ----- Endpoint: info
//
//	/**
//	 * Returns basic information about the cluster.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html">Documentation
//	 *      on elastic.co</a>
//	 */
//	public CompletableFuture<InfoResponse> info() {
//		return this.transport.performRequestAsync(InfoRequest._INSTANCE, InfoRequest.ENDPOINT);
//	}
//
//	// ----- Endpoint: mget
//
//	/**
//	 * Allows to get multiple documents in one request.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<MgetResponse<TDocument>> mget(MgetRequest request,
//			Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				MgetRequest.createMgetEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Allows to get multiple documents in one request.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-get.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<MgetResponse<TDocument>> mget(
//			Function<MgetRequest.Builder, ObjectBuilder<MgetRequest>> fn, Class<TDocument> tDocumentClass)
//			{
//		return mget(fn.apply(new MgetRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: msearch
//
//	/**
//	 * Allows to execute several search operations in one request.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-multi-search.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<MsearchResponse<TDocument>> msearch(MsearchRequest request,
//			Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				MsearchRequest.createMsearchEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Allows to execute several search operations in one request.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-multi-search.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<MsearchResponse<TDocument>> msearch(
//			Function<MsearchRequest.Builder, ObjectBuilder<MsearchRequest>> fn, Class<TDocument> tDocumentClass)
//			{
//		return msearch(fn.apply(new MsearchRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: msearch_template
//
//	/**
//	 * Allows to execute several search template operations in one request.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-multi-search.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<MsearchTemplateResponse<TDocument>> msearchTemplate(
//			MsearchTemplateRequest request, Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				MsearchTemplateRequest.createMsearchTemplateEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Allows to execute several search template operations in one request.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-multi-search.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<MsearchTemplateResponse<TDocument>> msearchTemplate(
//			Function<MsearchTemplateRequest.Builder, ObjectBuilder<MsearchTemplateRequest>> fn,
//			Class<TDocument> tDocumentClass) {
//		return msearchTemplate(fn.apply(new MsearchTemplateRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: mtermvectors
//
//	/**
//	 * Returns multiple termvectors in one request.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-termvectors.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<MtermvectorsResponse> mtermvectors(MtermvectorsRequest request) {
//		return this.transport.performRequestAsync(request, MtermvectorsRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns multiple termvectors in one request.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-termvectors.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<MtermvectorsResponse> mtermvectors(
//			Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn) {
//		return mtermvectors(fn.apply(new MtermvectorsRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: open_point_in_time
//
//	/**
//	 * Open a point in time that can be used in subsequent searches
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<OpenPointInTimeResponse> openPointInTime(OpenPointInTimeRequest request)
//			{
//		return this.transport.performRequestAsync(request, OpenPointInTimeRequest.ENDPOINT);
//	}
//
//	/**
//	 * Open a point in time that can be used in subsequent searches
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<OpenPointInTimeResponse> openPointInTime(
//			Function<OpenPointInTimeRequest.Builder, ObjectBuilder<OpenPointInTimeRequest>> fn) {
//		return openPointInTime(fn.apply(new OpenPointInTimeRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: ping
//
//	/**
//	 * Returns whether the cluster is running.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html">Documentation
//	 *      on elastic.co</a>
//	 */
//	public CompletableFuture<BooleanResponse> ping() {
//		return this.transport.performRequestAsync(PingRequest._INSTANCE, PingRequest.ENDPOINT);
//	}
//
//	// ----- Endpoint: put_script
//
//	/**
//	 * Creates or updates a script.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<PutScriptResponse> putScript(PutScriptRequest request) {
//		return this.transport.performRequestAsync(request, PutScriptRequest.ENDPOINT);
//	}
//
//	/**
//	 * Creates or updates a script.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<PutScriptResponse> putScript(
//			Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn) {
//		return putScript(fn.apply(new PutScriptRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: rank_eval
//
//	/**
//	 * Allows to evaluate the quality of ranked search results over a set of typical
//	 * search queries
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-rank-eval.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<RankEvalResponse> rankEval(RankEvalRequest request) {
//		return this.transport.performRequestAsync(request, RankEvalRequest.ENDPOINT);
//	}
//
//	/**
//	 * Allows to evaluate the quality of ranked search results over a set of typical
//	 * search queries
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-rank-eval.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<RankEvalResponse> rankEval(
//			Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn) {
//		return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: reindex
//
//	/**
//	 * Allows to copy documents from one index to another, optionally filtering the
//	 * source documents by a query, changing the destination index settings, or
//	 * fetching the documents from a remote cluster.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<ReindexResponse> reindex(ReindexRequest request) {
//		return this.transport.performRequestAsync(request, ReindexRequest.ENDPOINT);
//	}
//
//	/**
//	 * Allows to copy documents from one index to another, optionally filtering the
//	 * source documents by a query, changing the destination index settings, or
//	 * fetching the documents from a remote cluster.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<ReindexResponse> reindex(
//			Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn) {
//		return reindex(fn.apply(new ReindexRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: reindex_rethrottle
//
//	/**
//	 * Changes the number of requests per second for a particular Reindex operation.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(ReindexRethrottleRequest request)
//			{
//		return this.transport.performRequestAsync(request, ReindexRethrottleRequest.ENDPOINT);
//	}
//
//	/**
//	 * Changes the number of requests per second for a particular Reindex operation.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(
//			Function<ReindexRethrottleRequest.Builder, ObjectBuilder<ReindexRethrottleRequest>> fn) {
//		return reindexRethrottle(fn.apply(new ReindexRethrottleRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: scripts_painless_execute
//
//	/**
//	 * Allows an arbitrary script to be executed and a result to be returned
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/painless/master/painless-execute-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
//			ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass) {
//		return this.transport.performRequestAsync(request,
//				ScriptsPainlessExecuteRequest.createScriptsPainlessExecuteEndpoint(getDeserializer(tResultClass)));
//	}
//
//	/**
//	 * Allows an arbitrary script to be executed and a result to be returned
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/painless/master/painless-execute-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
//			Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn,
//			Class<TResult> tResultClass) {
//		return scriptsPainlessExecute(fn.apply(new ScriptsPainlessExecuteRequest.Builder()).build(), tResultClass);
//	}
//
//	// ----- Endpoint: search
//
//	/**
//	 * Returns results matching a query.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-search.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<SearchResponse<TDocument>> search(SearchRequest request,
//			Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				SearchRequest.createSearchEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Returns results matching a query.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-search.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<SearchResponse<TDocument>> search(
//			Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn, Class<TDocument> tDocumentClass)
//			{
//		return search(fn.apply(new SearchRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: search_mvt
//
//	/**
//	 * Searches a vector tile for geospatial values. Returns results as a binary
//	 * Mapbox vector tile.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-vector-tile-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<SearchMvtResponse> searchMvt(SearchMvtRequest request) {
//		return this.transport.performRequestAsync(request, SearchMvtRequest.ENDPOINT);
//	}
//
//	/**
//	 * Searches a vector tile for geospatial values. Returns results as a binary
//	 * Mapbox vector tile.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-vector-tile-api.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<SearchMvtResponse> searchMvt(
//			Function<SearchMvtRequest.Builder, ObjectBuilder<SearchMvtRequest>> fn) {
//		return searchMvt(fn.apply(new SearchMvtRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: search_shards
//
//	/**
//	 * Returns information about the indices and shards that a search request would
//	 * be executed against.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-shards.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<SearchShardsResponse> searchShards(SearchShardsRequest request) {
//		return this.transport.performRequestAsync(request, SearchShardsRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns information about the indices and shards that a search request would
//	 * be executed against.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-shards.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<SearchShardsResponse> searchShards(
//			Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn) {
//		return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: search_template
//
//	/**
//	 * Allows to use the Mustache language to pre-render a search definition.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-template.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
//			SearchTemplateRequest request, Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				SearchTemplateRequest.createSearchTemplateEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Allows to use the Mustache language to pre-render a search definition.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-template.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
//			Function<SearchTemplateRequest.Builder, ObjectBuilder<SearchTemplateRequest>> fn,
//			Class<TDocument> tDocumentClass) {
//		return searchTemplate(fn.apply(new SearchTemplateRequest.Builder()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: terms_enum
//
//	/**
//	 * The terms enum API can be used to discover terms in the index that begin with
//	 * the provided string. It is designed for low-latency look-ups used in
//	 * auto-complete scenarios.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-terms-enum.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<TermsEnumResponse> termsEnum(TermsEnumRequest request) {
//		return this.transport.performRequestAsync(request, TermsEnumRequest.ENDPOINT);
//	}
//
//	/**
//	 * The terms enum API can be used to discover terms in the index that begin with
//	 * the provided string. It is designed for low-latency look-ups used in
//	 * auto-complete scenarios.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-terms-enum.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<TermsEnumResponse> termsEnum(
//			Function<TermsEnumRequest.Builder, ObjectBuilder<TermsEnumRequest>> fn) {
//		return termsEnum(fn.apply(new TermsEnumRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: termvectors
//
//	/**
//	 * Returns information and statistics about terms in the fields of a particular
//	 * document.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-termvectors.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument> CompletableFuture<TermvectorsResponse> termvectors(TermvectorsRequest<TDocument> request)
//			{
//		return this.transport.performRequestAsync(request, TermvectorsRequest.ENDPOINT);
//	}
//
//	/**
//	 * Returns information and statistics about terms in the fields of a particular
//	 * document.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-termvectors.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument> CompletableFuture<TermvectorsResponse> termvectors(
//			Function<TermvectorsRequest.Builder<TDocument>, ObjectBuilder<TermvectorsRequest<TDocument>>> fn)
//			{
//		return termvectors(fn.apply(new TermvectorsRequest.Builder<TDocument>()).build());
//	}
//
//	// ----- Endpoint: update
//
//	/**
//	 * Updates a document with a script or partial document.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public <TDocument, TPartialDocument> CompletableFuture<UpdateResponse<TDocument>> update(
//			UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass) {
//		return this.transport.performRequestAsync(request,
//				UpdateRequest.createUpdateEndpoint(getDeserializer(tDocumentClass)));
//	}
//
//	/**
//	 * Updates a document with a script or partial document.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final <TDocument, TPartialDocument> CompletableFuture<UpdateResponse<TDocument>> update(
//			Function<UpdateRequest.Builder<TDocument, TPartialDocument>, ObjectBuilder<UpdateRequest<TDocument, TPartialDocument>>> fn,
//			Class<TDocument> tDocumentClass) {
//		return update(fn.apply(new UpdateRequest.Builder<TDocument, TPartialDocument>()).build(), tDocumentClass);
//	}
//
//	// ----- Endpoint: update_by_query
//
//	/**
//	 * Performs an update on every document in the index without changing the
//	 * source, for example to pick up a mapping change.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<UpdateByQueryResponse> updateByQuery(UpdateByQueryRequest request) {
//		return this.transport.performRequestAsync(request, UpdateByQueryRequest.ENDPOINT);
//	}
//
//	/**
//	 * Performs an update on every document in the index without changing the
//	 * source, for example to pick up a mapping change.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<UpdateByQueryResponse> updateByQuery(
//			Function<UpdateByQueryRequest.Builder, ObjectBuilder<UpdateByQueryRequest>> fn) {
//		return updateByQuery(fn.apply(new UpdateByQueryRequest.Builder()).build());
//	}
//
//	// ----- Endpoint: update_by_query_rethrottle
//
//	/**
//	 * Changes the number of requests per second for a particular Update By Query
//	 * operation.
//	 * 
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-update-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(
//			UpdateByQueryRethrottleRequest request) {
//		return this.transport.performRequestAsync(request, UpdateByQueryRethrottleRequest.ENDPOINT);
//	}
//
//	/**
//	 * Changes the number of requests per second for a particular Update By Query
//	 * operation.
//	 * 
//	 * @param fn
//	 *            a function that initializes a freshly created builder. This
//	 *            function can either return its builder argument after having set
//	 *            its properties or return another builder.
//	 * @see <a href=
//	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-update-by-query.html">Documentation
//	 *      on elastic.co</a>
//	 */
//
//	public final CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(
//			Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn)
//			{
//		return updateByQueryRethrottle(fn.apply(new UpdateByQueryRethrottleRequest.Builder()).build());
//	}

}
