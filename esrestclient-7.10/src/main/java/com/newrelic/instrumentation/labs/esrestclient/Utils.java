package com.newrelic.instrumentation.labs.esrestclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.elasticsearch.client.Request;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;

public class Utils {

    public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
        if (key != null && !key.isEmpty() && value != null) {
            attributes.put(key, value);
        }
    }

    public static void addRequestAttributes(Map<String, Object> attributes, Object request) {
        if (request instanceof Request) {
            Request req = (Request) request;
            // Add attributes directly from the Request object
            addAttribute(attributes, "Request-Method", req.getMethod());
            addAttribute(attributes, "Request-Endpoint", req.getEndpoint());

            // Add parameters if present
            if (!req.getParameters().isEmpty()) {
                addAttribute(attributes, "Request-Parameters", req.getParameters().toString());
            }

            // Add entity if present
            if (req.getEntity() != null) {
                addAttribute(attributes, "Request-Entity", req.getEntity().toString());
            }

            // Add options
            addAttribute(attributes, "Request-Options", req.getOptions().toString());
        }

        // System.out.println(attributes);
    }

    public static DatastoreParameters createDatastoreParams(String operation, String index, String query) {
        return DatastoreParameters.product("Elasticsearch")
                .collection(index)
                .operation(operation)
                .instance("localhost", 9200) // Adjust host and port as necessary
                .noDatabaseName()
                .slowQuery(query, new ESQueryConverter())
                .build();
    }

    public static void logRequestAttributes(Object request) {
        Map<String, Object> attributes = new HashMap<>();
        addRequestAttributes(attributes, request);
        NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
    }

    public static void logSqlQueryAttributes(Segment segment, String sqlQuery, int size) {
        Map<String, Object> attributes = new HashMap<>();

        // Break the SQL query into parts if it exceeds the specified size
        int queryLength = sqlQuery.length();
        int partNumber = 1;
        if (queryLength > size) {
            for (int i = 0; i < queryLength; i += size) {
                int end = Math.min(i + size, queryLength);
                String queryPart = sqlQuery.substring(i, end);
                attributes.put("query_part_" + partNumber, queryPart);
                partNumber++;
            }

            // Add the custom attributes to the traced method
            segment.addCustomAttributes(attributes);
        }
    }

    public static String extractIndex(String input) {
        if (input == null || input.isEmpty()) {
            return "noindex"; // or throw an exception based on your use case
        }

        int underscoreIndex = input.indexOf('_');
        if (underscoreIndex == -1) {
            return "noindex"; // or handle the case where there's no underscore
        }

        return input.substring(0, underscoreIndex);
    }

    public static String getPayloadAsString(HttpEntity entity) throws IOException {
        if (entity == null) {
            return null;
        }

        try (InputStream inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder payload = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                payload.append(line);
            }
            return payload.toString();
        }
    }

    public static boolean isPayloadApplicable(String method) {
        return "POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method);
    }

    public static String getPayloadSafely(Request request) {
        try {
            return Utils.getPayloadAsString(request.getEntity());
        } catch (UnsupportedOperationException | IOException e) {
            // Log exception if needed
            return null;
        }
    }

    public static void logPayload(String payload) {
        if (payload != null) {
            System.out.println(payload);
        }
    }

    public static String constructSql(String endpoint, String payload) {
        if (endpoint != null && payload != null) {
            return endpoint + " \n" + payload;
        }
        return endpoint;
    }
}
