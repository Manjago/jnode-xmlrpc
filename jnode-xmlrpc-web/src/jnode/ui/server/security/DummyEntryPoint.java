package jnode.ui.server.security;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * A dummy {@link org.springframework.security.web.AuthenticationEntryPoint} implementation.
 *
 * @author See Wah Cheng
 * @created 6 Jan 2009
 */
public class DummyEntryPoint implements AuthenticationEntryPoint {

    public void commence(HttpServletRequest arg0, HttpServletResponse arg1,
                         AuthenticationException arg2) throws IOException, ServletException {
        LoggerFactory.getLogger(getClass()).error(MessageFormat.format("got springsecurity commense req={0}, resp={1}, authEx={3}", arg0, arg1, arg2));
        throw new IllegalStateException(
                "This implementation is a dummy class, created purely so that "
                        + "spring security namespace tags can be used in application context, and this method should "
                        + "never be called");
    }

}
