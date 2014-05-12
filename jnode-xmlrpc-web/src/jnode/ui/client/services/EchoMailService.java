package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.EchoMail;

@RemoteServiceRelativePath("echomail")
public interface EchoMailService extends RemoteService {
    void send(EchoMail echoMail) throws ModuleException;
}
