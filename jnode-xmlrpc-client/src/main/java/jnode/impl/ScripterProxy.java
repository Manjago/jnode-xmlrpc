package jnode.impl;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.util.ClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public final class ScripterProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScripterProxy.class);

    private ScripterProxy() {
    }

    public static String runScript(String id) {

        try {
            ClientFactory factory = new ClientFactory(ClientProxy.getXmlRpcClient());
            jnode.Scripter scripter = (jnode.Scripter) factory.newInstance(jnode.Scripter.class);
            final String run = scripter.run(id);
            LOGGER.debug("run script {}, responce {}", id, run);
            return run;

        } catch (MalformedURLException | XmlRpcException e) {
            LOGGER.error("fail runScript {}", id, e);
            return e.getMessage();
        }
    }

}
