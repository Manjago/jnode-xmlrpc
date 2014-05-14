package jnode.ui.shared.dto;

import java.io.Serializable;
import java.util.Set;

public class AuthInfo implements Serializable {
    private static final long serialVersionUID = -5932083309731818546L;
    private String login;
    private Set<String> roles;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AuthInfo{" +
                "login='" + login + '\'' +
                ", roles=" + roles +
                '}';
    }
}
