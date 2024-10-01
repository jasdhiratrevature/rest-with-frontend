package com.revature.frontend.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.revature.frontend.model.CurrencyConversion;
import com.revature.frontend.service.CurrencyFrontendService;




@Controller
@RequestMapping("/currency-frontend")
public class CurrencyFrontendController {

	@Autowired
	CurrencyFrontendService currencyFrontendService;
	
	@GetMapping("/show-form")
	public String getHome() {
		return "myForm";
	}
	
	@GetMapping("form-submit")
	public ModelAndView getConversion(@RequestParam String from,@RequestParam String to,@RequestParam BigDecimal quantity) {
		 //CurrencyConversion currencyConversion=currencyConversionService.calculateCurrencyConversion(from, to, quantity);
		
		CurrencyConversion currencyConversion=currencyFrontendService.calculateCurrencyConversion(from, to, quantity);
		
		ModelAndView mav=new ModelAndView("currency-result");
		mav.addObject("from", currencyConversion.getFrom());
		mav.addObject("to",currencyConversion.getTo());
		mav.addObject("quantity",currencyConversion.getQuantity());
		mav.addObject("conversionMultiple", currencyConversion.getConversionMultiple());
		mav.addObject("totalValue", currencyConversion.getTotalCalculatedAmount());
		
		
		
		return mav;
	}
}
