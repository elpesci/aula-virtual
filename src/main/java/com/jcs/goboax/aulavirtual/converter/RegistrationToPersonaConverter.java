package com.jcs.goboax.aulavirtual.converter;

import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Persona;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

public class RegistrationToPersonaConverter 
    implements Converter<Registration, Persona> {

    @Override
    public Persona convert(Registration arg0) {
        // TODO Auto-generated method stub
        return new Persona();
    }

}
