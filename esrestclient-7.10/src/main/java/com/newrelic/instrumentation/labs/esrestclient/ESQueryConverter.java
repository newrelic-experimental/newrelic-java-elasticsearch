package com.newrelic.instrumentation.labs.esrestclient;

import com.newrelic.api.agent.QueryConverter;

public class ESQueryConverter implements QueryConverter<String> {

  @Override
  public String toRawQueryString(String rawQuery) {
    return rawQuery;
  }

  @Override
  /**
   * Always obfuscate the id
   */
  public String toObfuscatedQueryString(String rawQuery) {

    return rawQuery.replaceAll("\"_id\":\"[^\"]+\"", "\"_id\":\"?\"");
  }

}
