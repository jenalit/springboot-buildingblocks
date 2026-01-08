package com.learnwithranjan.restservices.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private ResourceBundleMessageSource bundleMessageSource;
	
	//@RequestMapping(method = RequestMethod.GET,path="/hello")
	@GetMapping("/helloo")
	public String helloWorld(){
		return "helloo world";
	}
	
	@GetMapping("/hello-beans")
	public UserDetails getUserDaeils() {
		return new UserDetails("litu", "jena", "bangalore");
	}

	
	@GetMapping("/hello-int")
	public String getMessageINI18NFormat(
	    @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {

	    Locale locale = (acceptLanguage == null || acceptLanguage.isBlank())
	        ? Locale.getDefault()
	        : Locale.forLanguageTag(acceptLanguage.split(",")[0].trim());

	    return bundleMessageSource.getMessage("label.hello", null, locale);
	}
	
	
	@GetMapping("/hello-int2")
	public String getMessageINI18NFormat2() {
	    return bundleMessageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}


}
