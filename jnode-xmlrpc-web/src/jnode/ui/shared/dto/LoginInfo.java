package jnode.ui.shared.dto;

import java.io.Serializable;

public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 6962941358952021229L;
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "login='" + login + '\'' +
                '}';
    }
}
