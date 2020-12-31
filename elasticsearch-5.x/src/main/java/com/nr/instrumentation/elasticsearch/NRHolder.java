package com.nr.instrumentation.elasticsearch;

import java.util.HashMap;
import java.util.logging.Level;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Token;

public class NRHolder {

	private static HashMap<Integer, Token> tokenCache = new HashMap<Integer, Token>();
	private static HashMap<Integer, Segment> segmentCache = new HashMap<Integer, Segment>();
	private static HashMap<Integer, DatastoreParameters> paramsCache = new HashMap<Integer, DatastoreParameters>();
	
	public static void putToken(Integer hash, Token t) {
		NewRelic.getAgent().getLogger().log(Level.FINE, "Putting token for hash {0}: {1}", hash,t);
		tokenCache.put(hash, t);
	}

	public static void putSegment(Integer hash, Segment s) {
		NewRelic.getAgent().getLogger().log(Level.FINE, "Putting segment for hash {0}: {1}", hash,s);
		segmentCache.put(hash, s);
	}
	
	public static void putParams(Integer hash, DatastoreParameters p) {
		NewRelic.getAgent().getLogger().log(Level.FINE, "Putting params for hash {0}: {1}", hash,p);
		paramsCache.put(hash, p);
	}
	
	public static Token getToken(Integer hash) {
		Token t = tokenCache.remove(hash);
		NewRelic.getAgent().getLogger().log(Level.FINE, "Retrieved token for hash {0}: {1}", hash,t);
		return t;
	}

	public static Segment getSegment(Integer hash) {
		Segment s = segmentCache.remove(hash);
		NewRelic.getAgent().getLogger().log(Level.FINE, "Retrieved segment for hash {0}: {1}", hash,s);
		return s;
	}

	public static DatastoreParameters getParams(Integer hash) {
		DatastoreParameters p = paramsCache.remove(hash);
		NewRelic.getAgent().getLogger().log(Level.FINE, "Retrieved params for hash {0}: {1}", hash,p);
		return p;
	}
	
}
