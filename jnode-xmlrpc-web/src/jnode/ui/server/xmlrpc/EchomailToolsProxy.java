package jnode.ui.server.xmlrpc;

import jnode.EchomailTools;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.util.ClientFactory;
import org.springframework.beans.factory.annotation.Required;

import java.net.MalformedURLException;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public class EchomailToolsProxy {

    @Required
    public void setAuthInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    private AuthInfo authInfo;

    public String writeEchomail(String areaname, String subject, String body) throws XmlRpcException, MalformedURLException {

        ClientFactory factory = new ClientFactory(ClientProxy.getXmlRpcClient(authInfo));
        EchomailTools echomailTools = (EchomailTools) factory.newInstance(EchomailTools.class);
        return echomailTools.writeEchomail(areaname, subject, body);
    }

    public String writeEchomail(String areaname, String subject, String body, String fromName, String toName) throws XmlRpcException, MalformedURLException {

        ClientFactory factory = new ClientFactory(ClientProxy.getXmlRpcClient(authInfo));
        EchomailTools echomailTools = (EchomailTools) factory.newInstance(EchomailTools.class);
        return echomailTools.writeEchomail(areaname, subject, body, fromName, toName);

    }
}
