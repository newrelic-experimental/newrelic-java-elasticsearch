package com.newrelic.instrumentation.labs.esrestclient;

import org.elasticsearch.client.Cancellable;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;


@Weave(originalName = "org.elasticsearch.client.RestClient")
public abstract class RestClient_Instrumentation {

  @Trace(dispatcher = true)
  public Response performRequest(Request request) {
    // Start a segment for the synchronous request
    Segment segment = NewRelic.getAgent().getTransaction().startSegment("ElasticsearchRequest",
        request.getMethod());

    try {
      Utils.logRequestAttributes(request);

      String endPoint = request.getEndpoint();


      if (endPoint != null && !endPoint.isEmpty()) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom", "ES", "RestClient",
            getClass().getSimpleName(), "performRequest", endPoint);
      } else {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom", "ES", "RestClient",
            getClass().getSimpleName(), "performRequest");
      }
      // Log the request as a database call

      segment.reportAsExternal(DatastoreParameters.product("Elasticsearch")
          .collection(Utils.extractIndex(request.getEndpoint())).operation(request.getMethod())
          .noInstance().noDatabaseName().slowQuery(endPoint, new ESQueryConverter()).build());

      // Call the original method
      return Weaver.callOriginal();
    } finally {
      // End the segment
      segment.end();
    }
  }

  @Trace(dispatcher = true)
  public Cancellable performRequestAsync(Request request, ResponseListener responseListener) {
    // Start a segment for the asynchronous request
    Segment segment = NewRelic.getAgent().getTransaction().startSegment("ElasticsearchRequestAsync",
        request.getMethod());

    try {
      // Add custom attributes for better traceability
      Utils.logRequestAttributes(request);

      String endPoint = request.getEndpoint();


      if (endPoint != null && !endPoint.isEmpty()) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom", "ES", "RestClient",
            getClass().getSimpleName(), "performRequestAsync", endPoint);
      } else {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom", "ES", "RestClient",
            getClass().getSimpleName(), "performRequestAsync");
      }

      DatastoreParameters params = DatastoreParameters.product("Elasticsearch")
          .collection(Utils.extractIndex(request.getEndpoint())).operation(request.getMethod())
          .noInstance().noDatabaseName().slowQuery(endPoint, new ESQueryConverter()).build();

      // Log the request as a database call
      int hash = responseListener.hashCode();

      NRHolder.putParams(hash, params);
      NRHolder.putSegment(hash, segment);
      NRHolder.putToken(hash, NewRelic.getAgent().getTransaction().getToken());


      // Call the original method with the wrapped listener
      return Weaver.callOriginal();
    } catch (Exception e) {
      // Ensure segment is ended in case of an exception
      segment.end();
      throw e;
    }
  }
}
