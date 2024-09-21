package com.core_micro.api_gateway.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: DaLQA
 * @Date: 2024-07-29 00:07
 */
public class LoggingFilter implements GlobalFilter {
	private final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange,
	                         GatewayFilterChain chain) {
		logger.info("Path of the request received -> {}",
				exchange.getRequest().getPath());
		return chain.filter(exchange);
	}
}
