package com.jinznet.transit.controller;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@RestController
public class ErrorController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) {
		return new ModelAndView("error.ftl");
	}
}
