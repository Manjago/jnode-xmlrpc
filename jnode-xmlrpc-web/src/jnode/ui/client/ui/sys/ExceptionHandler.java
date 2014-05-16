package jnode.ui.client.ui.sys;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import jnode.ui.client.Helper;

public class ExceptionHandler implements UncaughtExceptionHandler {

    public void onUncaughtException(Throwable arg0) {
        Helper.showError(arg0, true, getClass().getName() + " others");
    }


}
