package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.AuthInfo;
import jnode.ui.shared.dto.LoginInfo;

public interface AuthServiceAsync {
    void auth(LoginInfo loginInfo, AsyncCallback<AuthInfo> async);
}
