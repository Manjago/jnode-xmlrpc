package jnode.ui.server.dao.mock;

import jnode.ui.server.dao.EchoMailDAO;
import jnode.ui.shared.dto.EchoMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoMailDAOMock implements EchoMailDAO {
    private final transient Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void send(EchoMail echoMail) {
        logger.debug("send {}", echoMail);
    }
}
