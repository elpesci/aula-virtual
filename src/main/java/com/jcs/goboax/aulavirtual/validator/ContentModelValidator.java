package com.jcs.goboax.aulavirtual.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;

@Component
public class ContentModelValidator
    implements Validator
{

    @Override
    public boolean supports(Class<?> aClass)
    {
        return ContentModel.class.equals(aClass);
    }

    @Override
    public void validate(Object anObjet, Errors anErrors)
    {
        // TODO Auto-generated method stub
        
    }

}
