package br.com.rontec.webfluxcourse.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = { TrimStringValidator.class })
@Target(ElementType.FIELD)
@Retention(RUNTIME)
public @interface TrimString {
    String message() default "field cannot have blank space at the beginning or at end";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
