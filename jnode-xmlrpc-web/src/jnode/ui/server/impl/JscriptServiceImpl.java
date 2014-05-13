package jnode.ui.server.impl;

import jnode.ui.client.services.JscriptService;
import jnode.ui.server.dao.JscriptDAO;
import jnode.ui.shared.ModuleException;
import org.springframework.beans.factory.annotation.Autowired;

public class JscriptServiceImpl extends DependencyInjectionRemoteServiceServlet implements JscriptService {

    private static final long serialVersionUID = 6212189618891695475L;

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private transient JscriptDAO jscriptDAO;

    @Override
    public String executeScript(String content) throws ModuleException {
        return jscriptDAO.executeScript(content);
    }
}
