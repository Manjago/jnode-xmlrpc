package jnode.ui.server.dao;

import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.Roles;
import org.springframework.security.access.annotation.Secured;

public interface JscriptDAO {
    @Secured(Roles.ROLE_ADMIN)
    String executeScript(String content) throws ModuleException;
}
