package com.newrelic.instrumentation.labs.esrestclient;

import java.util.logging.Level;

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
        Segment segment = NewRelic.getAgent()
                .getTransaction()
                .startSegment("ElasticsearchRequest", request.getMethod());
        String payload = null;
        String endPoint = request.getEndpoint();

        try {
            Utils.logRequestAttributes(request);

            if (Utils.isPayloadApplicable(request.getMethod())) {
                payload = Utils.getPayloadSafely(request);
            }

            // Utils.logPayload(payload);

            if (endPoint != null && !endPoint.isEmpty()) {
                NewRelic.getAgent()
                        .getTracedMethod()
                        .setMetricName("Custom", "ES", "RestClient", getClass().getSimpleName(), "performRequest",
                                endPoint);
            } else {
                NewRelic.getAgent()
                        .getTracedMethod()
                        .setMetricName("Custom", "ES", "RestClient", getClass().getSimpleName(), "performRequest");
            }

            String sql = Utils.constructSql(endPoint, payload);
            String queryToSend = sql;

            if (null != sql) {

                int sqlLength = sql.length();
                String queryPart = "";

                if (sqlLength > 4094) {

                    queryPart = sql.substring(0, 4093);
                    queryToSend = queryPart;
                    // Utils.logPayload(sql);
                    Utils.logSqlQueryAttributes(segment, sql.substring(4093), 255); // SQL Truncation
                }

            }
            segment.reportAsExternal(DatastoreParameters.product("Elasticsearch")
                    .collection(Utils.extractIndex(endPoint))
                    .operation(request.getMethod())
                    .noInstance()
                    .noDatabaseName()
                    .slowQuery(queryToSend, new ESQueryConverter())
                    .build());

            return Weaver.callOriginal();
        } finally {
            segment.end();
        }
    }

    @Trace(dispatcher = true)

    public Cancellable performRequestAsync(Request request, ResponseListener responseListener) {
        // Start a segment for the asynchronous request
        Segment segment = NewRelic.getAgent()
                .getTransaction()
                .startSegment("ElasticsearchRequestAsync", request.getMethod());

        try {
            // Log request attributes for traceability
            Utils.logRequestAttributes(request);

            // Determine if payload logging is applicable
            String payload = null;
            if (Utils.isPayloadApplicable(request.getMethod())) {
                payload = Utils.getPayloadSafely(request);
            }

            // Log the payload
            // Utils.logPayload(payload);

            // Set metric name for the transaction
            String endPoint = request.getEndpoint();
            if (endPoint != null && !endPoint.isEmpty()) {
                NewRelic.getAgent()
                        .getTracedMethod()
                        .setMetricName("Custom", "ES", "RestClient", getClass().getSimpleName(), "performRequestAsync",
                                endPoint);
            } else {
                NewRelic.getAgent()
                        .getTracedMethod()
                        .setMetricName("Custom", "ES", "RestClient", getClass().getSimpleName(), "performRequestAsync");
            }

            // Construct SQL-like query for slow query logging
            String sql = Utils.constructSql(endPoint, payload);
            String queryToSend = sql;

            if (null != sql) {

                int sqlLength = sql.length();
                String queryPart = "";

                if (sqlLength > 4094) {

                    queryPart = sql.substring(0, 4093);
                    queryToSend = queryPart;
                    // Utils.logPayload(sql);
                    Utils.logSqlQueryAttributes(segment, sql.substring(4093), 255); // SQL Truncation
                }

            }
            // Create datastore parameters for the request
            DatastoreParameters params = DatastoreParameters.product("Elasticsearch")
                    .collection(Utils.extractIndex(endPoint))
                    .operation(request.getMethod())
                    .noInstance()
                    .noDatabaseName()
                    .slowQuery(queryToSend, new ESQueryConverter())
                    .build();

            // Store parameters for asynchronous processing
            int hash = responseListener.hashCode();
            NRHolder.putParams(hash, params);
            NRHolder.putSegment(hash, segment);
            NRHolder.putToken(hash, NewRelic.getAgent().getTransaction().getToken());

            // Call the original method with the wrapped listener
            return Weaver.callOriginal();
        } catch (Exception e) {
            // Ensure segment is ended in case of an exception before async call
            segment.end();
            NewRelic.getAgent().getLogger().log(Level.FINER, "Exception performRequestAsync: " + e.getMessage());
            throw e;
        }

    }

}
