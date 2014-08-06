package com.jcs.goboax.aulavirtual.service.api;

import java.util.List;
import java.util.Map;

import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

public interface RegistrationService {
    
    void createRegistration(Registration aRegistration);
    
    Map<String, String> convertProfilesToMap(List<Perfil> aProfiles);

}
