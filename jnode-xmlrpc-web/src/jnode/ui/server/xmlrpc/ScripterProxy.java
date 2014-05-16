package jnode.ui.server.xmlrpc;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.util.ClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.net.MalformedURLException;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public class ScripterProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScripterProxy.class);

    @Required
    public void setAuthInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    private AuthInfo authInfo;

    public String runScript(String id) throws XmlRpcException, MalformedURLException {
        ClientFactory factory = new ClientFactory(ClientProxy.getXmlRpcClient(authInfo));
        jnode.Scripter scripter = (jnode.Scripter) factory.newInstance(jnode.Scripter.class);
        final String run = scripter.run(id);
        LOGGER.debug("run script {}, responce {}", id, run);
        return run;
    }

    public String executeScript(String content) throws XmlRpcException, MalformedURLException {
        ClientFactory factory = new ClientFactory(ClientProxy.getXmlRpcClient(authInfo));
        jnode.Scripter scripter = (jnode.Scripter) factory.newInstance(jnode.Scripter.class);
        final String run = scripter.runScript(content);
        LOGGER.debug("run script {}, responce {}", content, run);
        return run;
    }
}
