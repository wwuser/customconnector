
package org.mule.modules.exchange.adapters;

import javax.annotation.Generated;
import org.mule.modules.exchange.ExchangeConnector;
import org.mule.modules.exchange.connection.Connection;


/**
 * A <code>ExchangeConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link ExchangeConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-04T07:14:23+05:30", comments = "Build UNNAMED.2039.0541b23")
public abstract class ExchangeConnectorConnectionIdentifierAdapter
    extends ExchangeConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
