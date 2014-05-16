package jnode.ui.client;

import com.google.gwt.core.client.GWT;
import jnode.ui.client.generated.ModuleConstants;
import jnode.ui.client.generated.ModuleMessages;
import jnode.ui.client.ui.sys.ExceptionForm;
import jnode.ui.client.ui.sys.ExceptionParser;
import jnode.ui.shared.ModuleException;

public final class Helper {
    private Helper() {
    }

    public static final ModuleConstants CONSTANTS = GWT.create(ModuleConstants.class);
    public static final ModuleMessages MESSAGES = GWT.create(ModuleMessages.class);

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

        new ExceptionForm(unexpected ? CONSTANTS.errorUnexpectedTitle()
                : CONSTANTS.errorTitle(), parsed.getTextForUser(),
                parsed.getTextForAdmin()).asWidget().show();
    }

}
