package jnode.ui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;

public class Main implements EntryPoint {
    @Override
    public void onModuleLoad() {

        RootPanel root = RootPanel.get("jnodeUiGWT");
        TextButton bt = new TextButton("g");
        root.add(bt);
    }
}
