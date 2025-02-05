package com.newrelic.instrumentation.labs.esrestclient;


import java.util.HashMap;
import java.util.Map;
import org.elasticsearch.client.Request;
import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;

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


  public static DatastoreParameters createDatastoreParams(String operation, String index,
      String query) {
    return DatastoreParameters.product("Elasticsearch").collection(index).operation(operation)
        .instance("localhost", 9200) // Adjust host and port as necessary
        .noDatabaseName().slowQuery(query, new ESQueryConverter()).build();
  }

  public static void logRequestAttributes(Object request) {
    Map<String, Object> attributes = new HashMap<>();
    addRequestAttributes(attributes, request);
    NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
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
}
