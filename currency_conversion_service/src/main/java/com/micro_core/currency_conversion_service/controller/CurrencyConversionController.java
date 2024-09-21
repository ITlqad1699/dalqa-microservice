package com.micro_core.currency_conversion_service.controller;

import com.micro_core.currency_conversion_service.domain.CurrencyConversion;
import com.micro_core.currency_conversion_service.feign_proxy.CurrencyConversionProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * The type Currency exchange controller.
 */
@RestController
@RequestMapping(value = "/api/v1/currency-conversion")
@AllArgsConstructor
public class CurrencyConversionController {
	
	/**
	 * The Uri.
	 */
	static final String URI = "http://localhost:8000/api/v1/currency-exchange/from/";
	
	/**
	 * The Proxy.
	 */
	CurrencyConversionProxy proxy;
	
	/**
	 * Retrieve exchange currency exchange.
	 *
	 * @param from     the from
	 * @param to       the to
	 * @param quantity the quantity
	 * @return the currency exchange
	 */
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
	                                                      @PathVariable String to,
	                                                      @PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity(URI + "{from}/to/{to}", CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currencyConversion = response.getBody();
		if (currencyConversion == null) {
			throw new RuntimeException("Can not convert from " + from + " to " + to);
		}
		
		return CurrencyConversion.builder()
				.id(currencyConversion.getId())
				.from(from)
				.to(to)
				.conversionMultiple(currencyConversion.getConversionMultiple())
				.totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
				.quantity(quantity)
				.environment(currencyConversion.getEnvironment() + "rest template")
				.build();
	}
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}/feign")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
	                                                           @PathVariable String to,
	                                                           @PathVariable BigDecimal quantity) {
		
		CurrencyConversion currencyConversion = proxy.retrieveExchange(from, to);
		
		return CurrencyConversion.builder()
				.id(currencyConversion.getId())
				.from(from)
				.to(to)
				.conversionMultiple(currencyConversion.getConversionMultiple())
				.totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
				.quantity(quantity)
				.environment(currencyConversion.getEnvironment() + "feign way")
				.build();
	}
}
