package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Usuario;
import org.springframework.security.core.Authentication;

public interface AuthenticationService
{
    Authentication getAuthentication();

    Usuario getUsusario();
}
