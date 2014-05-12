package jnode.ui.client.starup;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuBarItem;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import jnode.ui.client.Desktop;
import jnode.ui.client.Helper;
import jnode.ui.client.ui.EchoMailForm;

public class Main implements EntryPoint {
    @Override
    public void onModuleLoad() {
        final Desktop desktop = new Desktop();

        Menu sub = new Menu();
        sub.add(new MenuItem(Helper.CONSTANTS.menuItemLetter(), new SelectionHandler<MenuItem>() {
            @Override
            public void onSelection(SelectionEvent<MenuItem> event) {
                new EchoMailForm().run();
            }
        }));

        desktop.getMenuBar().add(new MenuBarItem(Helper.CONSTANTS.menuTrash(), sub));

        RootPanel root = RootPanel.get("jnodeUiGWT");
        root.add(desktop);
        desktop.asWidget().forceLayout();
    }
}
