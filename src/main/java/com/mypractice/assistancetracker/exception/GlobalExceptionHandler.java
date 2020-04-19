/**
 * nasru
 * GlobalExceptionHandler.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.exception;

import java.util.Date;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mypractice.assistancetracker.dto.ErrorDetails;
import com.mypractice.assistancetracker.util.CommonUtils;


/**
 * @author nasru
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({Exception.class, RuntimeException.class})
	public final ModelAndView globleExcpetionHandler(HttpServletRequest req, Exception ex) throws Exception {
		ex.printStackTrace();
		if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
			throw ex;
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(CommonUtils.DEFAULT_ERROR_VIEW);
		return mav;
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<Object>  entityNotFound(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
