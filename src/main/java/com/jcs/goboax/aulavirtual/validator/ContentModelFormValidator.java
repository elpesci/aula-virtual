package com.jcs.goboax.aulavirtual.validator;

import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
        ContentModelForm myContentModelForm = (ContentModelForm) anObjet;
        CommonsMultipartFile myMultipartFile = myContentModelForm.getContent();

        if (myContentModelForm.getId() == null
                && (myMultipartFile == null || myMultipartFile.getSize() <= 0))
        {
            anErrors.rejectValue("content", "content.empty");
        }
    }

}
