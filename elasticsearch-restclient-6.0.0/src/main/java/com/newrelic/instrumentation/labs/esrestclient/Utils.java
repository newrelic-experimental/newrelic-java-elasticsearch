package com.newrelic.instrumentation.labs.esrestclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.http.HttpEntity;

import com.newrelic.api.agent.DatastoreParameters;

public class Utils {

    public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
        if (key != null && !key.isEmpty() && value != null) {
            attributes.put(key, value);
        }
    }
    
    public static void addMap(Map<String, Object> attributes, Map<String,String> toAdd) {
    	if(attributes != null) {
    		attributes.putAll(toAdd);
    	}
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

    public static String getPayloadSafely(HttpEntity entity) {
        try {
            return Utils.getPayloadAsString(entity);
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
