package com.shopping.kemosabe.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UserCredentialsValidator.class)
@Documented
public @interface UserCredentials {

    String message() default "{app.login.invalidCredentials}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


    String username();
    String password();

}