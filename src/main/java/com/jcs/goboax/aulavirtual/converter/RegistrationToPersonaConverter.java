package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.util.Constants;
import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Persona;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

import java.util.Date;

public class RegistrationToPersonaConverter 
    implements Converter<Registration, Persona> {

    @Override
    public Persona convert(Registration aRegistration) {
        Persona myPersona = new Persona();
        myPersona.setCorreoElectronico(aRegistration.getEmail());
        myPersona.setFechaCreacion(new Date());
        myPersona.setNombre(aRegistration.getName());
        myPersona.setApellidoPaterno(aRegistration.getLastName());
        myPersona.setApellidoMaterno(aRegistration.getSecondLastName());
        myPersona.setCreadoPor(Constants.SUPER_USER_ID);
        return myPersona;
    }

}
