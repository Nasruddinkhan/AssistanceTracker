/**
 * nasru
 * MobileNumberValidation.java
 * Mar 29, 2020
 */
package com.mypractice.assistancetracker.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author nasru
 *
 */
public class MobileNumberValidation implements ConstraintValidator<MobileNumberConstraint,String>{

	@Override
	public void initialize(MobileNumberConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}



}
