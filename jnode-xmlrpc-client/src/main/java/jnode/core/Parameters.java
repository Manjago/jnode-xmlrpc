package jnode.core;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public final class Parameters {
    private Parameters() {
    }

    /**
     * SingletonHolder is loaded on the first execution of Parameters.getInstance()
     * or the first access to SingletonHolder.INSTANCE, not before.
     */
    private static class SingletonHolder {
        private static final Parameters INSTANCE = new Parameters();
    }

    public static Parameters getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private String connString;
    private String user;
    private String pwd;

    public String getConnString() {
        return connString;
    }

    public void setConnString(String connString) {
        this.connString = connString;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
