package pl.kamiljacko.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = BirthDayValidator.class)
public @interface AtLeast4YearsOld {

    String message() default "{pl.kamiljacko.validation.AtLeast4YearsOdl.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}