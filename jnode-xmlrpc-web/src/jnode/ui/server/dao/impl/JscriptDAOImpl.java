package jnode.ui.server.dao.impl;

import jnode.ui.server.Utils;
import jnode.ui.server.dao.JscriptDAO;
import jnode.ui.server.xmlrpc.ScripterProxy;
import jnode.ui.shared.ModuleException;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.net.MalformedURLException;

public class JscriptDAOImpl implements JscriptDAO {
    private final transient Logger logger = LoggerFactory.getLogger(getClass());

    @Required
    public void setScripterProxy(ScripterProxy scripterProxy) {
        this.scripterProxy = scripterProxy;
    }

    private ScripterProxy scripterProxy;

    @Override
    public String executeScript(String content) throws ModuleException {
        logger.debug("exec {}", content);
        try {
            return scripterProxy.executeScript(content);
        } catch (XmlRpcException e) {
            logger.error("fail exec", e);
            throw Utils.wrap(e);
        } catch (MalformedURLException e) {
            logger.error("fail exec", e);
            throw Utils.wrap(e);
        }
    }
}
