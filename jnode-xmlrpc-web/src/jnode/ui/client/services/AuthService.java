package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.AuthInfo;
import jnode.ui.shared.dto.LoginInfo;

@RemoteServiceRelativePath("auth")
public interface AuthService extends RemoteService {
    AuthInfo auth(LoginInfo loginInfo) throws ModuleException;
}
