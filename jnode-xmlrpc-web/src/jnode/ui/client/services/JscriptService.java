package jnode.ui.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import jnode.ui.shared.ModuleException;

@RemoteServiceRelativePath("jscript")
public interface JscriptService extends RemoteService {
    String executeScript(String content) throws ModuleException;
}
