package org.elasticsearch.transport;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class TransportServiceAdapter {

	@Trace(dispatcher=true)
	public void onRequestReceived(long requestId, String action) {
		if(action != null && !action.isEmpty()) {
			NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_LOW, false, "ElasticSearch", "ElasticSearch",action);
		}
		Weaver.callOriginal();
	}
}
