package jnode.ui.server.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import jnode.ui.client.services.EchoMailService;
import jnode.ui.server.dao.EchoMailDAO;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.EchoMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EchoMailServiceImpl extends DependencyInjectionRemoteServiceServlet implements EchoMailService {
    private static final long serialVersionUID = -6599839006987176506L;

    @Autowired
    private EchoMailDAO echoMailDAO;

    @Override
    public void send(EchoMail echoMail) throws ModuleException {
        echoMailDAO.send(echoMail);
    }
}
