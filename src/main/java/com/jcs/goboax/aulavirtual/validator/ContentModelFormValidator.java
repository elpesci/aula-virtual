package com.jcs.goboax.aulavirtual.validator;

import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContentModelFormValidator
    implements Validator
{

    @Override
    public boolean supports(Class<?> aClass)
    {
        return ContentModelForm.class.equals(aClass);
    }

    @Override
    public void validate(Object anObjet, Errors anErrors)
    {
        // TODO Auto-generated method stub
        
    }

}
