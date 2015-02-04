
package org.mule.modules.exchange.connectivity;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.exchange.adapters.ExchangeConnectorConnectionIdentifierAdapter;
import org.mule.modules.exchange.connection.ConnectionManager;
import org.mule.modules.exchange.process.ExchangeConnectorManagedConnectionProcessInterceptor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.process.ProcessCallbackProcessInterceptor;
import org.mule.security.oauth.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-04T07:14:23+05:30", comments = "Build UNNAMED.2039.0541b23")
public class ExchangeConnectorManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, ExchangeConnectorConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, ExchangeConnectorConnectionIdentifierAdapter> processInterceptor;

    public ExchangeConnectorManagedConnectionProcessTemplate(ConnectionManager<ExchangeConnectorConnectionKey, ExchangeConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, ExchangeConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, ExchangeConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, ExchangeConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new ExchangeConnectorManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, ExchangeConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, ExchangeConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, ExchangeConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, ExchangeConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
