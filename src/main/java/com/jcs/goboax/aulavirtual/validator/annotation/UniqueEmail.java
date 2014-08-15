package com.jcs.goboax.aulavirtual.validator.annotation;

import com.jcs.goboax.aulavirtual.validator.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail
{
    String message() default "{UniqueEmail.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
