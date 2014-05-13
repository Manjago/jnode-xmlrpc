package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import jnode.ui.shared.ModuleException;

public interface JscriptServiceAsync {
    void executeScript(String content, AsyncCallback<String> async);
}
