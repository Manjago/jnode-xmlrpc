package jnode.ui.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.menu.MenuBar;

public class Desktop implements IsWidget {

    private final VerticalLayoutContainer outer;
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

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public VerticalLayoutContainer asWidget() {
        return outer;
    }

    public void launchWidget(IsWidget form) {
        clearDesktop();

        workspace.setWidget(form);

        forceLayout();
    }

    private void clearDesktop() {
        workspace.clear();
    }

    private void forceLayout() {
        asWidget().forceLayout();
    }

}
