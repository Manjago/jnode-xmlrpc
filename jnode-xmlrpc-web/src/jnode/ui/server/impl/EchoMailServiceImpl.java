package jnode.ui.server.impl;

import jnode.ui.client.services.EchoMailService;
import jnode.ui.server.dao.EchoMailDAO;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.EchoMail;
import org.springframework.beans.factory.annotation.Autowired;

public class EchoMailServiceImpl extends DependencyInjectionRemoteServiceServlet implements EchoMailService {
    private static final long serialVersionUID = -6599839006987176506L;

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private transient EchoMailDAO echoMailDAO;

    @Override
    public void send(EchoMail echoMail) throws ModuleException {
        echoMailDAO.send(echoMail);
    }
}
