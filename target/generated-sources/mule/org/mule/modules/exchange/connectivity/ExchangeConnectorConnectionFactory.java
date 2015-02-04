
package org.mule.modules.exchange.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.modules.exchange.adapters.ExchangeConnectorRestClientAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-04T07:14:23+05:30", comments = "Build UNNAMED.2039.0541b23")
public class ExchangeConnectorConnectionFactory implements KeyedPoolableObjectFactory
{

    private static Logger logger = LoggerFactory.getLogger(ExchangeConnectorConnectionFactory.class);
    private ExchangeConnectorConnectionManager connectionManager;

    public ExchangeConnectorConnectionFactory(ExchangeConnectorConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Object makeObject(Object key)
        throws Exception
    {
        if (!(key instanceof ExchangeConnectorConnectionKey)) {
            if (key == null) {
                logger.warn("Connection key is null");
            } else {
                logger.warn("Cannot cast key of type ".concat(key.getClass().getName().concat(" to ").concat("org.mule.modules.exchange.connectivity.ExchangeConnectorConnectionKey")));
            }
            throw new RuntimeException("Invalid key type ".concat(key.getClass().getName()));
        }
        ExchangeConnectorRestClientAdapter connector = new ExchangeConnectorRestClientAdapter();
        connector.setCurrencyRate(connectionManager.getCurrencyRate());
        if (connector instanceof MuleContextAware) {
            ((MuleContextAware) connector).setMuleContext(connectionManager.getMuleContext());
        }
        if (connector instanceof Initialisable) {
            ((Initialisable) connector).initialise();
        }
        if (connector instanceof Startable) {
            ((Startable) connector).start();
        }
        if (connector instanceof MuleContextAware) {
            connector.setMuleContext((connectionManager.muleContext));
        }
        if (!connector.isConnected()) {
            connector.connect(((ExchangeConnectorConnectionKey) key).getUsername(), ((ExchangeConnectorConnectionKey) key).getPassword());
        }
        return connector;
    }

    public void destroyObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof ExchangeConnectorConnectionKey)) {
            if (key == null) {
                logger.warn("Connection key is null");
            } else {
                logger.warn("Cannot cast key of type ".concat(key.getClass().getName().concat(" to ").concat("org.mule.modules.exchange.connectivity.ExchangeConnectorConnectionKey")));
            }
            throw new RuntimeException("Invalid key type ".concat(key.getClass().getName()));
        }
        if (!(obj instanceof ExchangeConnectorRestClientAdapter)) {
            if (obj == null) {
                logger.warn("Connector is null");
            } else {
                logger.warn("Cannot cast connector of type ".concat(obj.getClass().getName().concat(" to ").concat("org.mule.modules.exchange.adapters.ExchangeConnectorRestClientAdapter")));
            }
            throw new RuntimeException("Invalid connector type ".concat(obj.getClass().getName()));
        }
        try {
            ((ExchangeConnectorRestClientAdapter) obj).disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            if (((ExchangeConnectorRestClientAdapter) obj) instanceof Stoppable) {
                ((Stoppable) obj).stop();
            }
            if (((ExchangeConnectorRestClientAdapter) obj) instanceof Disposable) {
                ((Disposable) obj).dispose();
            }
        }
    }

    public boolean validateObject(Object key, Object obj) {
        if (!(obj instanceof ExchangeConnectorRestClientAdapter)) {
            if (obj == null) {
                logger.warn("Connector is null");
            } else {
                logger.warn("Cannot cast connector of type ".concat(obj.getClass().getName().concat(" to ").concat("org.mule.modules.exchange.adapters.ExchangeConnectorRestClientAdapter")));
            }
            throw new RuntimeException("Invalid connector type ".concat(obj.getClass().getName()));
        }
        try {
            return ((ExchangeConnectorRestClientAdapter) obj).isConnected();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public void activateObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof ExchangeConnectorConnectionKey)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof ExchangeConnectorRestClientAdapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
            if (!((ExchangeConnectorRestClientAdapter) obj).isConnected()) {
                ((ExchangeConnectorRestClientAdapter) obj).connect(((ExchangeConnectorConnectionKey) key).getUsername(), ((ExchangeConnectorConnectionKey) key).getPassword());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void passivateObject(Object key, Object obj)
        throws Exception
    {
    }

}
