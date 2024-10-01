package com.revature.conversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.revature.conversion.model.CurrencyConversion;
import com.revature.conversion.service.CurrencyConversionService;


import java.net.ConnectException;
@RestController
public class CurrencyConversionController {

	@Autowired
	//private WebClient webClient;
	private CurrencyConversionService currencyConversionService;
	
	 @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	// @CircuitBreaker(name="myexchange",fallbackMethod = "fallbackMethod")
	// @TimeLimiter(name = "myexchange")
	  //  @Retry(name = "myexchange")
	    public CurrencyConversion calculateCurrencyConversion(
	            @PathVariable String from,
	            @PathVariable String to,
	            @PathVariable BigDecimal quantity
	    ) {

			
		 CurrencyConversion currencyConversion=currencyConversionService.calculateCurrencyConversion(from, to, quantity);
		 
	        return new CurrencyConversion(currencyConversion.getId(),
	                from, to, quantity,
	                currencyConversion.getConversionMultiple(),
	                quantity.multiply(currencyConversion.getConversionMultiple()));

	    }
		/*
		 * public CurrencyConversion fallbackMethod(String from, String to, BigDecimal
		 * quantity,Exception exception) { return new
		 * CurrencyConversion(1L,"Default Currency","Default Currency",
		 * BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.
		 * ZERO,"There is some server error at the moment");
		 * 
		 * }
		 */
}
