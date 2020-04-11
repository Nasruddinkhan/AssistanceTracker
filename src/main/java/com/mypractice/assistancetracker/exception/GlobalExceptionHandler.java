/**
 * nasru
 * GlobalExceptionHandler.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
}
