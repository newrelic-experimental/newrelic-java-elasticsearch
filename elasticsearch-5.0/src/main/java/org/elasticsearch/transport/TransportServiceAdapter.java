package org.elasticsearch.transport;

import java.util.HashMap;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.elasticsearch.Utils;

@Weave(type=MatchType.Interface)
public abstract class TransportServiceAdapter {

	@Trace(dispatcher=true)
	public void onRequestReceived(long requestId, String action) {
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		Utils.addAttribute(attributes, "RequestId", requestId);
		Utils.addAttribute(attributes, "Action", action);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(action != null && !action.isEmpty()) {
			NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_LOW, false, "ElasticSearch", "ElasticSearch",action);
		}
		Weaver.callOriginal();
	}
}
