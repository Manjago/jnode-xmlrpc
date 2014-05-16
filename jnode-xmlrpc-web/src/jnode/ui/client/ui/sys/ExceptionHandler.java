package jnode.ui.client.ui.sys;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import jnode.ui.client.Helper;

public class ExceptionHandler implements UncaughtExceptionHandler {

    private static final String NUMBER_2146823281 = "number: -2146823281";

    public void onUncaughtException(Throwable arg0) {
        Helper.showError(arg0, true, getClass().getName() + " others");
    }


}
