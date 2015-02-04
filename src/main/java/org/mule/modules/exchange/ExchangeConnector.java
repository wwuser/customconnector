/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.exchange;

import java.io.IOException;

import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ReconnectOn;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.ConnectionException;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Processor;

import org.mule.api.annotations.rest.HttpMethod;
import org.mule.api.annotations.rest.RestCall;
import org.mule.api.annotations.rest.RestUriParam;

/**
 * Anypoint Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="exchange", schemaVersion="1.0", friendlyName="CurrencyExchanger")
public abstract class ExchangeConnector
{
    /**
     * Configurable
     */
    @Configurable
    @Default("value")
   	private String currencyRate;
    

    public String getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(String currencyRate) {
		this.currencyRate = currencyRate;
	}

	/**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey String username, @Password @Default("pwd") String password)
        throws ConnectionException {
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
     
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return false;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }
    
    
    /**
     * Custom processor
     *
     * {currency-exchange-connector.xml ../../../doc/currency-exchange-connector.xml.sample currency-exchange-connector:sell-currency}
     *
     * @param currency currency to be processed
     * @return acknowledgment of sell is succedeed or not 
     */
    @Processor
    @ReconnectOn(exceptions = { Exception.class })
    @RestCall(uri="http://10.0.1.164:8066/setcurr/{currency}", method=HttpMethod.POST)
    public abstract Object sellCurrency(@RestUriParam("currency") String currency) throws IOException;
    
    
    /**
     * Custom processor
     *
     * {currency-exchange-connector.xml ../../../doc/currency-exchange-connector.xml.sample currency-exchange-connector:my-processor}
     *
     * @param rate rate to be processed
     * @return exchange rate of particular currency
     */
    @Processor
    @ReconnectOn(exceptions = { Exception.class })
    @RestCall(uri="http://10.0.1.164:8066/getcurrate/{rate}", method=HttpMethod.GET)
    public abstract Object getExchngeRate(@RestUriParam("rate") String rate) throws IOException;  

}