package com.revature.frontend.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.revature.frontend.model.CurrencyConversion;


@Service
public class CurrencyFrontendService {

	@Autowired
	private WebClient webClient;
	
	
	  public CurrencyConversion calculateCurrencyConversion( String from, String
	  to, BigDecimal quantity) {
	  
			
	  CurrencyConversion currencyConversion=
	  webClient.get().uri("http://currency-conversion", uriBuilder -> uriBuilder
			//  webClient.get().uri("http://localhost:8082", uriBuilder -> uriBuilder
	  .path("currency-conversion/from/{from}/to/{to}/quantity/{quantity}") .build(from,to,quantity)) .retrieve()
	  .bodyToMono(CurrencyConversion.class) .block();
	  
	  // use kafka here as a producer
	/*  kafkaTemplate.send("notificationTopic",new CurrencyEvent(this,
			  currencyConversion.getId(), currencyConversion.getFrom(), 
			  currencyConversion.getTo()));
		*/
		//System.out.println("notofocation sent");
	  return currencyConversion;
	  
		 
	  }
}
