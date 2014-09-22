package com.jcs.goboax.aulavirtual.validator;

import com.jcs.goboax.aulavirtual.dao.api.ExtensionContenidoDao;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

@Component
public class ContentModelFormValidator
    implements Validator
{
    private static final Logger LOG = LoggerFactory.getLogger(ContentModelFormValidator.class);

    @Autowired
    private ExtensionContenidoDao extensionContenidoDao;

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

        String myExtension = FilenameUtils.getExtension(myContentModelForm.getContent().getOriginalFilename());
        List<String> myExtensions = extensionContenidoDao.readExtensionesContenido();
        LOG.debug("Extension {}, List Extensions {}", myExtension, myExtensions);

        if (!myExtensions.contains(myExtension))
        {
            anErrors.rejectValue("content", "content.wrong.extension");
        }
    }

}
