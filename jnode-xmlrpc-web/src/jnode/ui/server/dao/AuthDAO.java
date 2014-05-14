package jnode.ui.server.dao;

import jnode.ui.shared.dto.AuthInfo;
import jnode.ui.shared.dto.LoginInfo;

public interface AuthDAO {
    AuthInfo auth(LoginInfo loginInfo);
}
