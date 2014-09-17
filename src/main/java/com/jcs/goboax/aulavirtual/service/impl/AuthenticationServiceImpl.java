package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthenticationServiceImpl
        implements AuthenticationService
{
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public Usuario getUsuario()
    {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof Usuario)
        {
            return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }

        return null;
    }

    public boolean hasRole(String role)
    {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities)
        {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole)
            {
                break;
            }
        }
        return hasRole;
    }
}
