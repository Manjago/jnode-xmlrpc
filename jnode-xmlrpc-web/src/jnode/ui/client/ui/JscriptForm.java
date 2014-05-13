package jnode.ui.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.info.Info;
import jnode.ui.client.Helper;
import jnode.ui.client.services.JscriptService;
import jnode.ui.client.services.JscriptServiceAsync;
import jnode.ui.shared.ModuleException;

public class JscriptForm implements IsWidget {


    private final ContentPanel widget;
    private final TextArea resp;

    public JscriptForm() {
        VerticalLayoutContainer outer = new VerticalLayoutContainer();

        widget = new ContentPanel();
        widget.setHeadingText("jscript consola");

        final TextArea body = new TextArea();
        body.setHeight(300);
        body.setAllowBlank(false);
        body.setEmptyText("script here");
        outer.add(new FieldLabel(body, "script"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        resp = new TextArea();
        resp.setHeight(300);
        resp.setAllowBlank(true);
        resp.setReadOnly(true);
        outer.add(new FieldLabel(resp, "responce"), new VerticalLayoutContainer.VerticalLayoutData(1, 1));

        widget.addButton(new TextButton("execute", new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                 exec(body.getCurrentValue());
            }
        }));
        widget.addButton(new TextButton(Helper.CONSTANTS.buttonCancel(), new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

            }
        }));

        widget.add(outer);


    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    private void exec(String content) {
        JscriptServiceAsync service = GWT.create(JscriptService.class);
        service.executeScript(content, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log(caught.getMessage());
                if (caught instanceof ModuleException) {
                    ModuleException e = (ModuleException) caught;
                    GWT.log(e.getStrCause());
                    GWT.log(e.getStrName());
                }
                Info.display("error", caught.toString());
            }

            @Override
            public void onSuccess(String s) {
                resp.clear();
                resp.setValue(s);
            }
        });
    }
}
