package jnode.ui.shared;

public class ModuleException extends Exception {
    private static final long serialVersionUID = -1336629341416348832L;

    public ModuleException() {
    }

    public ModuleException(String message) {
        super(message);
        userMessage = message;
    }

    public String getStrCause() {
        return strCause;
    }

    public void setStrCause(String strCause) {
        this.strCause = strCause;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    private String strCause;
    private String strName;

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    private String userMessage;


}
