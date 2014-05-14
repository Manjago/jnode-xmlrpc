package jnode.ui.server.dao;

import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.EchoMail;
import jnode.ui.shared.dto.Roles;
import org.springframework.security.access.annotation.Secured;

public interface EchoMailDAO {
    @Secured(Roles.ROLE_ADMIN)
    void send(EchoMail echoMail) throws ModuleException;
}
