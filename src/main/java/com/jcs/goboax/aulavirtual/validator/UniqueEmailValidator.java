package com.jcs.goboax.aulavirtual.validator;

import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.validator.annotation.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator
        implements ConstraintValidator<UniqueEmail, String>
{
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(String aValue, ConstraintValidatorContext aContext)
    {
        try
        {
            usuarioService.readByEmail(aValue);
            return false;
        }
        catch (AulaVirtualPersistenceException e)
        {
            return true;
        }
    }
}
