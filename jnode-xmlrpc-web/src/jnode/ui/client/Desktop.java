package jnode.ui.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.menu.MenuBar;

public class Desktop implements IsWidget {

    private final VerticalLayoutContainer outer;

    public MenuBar getMenuBar() {
        return menuBar;
    }

    private final ContentPanel workspace;
    private final MenuBar menuBar;

    public Desktop() {
        outer = new VerticalLayoutContainer();
        this.menuBar = new MenuBar();

        workspace = new ContentPanel();
        workspace.setHeaderVisible(false);
        workspace.setCollapsible(true);
        workspace.setBodyStyle("backgroundColor: white;");

        outer.add(menuBar);
        outer.add(workspace);
    }

    public VerticalLayoutContainer asWidget() {
        return outer;
    }


}
