package jnode.ui.server.dao.impl;

import jnode.ui.server.dao.AuthDAO;
import jnode.ui.shared.dto.AuthInfo;
import jnode.ui.shared.dto.LoginInfo;
import jnode.ui.shared.dto.Roles;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashSet;

public class AuthDAOImpl implements AuthDAO {

    private String adminLogin;

    private String adminPassword;

    @Required
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Required
    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    @Override
    public AuthInfo auth(LoginInfo loginInfo) {
        if (loginInfo != null && adminLogin.equals(loginInfo.getLogin()) && adminPassword.equals(loginInfo.getPassword())){
            AuthInfo result = new AuthInfo();
            result.setLogin(loginInfo.getLogin());
            result.setRoles(new HashSet<String>());
            result.getRoles().add(Roles.ROLE_ADMIN);
            return result;
        }
        return null;
    }


}
