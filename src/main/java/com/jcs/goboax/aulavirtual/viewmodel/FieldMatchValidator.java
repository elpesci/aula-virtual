package com.jcs.goboax.aulavirtual.viewmodel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.jcs.goboax.aulavirtual.validator.annotation.FieldMatch;

public class FieldMatchValidator
    implements ConstraintValidator<FieldMatch, Object>
{
    private String firstFieldName;
    private String secondFieldName;
    
    @Override
    public void initialize(FieldMatch aFieldMatch)
    {
        firstFieldName = aFieldMatch.first();
        secondFieldName = aFieldMatch.second();
        
    }

    @Override
    public boolean isValid(Object aValue, ConstraintValidatorContext aContext)
    {
        try
        {
            final Object firstObj = BeanUtils
                    .getProperty(aValue, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(aValue,
                    secondFieldName);

            return firstObj == null && secondObj == null || firstObj != null
                    && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            //ignore
        } 
        return true;
    }

}
