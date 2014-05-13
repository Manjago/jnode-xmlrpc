package jnode.ui.client.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import jnode.ui.shared.Lambda;

public class LoginForm implements IsWidget {

    private final Window panel;

    public LoginForm(final Lambda<Void, Void> onSuccess) {
        panel = new Window();
        panel.setModal(true);
        panel.setHeadingText("LoginForm");
        panel.setWidth(300);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        final TextField login = new TextField();
        login.setAllowBlank(false);
        login.setEmptyText("enter login...");
        p.add(new FieldLabel(login, "Login"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        final PasswordField pwd = new PasswordField();
        pwd.setAllowBlank(false);
        p.add(new FieldLabel(pwd, "Password"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        panel.addButton(new TextButton("Login", new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                 if (login.isValid() & pwd.isValid()){
                     if ("user".equals(login.getCurrentValue()) && "user".equals(pwd.getCurrentValue())){
                        if (onSuccess != null){
                            onSuccess.execute(null);
                            panel.hide();
                        }
                     }
                 }
            }
        }));
    }

    public void run() {
        Window me = (Window) asWidget();
        me.show();
    }

    @Override
    public Widget asWidget() {
        return panel;
    }
}
