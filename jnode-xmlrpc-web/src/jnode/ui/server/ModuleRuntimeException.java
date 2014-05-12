package jnode.ui.server;

public class ModuleRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -268971932972984038L;

    public ModuleRuntimeException() {
        super();
    }

    public ModuleRuntimeException(String message) {
        super(message);
    }

    public ModuleRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModuleRuntimeException(Throwable cause) {
        super(cause);
    }

    protected ModuleRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
