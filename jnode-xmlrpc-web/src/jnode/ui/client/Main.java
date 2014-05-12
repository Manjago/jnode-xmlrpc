package jnode.ui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuBarItem;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import jnode.ui.client.services.EchoMailService;
import jnode.ui.client.services.EchoMailServiceAsync;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.EchoMail;

public class Main implements EntryPoint {
    @Override
    public void onModuleLoad() {
        final Desktop desktop = new Desktop();

        Menu sub = new Menu();
        sub.add(new MenuItem(Helper.CONSTANTS.menuItemLetter(), new SelectionHandler<MenuItem>() {
            @Override
            public void onSelection(SelectionEvent<MenuItem> event) {
                EchoMailServiceAsync service = GWT.create(EchoMailService.class);
                EchoMail dto = new EchoMail();
                dto.setSubject("test from web");
                dto.setEchoarea("828.test");
                dto.setBody("test message body руске пукве");
                service.send(dto, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        GWT.log(caught.getMessage());
                        if (caught instanceof ModuleException){
                            ModuleException e = (ModuleException) caught;
                            GWT.log(e.getStrCause());
                            GWT.log(e.getStrName());
                        }
                        Info.display("error", caught.toString());

                    }

                    @Override
                    public void onSuccess(Void result) {
                        Info.display("debug", "ok");
                    }
                });


            }
        }));

        desktop.getMenuBar().add(new MenuBarItem(Helper.CONSTANTS.menuTrash(), sub));

        RootPanel root = RootPanel.get("jnodeUiGWT");
        root.add(desktop);
        desktop.asWidget().forceLayout();
    }
}
