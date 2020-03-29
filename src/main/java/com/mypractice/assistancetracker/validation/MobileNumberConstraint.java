/**
 * nasru
 * ContactNumberConstraint.java
 * Mar 29, 2020
 */
package com.mypractice.assistancetracker.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * @author nasru
 *
 */
@Documented
@Constraint(validatedBy = MobileNumberValidation.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNumberConstraint {
	String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
