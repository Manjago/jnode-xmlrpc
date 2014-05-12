package jnode.ui.server;

import jnode.ui.shared.ModuleException;
import org.apache.commons.lang.exception.ExceptionUtils;

public final class Utils {
    private Utils() {
    }

    public static ModuleException wrap(Throwable cause) {
        if (cause instanceof ModuleException) {
            return (ModuleException) cause;
        } else {

            Throwable rootCause = ExceptionUtils.getRootCause(cause);
            if (rootCause == null) {
                rootCause = cause;
            }

            ModuleException e = new ModuleException(rootCause.getMessage() != null ? rootCause.getMessage() : rootCause.toString());

            e.setStrCause(cause.toString());
            e.setStrName(cause.getClass().getName());


            return e;
        }
    }
}
