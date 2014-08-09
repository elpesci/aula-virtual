package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl
    implements EmailService
{
    @Override
    public void sendTemporaryPasswordEmail(Usuario aUsuario, String Password)
    {

    }
}
