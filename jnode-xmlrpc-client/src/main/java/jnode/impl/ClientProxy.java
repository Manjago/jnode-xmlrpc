package jnode.impl;

import jnode.Parameters;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public class ClientProxy {
    static XmlRpcClient getXmlRpcClient() throws MalformedURLException {

        Parameters pars = Parameters.getInstance();

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(pars.getConnString()));
        config.setBasicUserName(pars.getUser());
        config.setBasicPassword(pars.getPwd());
        config.setEnabledForExtensions(false);
        config.setContentLengthOptional(false);
        config.setConnectionTimeout(30 * 1000);
        config.setReplyTimeout(30 * 1000);

        XmlRpcClient client = new XmlRpcClient();
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        client.setConfig(config);
        return client;
    }

}
