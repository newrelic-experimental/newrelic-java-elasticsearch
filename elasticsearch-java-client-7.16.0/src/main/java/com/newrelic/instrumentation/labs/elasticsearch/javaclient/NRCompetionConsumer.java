package com.newrelic.instrumentation.labs.elasticsearch.javaclient;

import java.util.function.BiConsumer;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;

public class NRCompetionConsumer<T> implements BiConsumer<T, Throwable> {
	
	private Segment segment = null;
	private DatastoreParameters params = null;
	
	public NRCompetionConsumer(String segmentName, DatastoreParameters p) {
		segment = NewRelic.getAgent().getTransaction().startSegment(segmentName);
		params = p;
	}

	@Override
	public void accept(T t, Throwable u) {
		if(t != null) {
			if(segment != null) {
				if(params != null) {
					segment.reportAsExternal(params);
				}
				segment.end();
				segment = null;
			}
		} else if(u != null) {
			NewRelic.noticeError(u);
			if(segment != null) {
				segment.ignore();
				segment = null;
			}
		}
	}


}
