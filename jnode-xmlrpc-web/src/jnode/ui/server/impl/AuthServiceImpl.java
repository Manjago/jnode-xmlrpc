package jnode.ui.server.impl;

import jnode.ui.client.services.AuthService;
import jnode.ui.server.dao.AuthDAO;
import jnode.ui.shared.ModuleException;
import jnode.ui.shared.dto.AuthInfo;
import jnode.ui.shared.dto.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class AuthServiceImpl extends DependencyInjectionRemoteServiceServlet implements AuthService {
    private static final long serialVersionUID = -1169051111278168864L;
    private final transient Logger logger = LoggerFactory.getLogger(getClass());


    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private transient AuthDAO authDAO;

    @Override
    public AuthInfo auth(LoginInfo loginInfo) throws ModuleException {

        SecurityContextHolder.clearContext();
        AuthInfo result =  authDAO.auth(loginInfo);
        if (result != null){
            List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

            for(String s : result.getRoles()){
                auths.add(new GrantedAuthorityImpl(s));
            }


            Authentication auth = new UsernamePasswordAuthenticationToken(result.getLogin(),
                    null, auths);

            SecurityContext sc = SecurityContextHolder.createEmptyContext();
            sc.setAuthentication(auth);
            SecurityContextHolder.setContext(sc);

            logger.debug("set security context " + SecurityContextHolder.getContext());
        }

        return result;
    }
}
