package jnode.ui.client.ui.sys;

import com.google.gwt.core.client.GWT;
import jnode.ui.client.Helper;
import jnode.ui.shared.ModuleException;

public final class ExceptionHelper {
    private ExceptionHelper() {
    }

    public static void showError(Throwable caught,
                                 String debugStr) {
        showError(caught, false, debugStr);
    }

    public static void showError(Throwable caught, boolean unexpected,
                                 String debugStr) {

        GWT.log(caught.getMessage());
        if (caught instanceof ModuleException) {
            ModuleException e = (ModuleException) caught;
            GWT.log(e.getStrCause());
            GWT.log(e.getStrName());
        }

        ExceptionParser parsed = new ExceptionParser();
        parsed.parse(caught, debugStr);

        new ExceptionForm(unexpected ? Helper.CONSTANTS.errorUnexpectedTitle()
                : Helper.CONSTANTS.errorTitle(), parsed.getTextForUser(),
                parsed.getTextForAdmin()).asWidget().show();
    }
}
