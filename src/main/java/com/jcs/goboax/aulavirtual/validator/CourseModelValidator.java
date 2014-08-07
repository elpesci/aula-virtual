package com.jcs.goboax.aulavirtual.validator;

import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CourseModelValidator
        implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return CourseModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors anErrors)
    {
        ValidationUtils.rejectIfEmpty(anErrors, "name", "course.name.empty");
    }
}
