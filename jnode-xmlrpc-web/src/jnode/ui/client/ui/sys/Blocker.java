package jnode.ui.client.ui.sys;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import jnode.ui.client.Helper;

public final class Blocker {
    private final AutoProgressMessageBox box;

    private Blocker(String header, String message) {
        box = new AutoProgressMessageBox(SafeHtmlUtils.fromString(header),
                SafeHtmlUtils.EMPTY_SAFE_HTML);
        box.setProgressText(message);
        box.setModal(true);
        box.setClosable(false);
        box.auto();
    }

    public static Blocker createBlocker(String msg) {
        return new Blocker(Helper.CONSTANTS.messageWaitTitle(), msg);
    }

    public static Blocker createBlocker() {
        return Blocker.createBlocker(Helper.CONSTANTS.messageWait());
    }

    public void start() {
        box.show();
    }

    public void stop() {
        box.hide();
    }

}
