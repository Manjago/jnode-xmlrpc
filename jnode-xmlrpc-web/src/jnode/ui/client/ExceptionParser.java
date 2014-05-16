package jnode.ui.client;

import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.rpc.StatusCodeException;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.SharedUtils;

public class ExceptionParser {

    /**
     * Текст для пользователя
     */
    private String textForUser = "";
    /**
     * Текст для администратора
     */
    private String textForAdmin = "";

    private static void appendThrowableInfo(StringBuilder sb, Throwable e) {
        sb.append(e == null ? "cause==null" : e + ", class=" + e.getClass()
                + ", message=" + e.getMessage());

    }

    public void parse(Throwable t, String debugStr) {

        textForUser = makeTextForUser(t);
        textForAdmin = makeTextForAdmin(t, debugStr);
    }

    private String makeTextForAdmin(Throwable t, String debugStr) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(t.getClass());
        sb.append("]\r\n");

        sb.append(t.getMessage());

        // для особых иксипшенов - дополнительно выводим нечто
        if (t instanceof StatusCodeException) {
            sb.append("\r\n[statusCode="
                    + ((com.google.gwt.user.client.rpc.StatusCodeException) t)
                    .getStatusCode() + "]");
        }

        sb.append("\r\n[");
        appendThrowableInfo(sb, t.getCause());
        sb.append("]");

        if (t instanceof UmbrellaException) {
            UmbrellaException residentEvil = (UmbrellaException) t;
            for (Throwable item : residentEvil.getCauses()) {

                sb.append("\r\n umbrellaCause: ");
                appendThrowableInfo(sb, item);
                sb.append("]");

                if (item instanceof com.google.web.bindery.event.shared.UmbrellaException) {
                    com.google.web.bindery.event.shared.UmbrellaException residentEvil2 = (com.google.web.bindery.event.shared.UmbrellaException) item;

                    for (Throwable item2 : residentEvil2.getCauses()) {
                        sb.append("\r\n umbrellaCause2: ");
                        appendThrowableInfo(sb, item2);
                        sb.append("]");
                    }
                }

            }
        }

        sb.append("\r\n[");
        sb.append(debugStr);
        sb.append("]");
        return sb.toString();
    }

    private String makeTextForUser(Throwable t) {
        if (t instanceof ModuleException) {
            ModuleException e = (ModuleException) t;
            return !SharedUtils.isEmptyStr(e.getUserMessage()) ? e.getUserMessage() : e.getMessage();

        }
        return t.getMessage();
    }

    public String getTextForUser() {
        return textForUser;
    }

    public void setTextForUser(String textForUser) {
        this.textForUser = textForUser;
    }

    public String getTextForAdmin() {
        return textForAdmin;
    }

}
