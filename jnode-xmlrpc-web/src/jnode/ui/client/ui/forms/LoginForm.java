package jnode.ui.client.ui.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;
import jnode.ui.client.Helper;
import jnode.ui.client.services.AuthService;
import jnode.ui.client.services.AuthServiceAsync;
import jnode.ui.client.ui.sys.BlockingServiceCallback;
import jnode.ui.shared.Lambda;
import jnode.ui.shared.dto.AuthInfo;
import jnode.ui.shared.dto.LoginInfo;

public class LoginForm implements IsWidget {

    private static final int WIDTH = 300;
    private final Window panel;

    public LoginForm(final Lambda<Void, Void> onSuccess) {
        panel = new Window();
        panel.setModal(true);
        panel.setHeadingText("LoginForm");
        panel.setWidth(WIDTH);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        final TextField login = new TextField();
        login.setAllowBlank(false);
        login.setEmptyText("enter login...");
        p.add(new FieldLabel(login, "Login"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        final PasswordField pwd = new PasswordField();
        pwd.setAllowBlank(false);
        p.add(new FieldLabel(pwd, "Password"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        panel.addButton(new TextButton("Login", new LoginHandler(login, pwd, onSuccess)));
    }

    public void run() {
        Window me = (Window) asWidget();
        me.show();
    }

    @Override
    public Widget asWidget() {
        return panel;
    }

    private class LoginHandler implements SelectEvent.SelectHandler {
        private final TextField login;
        private final PasswordField pwd;
        private final Lambda<Void, Void> onSuccess;

        public LoginHandler(TextField login, PasswordField pwd, Lambda<Void, Void> onSuccess) {
            this.login = login;
            this.pwd = pwd;
            this.onSuccess = onSuccess;
        }

        @Override
        public void onSelect(SelectEvent selectEvent) {
            if (login.isValid() & pwd.isValid()) {

                AuthServiceAsync service = GWT.create(AuthService.class);
                LoginInfo l = new LoginInfo();
                l.setLogin(login.getCurrentValue());
                l.setPassword(pwd.getCurrentValue());

                service.auth(l, new BlockingServiceCallback<AuthInfo>("login") {
                    @Override
                    public void onFailure(Throwable caught) {
                        super.onFailure(caught);
                        Info.display(Helper.CONSTANTS.titleInformation(), Helper.CONSTANTS.badPassword());
                        panel.hide();
                    }

                    @Override
                    public void onSuccess(AuthInfo result) {
                        getBlocker().stop();
                        if (onSuccess != null) {
                            onSuccess.execute(null);
                        }
                        panel.hide();
                    }
                });


            }
        }
    }
}
