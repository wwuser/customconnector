
package org.mule.modules.exchange.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.exchange.ExchangeConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>ExchangeConnectorProcessAdapter</code> is a wrapper around {@link ExchangeConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-04T07:14:23+05:30", comments = "Build UNNAMED.2039.0541b23")
public abstract class ExchangeConnectorProcessAdapter
    extends ExchangeConnectorLifecycleAdapter
    implements ProcessAdapter<ExchangeConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, ExchangeConnectorCapabilitiesAdapter> getProcessTemplate() {
        final ExchangeConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,ExchangeConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, ExchangeConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, ExchangeConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
