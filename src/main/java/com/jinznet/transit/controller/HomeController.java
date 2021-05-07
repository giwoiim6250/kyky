package com.jinznet.transit.controller;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{extension}", method = RequestMethod.GET)
	public ModelAndView home(@PathVariable("extension")String extension) {
		return new ModelAndView("index.ftl");
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) {
		return new ModelAndView("index.ftl");
	}
	
	@RequestMapping(value = "/dealer/index", method = RequestMethod.GET)
	public ModelAndView dealer(Locale locale, Model model) {
		return new ModelAndView("index.ftl");
	}
}
