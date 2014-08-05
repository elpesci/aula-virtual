package com.jcs.goboax.aulavirtual.converter;

import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Persona;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

import java.util.Date;

public class RegistrationToPersonaConverter 
    implements Converter<Registration, Persona> {

    @Override
    public Persona convert(Registration aRegistration) {
        Persona myPersona = new Persona();
        myPersona.setFechaCreacion(new Date());
        myPersona.setNombre(aRegistration.getName());
        return myPersona;
    }

}
