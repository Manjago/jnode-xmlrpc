package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import jnode.ui.shared.dto.EchoMail;

public interface EchoMailServiceAsync {
    void send(EchoMail echoMail, AsyncCallback<Void> async);
}
