package jnode.ui.server.xmlrpc;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.springframework.beans.factory.annotation.Required;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public class ClientProxy {

    private static final int MILLISEC_IN_SEC = 1000;
    private static final int HALF_MINUTE = 30;

    @Required
    public void setConnString(String connString) {
        this.connString = connString;
    }

    @Required
    public void setUser(String user) {
        this.user = user;
    }

    @Required
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String connString;
    private String user;
    private String pwd;

    private ClientProxy() {
    }

    XmlRpcClient getXmlRpcClient() throws MalformedURLException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(connString));
        config.setBasicUserName(user);
        config.setBasicPassword(pwd);
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
