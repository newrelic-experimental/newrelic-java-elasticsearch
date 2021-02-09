package com.nr.instrumentation.elasticsearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.elasticsearch.transport.TransportRequest;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

public class MessageHeaders implements Headers {

	TransportRequest  request;
	
	public MessageHeaders(TransportRequest r) {
		request = r;
	}
	
	@Override
	public HeaderType getHeaderType() {
		return HeaderType.MESSAGE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getHeader(String name) {
		
		Object val = request.getHeader(name);
		if(val instanceof String) {
			return (String)val;
		} else if(val instanceof List) {
			List<Object> list = (List<Object>)val;
			if(!list.isEmpty()) {
				return list.get(0).toString();
			}
		} else if(val instanceof Collection) {
			Collection<Object> set = (Collection<Object>)val;
			if(!set.isEmpty()) {
				return set.iterator().next().toString();
			}
		}
		
		return request.getHeader(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> getHeaders(String name) {
		Object value = request.getHeader(name);
		if(value == null) return null;
		
		if(value instanceof String) {
			String val = (String)value;
			return Collections.singletonList(val);		
		}
		
		if(value instanceof Collection) {
			Collection<Object> coll = (Collection<Object>)value;
			List<String> list = new ArrayList<String>();
			for(Object val : coll) {
				list.add(val.toString());
			}
			return list;
		}
		
		return null;
	}

	@Override
	public void setHeader(String name, String value) {
		request.putHeader(name, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addHeader(String name, String value) {
		if(request.hasHeader(name)) {
			Object val = request.getHeader(name);
			if(val instanceof String) {
				List<String> list = new ArrayList<String>();
				list.add(value);
				list.add((String)val);
				request.putHeader(name, list);
			} else if(val instanceof Collection) {
				Collection<Object> coll = (Collection<Object>)val;
				coll.add(value);
				request.putInContext(name, coll);
			} else {
				request.putHeader(name, value);
			}
			
		} else {
			request.putHeader(name, value);
		}
	}

	@Override
	public Collection<String> getHeaderNames() {
		return request.getHeaders();
	}

	@Override
	public boolean containsHeader(String name) {
		return request.hasHeader(name);
	}

}
