package jnode.ui.server.dao;

import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.EchoMail;

public interface EchoMailDAO {
    void send(EchoMail echoMail) throws ModuleException;
}
