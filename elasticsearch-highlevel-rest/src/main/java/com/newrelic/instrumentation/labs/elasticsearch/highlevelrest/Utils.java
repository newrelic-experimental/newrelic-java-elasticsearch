package com.newrelic.instrumentation.labs.elasticsearch.highlevelrest;

import java.util.List;

public class Utils {

	public static String getObjectString(Object obj) {
		
		if(obj instanceof String) {
			return (String)obj;
		}
		if(obj instanceof List) {
			List<?> list = (List<?>)obj;
			int size = list.size();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<size;i++) {
				sb.append(list.get(i).toString());
				if(i < size-1) {
					sb.append(',');
				}
			}
			return sb.toString();
		}
		
		return null;
	}

}
