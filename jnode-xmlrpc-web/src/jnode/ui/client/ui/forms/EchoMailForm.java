package jnode.ui.client.ui.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;
import jnode.ui.client.Helper;
import jnode.ui.client.services.EchoMailService;
import jnode.ui.client.services.EchoMailServiceAsync;
import jnode.ui.client.ui.sys.BlockingServiceCallback;
import jnode.ui.shared.dto.EchoMail;

public class EchoMailForm implements IsWidget {

    private static final int FORM_WIDTH = 700;
    private static final int BODY_HEIGHT = 400;
    private final Window panel;

    public EchoMailForm() {
        panel = new Window();
        panel.setModal(true);
        panel.setHeadingText(Helper.CONSTANTS.echomailTitle());
        panel.setWidth(FORM_WIDTH);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        final TextField echoarea = new TextField();
        echoarea.setAllowBlank(false);
        echoarea.setEmptyText(Helper.CONSTANTS.echoareaHint());
        p.add(new FieldLabel(echoarea, Helper.CONSTANTS.echoarealLabel()), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        final TextField subject = new TextField();
        subject.setAllowBlank(false);
        subject.setEmptyText(Helper.CONSTANTS.subjectHint());
        p.add(new FieldLabel(subject, Helper.CONSTANTS.subjectLabel()), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        final TextArea body = new TextArea();
        body.setHeight(BODY_HEIGHT);
        body.setAllowBlank(false);
        body.setEmptyText(Helper.CONSTANTS.bodyHint());
        p.add(new FieldLabel(body, Helper.CONSTANTS.bodyLabel()), new VerticalLayoutContainer.VerticalLayoutData(1, 1));

        panel.addButton(new TextButton(Helper.CONSTANTS.buttonSend(), new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

                if (echoarea.isValid() & subject.isValid() & body.isValid()) {
                    send(echoarea.getCurrentValue(), subject.getCurrentValue(), body.getCurrentValue());
                    panel.hide();
                }
            }
        }));
        panel.addButton(new TextButton(Helper.CONSTANTS.buttonCancel(), new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                panel.hide();
            }
        }));
    }

    @Override
    public Widget asWidget() {
        return panel;
    }

    public void run() {
        Window me = (Window) asWidget();
        me.show();
    }

    private void send(final String echoarea, final String subject, String body) {
        EchoMailServiceAsync service = GWT.create(EchoMailService.class);
        EchoMail dto = new EchoMail();
        dto.setSubject(subject);
        dto.setEchoarea(echoarea);
        dto.setBody(body);
        service.send(dto, new BlockingServiceCallback<Void>("jscriptform") {
            @Override
            public void onSuccess(Void result) {
                getBlocker().stop();
                Info.display(Helper.CONSTANTS.titleInformation(), Helper.MESSAGES.echomailSendOk(subject, echoarea));
            }
        });


    }
}
