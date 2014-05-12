package jnode.ui.server.dao.impl;

import jnode.ui.server.Utils;
import jnode.ui.server.dao.EchoMailDAO;
import jnode.ui.server.xmlrpc.EchomailToolsProxy;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.EchoMail;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.net.MalformedURLException;

public class EchoMailDAOImpl implements EchoMailDAO {
    private final transient Logger logger = LoggerFactory.getLogger(getClass());

    @Required
    public void setEchomailToolsProxy(EchomailToolsProxy echomailToolsProxy) {
        this.echomailToolsProxy = echomailToolsProxy;
    }

    private EchomailToolsProxy echomailToolsProxy;

    @Override
    public void send(EchoMail echoMail) throws ModuleException {

        logger.debug("send {}", echoMail);
        try {
            echomailToolsProxy.writeEchomail(echoMail.getEchoarea(), echoMail.getSubject(), echoMail.getBody());
        } catch (XmlRpcException e) {
            logger.error("fail send", e);
            throw Utils.wrap(e);
        } catch (MalformedURLException e) {
            logger.error("fail send", e);
            throw Utils.wrap(e);
        }
    }
}
