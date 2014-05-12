package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import jnode.ui.shared.dto.EchoMail;

public interface EchoMailServiceAsync {
    void send(EchoMail echoMail, AsyncCallback<Void> async);
}
