package com.micro_core.currency_conversion_service.commom_package.utils;

import com.micro_core.currency_conversion_service.domain.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: DaLQA
 * @Date: 2024-07-28 10:18
 */
@FeignClient(name = "currency-exchanges-service", url = "localhost:8000/api/v1/currency-exchange")
public interface CurrencyConversionProxy {
	
	@GetMapping("/from/{from}/to/{to}")
	CurrencyConversion retrieveExchange(@PathVariable String from, @PathVariable String to);
}
