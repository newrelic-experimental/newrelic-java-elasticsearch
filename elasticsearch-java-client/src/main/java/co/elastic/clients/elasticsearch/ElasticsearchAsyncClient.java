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

}
