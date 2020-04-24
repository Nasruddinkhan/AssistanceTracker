/**
 * nasru
 * UniqueValidator.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author nasru
 *
 */
public class UniqueValidator implements ConstraintValidator<Unique, Object> {
	@Autowired
    private ApplicationContext applicationContext;

    private FieldValueExists service;
    private String fieldName;
	@Override
	public void initialize(Unique constraintAnnotation) {
		// TODO Auto-generated method stub
		Class<? extends FieldValueExists> clazz = constraintAnnotation.service();
		this.fieldName = constraintAnnotation.fieldName();
		String serviceQualifier = constraintAnnotation.serviceQualifier();
		System.out.println(serviceQualifier.getClass());
		if (!serviceQualifier.equals("")) {
			this.service = this.applicationContext.getBean(serviceQualifier, clazz);
		} else {
			System.out.println(this.applicationContext);
			//this.service = this.applicationContext.getBean(clazz);
		}
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println(fieldName+ " "+service);
		// return !this.service.fieldValueExists(value, this.fieldName);
		return true;
	}

}
