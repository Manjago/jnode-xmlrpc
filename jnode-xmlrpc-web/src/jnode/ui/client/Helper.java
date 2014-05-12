package jnode.ui.client;

import com.google.gwt.core.client.GWT;
import jnode.ui.client.generated.ModuleConstants;

public final class Helper {
    private Helper() {
    }

    public static final ModuleConstants CONSTANTS = GWT.create(ModuleConstants.class);

}
