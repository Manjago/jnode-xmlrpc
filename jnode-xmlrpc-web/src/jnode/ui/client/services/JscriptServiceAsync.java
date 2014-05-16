package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface JscriptServiceAsync {
    void executeScript(String content, AsyncCallback<String> async);
}
