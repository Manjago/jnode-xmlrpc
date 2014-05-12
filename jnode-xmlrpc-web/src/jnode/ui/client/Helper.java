package jnode.ui.client;

import com.google.gwt.core.client.GWT;
import jnode.ui.client.generated.ModuleConstants;
import jnode.ui.client.generated.ModuleMessages;

public final class Helper {
    private Helper() {
    }

    public static final ModuleConstants CONSTANTS = GWT.create(ModuleConstants.class);
    public static final ModuleMessages MESSAGES = GWT.create(ModuleMessages.class);

}
