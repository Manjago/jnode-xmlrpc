package jnode.ui.server.xmlrpc;

import org.springframework.beans.factory.annotation.Required;

public class AuthInfo {
    @Required
    public void setConnString(String connString) {
        this.connString = connString;
    }

    @Required
    public void setUser(String user) {
        this.user = user;
    }

    @Required
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConnString() {
        return connString;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    private String connString;
    private String user;
    private String pwd;


}
