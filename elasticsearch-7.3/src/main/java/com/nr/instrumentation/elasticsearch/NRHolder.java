package com.nr.instrumentation.elasticsearch;

import java.util.HashMap;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Token;

public class NRHolder {

	private static HashMap<Integer, Token> tokenCache = new HashMap<Integer, Token>();
	private static HashMap<Integer, Segment> segmentCache = new HashMap<Integer, Segment>();
	private static HashMap<Integer, DatastoreParameters> paramsCache = new HashMap<Integer, DatastoreParameters>();
	
	public static void putToken(Integer hash, Token t) {
		tokenCache.put(hash, t);
	}

	public static void putSegment(Integer hash, Segment s) {
		segmentCache.put(hash, s);
	}
	
	public static void putParams(Integer hash, DatastoreParameters p) {
		paramsCache.put(hash, p);
	}
	
	public static Token getToken(Integer hash) {
		Token t = tokenCache.remove(hash);
		return t;
	}

	public static Segment getSegment(Integer hash) {
		Segment s = segmentCache.remove(hash);
		return s;
	}

	public static DatastoreParameters getParams(Integer hash) {
		DatastoreParameters p = paramsCache.remove(hash);
		return p;
	}
	
}
