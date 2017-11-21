package mum.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.exception.OrderNotFoundException;

@ControllerAdvice
public class RiderExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, OrderNotFoundException exception) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		
		return mav;
	}
	


}
