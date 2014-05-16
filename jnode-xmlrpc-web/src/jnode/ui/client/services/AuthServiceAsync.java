package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import jnode.ui.shared.dto.AuthInfo;
import jnode.ui.shared.dto.LoginInfo;

public interface AuthServiceAsync {
    void auth(LoginInfo loginInfo, AsyncCallback<AuthInfo> async);
}
