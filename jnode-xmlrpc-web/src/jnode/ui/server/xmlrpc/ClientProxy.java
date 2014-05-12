package jnode.ui.server.xmlrpc;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public final class ClientProxy {

    private static final int MILLISEC_IN_SEC = 1000;
    private static final int HALF_MINUTE = 30;

    private ClientProxy() {
    }

    static XmlRpcClient getXmlRpcClient(AuthInfo authInfo) throws MalformedURLException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(authInfo.getConnString()));
        config.setBasicUserName(authInfo.getUser());
        config.setBasicPassword(authInfo.getPwd());
        config.setEnabledForExtensions(false);
        config.setContentLengthOptional(false);
        config.setConnectionTimeout(HALF_MINUTE * MILLISEC_IN_SEC);
        config.setReplyTimeout(HALF_MINUTE * MILLISEC_IN_SEC);

        XmlRpcClient client = new XmlRpcClient();
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        client.setConfig(config);
        return client;
    }

}
