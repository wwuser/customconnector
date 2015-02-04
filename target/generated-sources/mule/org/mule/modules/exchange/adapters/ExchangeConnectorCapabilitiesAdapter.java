
package org.mule.modules.exchange.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.exchange.ExchangeConnector;


/**
 * A <code>ExchangeConnectorCapabilitiesAdapter</code> is a wrapper around {@link ExchangeConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-04T07:14:23+05:30", comments = "Build UNNAMED.2039.0541b23")
public abstract class ExchangeConnectorCapabilitiesAdapter
    extends ExchangeConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

}
