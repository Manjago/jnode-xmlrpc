package jnode.ui.server.security;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;

import java.text.MessageFormat;

/**
 * A dummy {@link org.springframework.security.authentication.AuthenticationProvider} implementation.
 *
 * @author See Wah Cheng
 * @created 6 Jan 2009
 */
public class DummyAuthenticationProvider implements AuthenticationProvider {

    public Authentication authenticate(Authentication authentication) {

        LoggerFactory.getLogger(getClass()).error(MessageFormat.format("got springsecurity authenticate req={0}", authentication));
        throw new IllegalStateException("This implementation is a dummy class, created purely so that "
                + "spring security namespace tags can be used in application context, and this method should "
                + "never be called");
    }

    @SuppressWarnings("rawtypes")
    public boolean supports(Class clazz) {

        LoggerFactory.getLogger(getClass()).error(MessageFormat.format("got springsecurity supports req={0}", clazz));
        throw new IllegalStateException("This implementation is a dummy class, created purely so that "
                + "spring security namespace tags can be used in application context, and this method should "
                + "never be called");

    }
}
