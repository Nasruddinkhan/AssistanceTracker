/**
 * nasru
 * FieldValueExists.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.validation;

/**
 * @author nasru
 *
 */
public interface FieldValueExists {
	  boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException;
}
