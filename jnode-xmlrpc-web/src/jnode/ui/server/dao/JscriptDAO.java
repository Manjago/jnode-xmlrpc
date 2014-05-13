package jnode.ui.server.dao;

import jnode.ui.shared.ModuleException;

public interface JscriptDAO {
    String executeScript(String content) throws ModuleException;
}
