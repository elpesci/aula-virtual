package com.jcs.goboax.aulavirtual.converter;

import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

public class RegistrationToUsuarioConverter 
    implements Converter<Registration, Usuario> {

    @Override
    public Usuario convert(Registration arg0) {
        // TODO Auto-generated method stub
        return new Usuario();
    }

}
