package com.jcs.goboax.aulavirtual.validator;

import com.jcs.goboax.aulavirtual.viewmodel.Registration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator
    implements Validator
{

    @Override
    public boolean supports(Class<?> aClass)
    {
        return Registration.class.equals(aClass);
    }

    @Override
    public void validate(Object anObject, Errors anErrors)
    {
        ValidationUtils.rejectIfEmpty(anErrors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(anErrors, "email", "email.empty");
        Registration myRegistration = (Registration) anObject;
    }
}
