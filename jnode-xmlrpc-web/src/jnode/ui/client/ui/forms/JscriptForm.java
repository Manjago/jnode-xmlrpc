package jnode.ui.client.ui.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextArea;
import jnode.ui.client.Helper;
import jnode.ui.client.services.JscriptService;
import jnode.ui.client.services.JscriptServiceAsync;
import jnode.ui.client.ui.sys.BlockingServiceCallback;

public class JscriptForm implements IsWidget {


    private static final int SCRIPT_HEIGHT = 300;
    private static final int RESP_HEIGHT = 300;
    private final ContentPanel widget;
    private final TextArea resp;

    public JscriptForm() {
        VerticalLayoutContainer outer = new VerticalLayoutContainer();

        widget = new ContentPanel();
        widget.setHeadingText(Helper.CONSTANTS.jscriptTitle());

        final TextArea body = new TextArea();
        body.setHeight(SCRIPT_HEIGHT);
        body.setAllowBlank(false);
        body.setEmptyText(Helper.CONSTANTS.jscriptHint());
        outer.add(new FieldLabel(body, Helper.CONSTANTS.jscriptBody()), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        resp = new TextArea();
        resp.setHeight(RESP_HEIGHT);
        resp.setAllowBlank(true);
        resp.setReadOnly(true);
        outer.add(new FieldLabel(resp, Helper.CONSTANTS.jscriptResponce()), new VerticalLayoutContainer.VerticalLayoutData(1, 1));

        widget.addButton(new TextButton(Helper.CONSTANTS.buttonExec(), new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                 exec(body.getCurrentValue());
            }
        }));
        widget.addButton(new TextButton(Helper.CONSTANTS.buttonCancel(), new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                  //TODO нормально закрыть
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

        service.executeScript(content, new BlockingServiceCallback<String>("consola") {
            @Override
            public void onSuccess(String result) {
                getBlocker().stop();
                resp.clear();
                resp.setValue(result);
            }
        });

    }
}
