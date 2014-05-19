package jnode.ui.client.ui.sys;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

    public void onUncaughtException(Throwable arg0) {
        ExceptionHelper.showError(arg0, true, getClass().getName() + " others");
    }


}
