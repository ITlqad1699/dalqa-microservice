package com.micro_core.limit_services.controller;

import com.micro_core.limit_services.config.Configuration;
import com.micro_core.limit_services.domain.Limits;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Limit controller.
 *
 * @Author: DaLQA
 * @Date: 2024-07-27 09:55
 */
@RestController
@RequestMapping(value = "/api/v1/limit")
@AllArgsConstructor
public class LimitController {
	Configuration config;
	
	@GetMapping()
	public Limits retrieveLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
	}
}
