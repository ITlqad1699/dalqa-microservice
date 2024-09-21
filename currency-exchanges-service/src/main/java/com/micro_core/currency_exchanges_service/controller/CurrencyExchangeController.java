package com.micro_core.currency_exchanges_service.controller;

import com.micro_core.currency_exchanges_service.domain.CurrencyExchange;
import com.micro_core.currency_exchanges_service.repository.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * The type Currency exchange controller.
 */
@RestController
@RequestMapping(value = "/api/v1/currency-exchange")
@AllArgsConstructor
public class CurrencyExchangeController {
	
	/**
	 * The Environment.
	 */
	Environment environment;
	
	/**
	 * The Currency exchange repository.
	 */
	CurrencyExchangeRepository exchangeRepository;
	
	/**
	 * Retrieve exchange currency exchange.
	 *
	 * @param from the from
	 * @param to   the to
	 * @return the currency exchange
	 */
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchange(@PathVariable String from,
	                                         @PathVariable String to) {
		Optional<CurrencyExchange> currencyExchange = exchangeRepository.findByFromAndTo(from, to);
		if (currencyExchange.isEmpty()) {
			throw new RuntimeException("Could not find data exchange for " + from + " to " + to);
		}
		
		currencyExchange.get().setEnvironment(environment.getProperty("local.server.port"));
		
		return currencyExchange.get();
	}
}
