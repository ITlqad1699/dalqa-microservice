package com.core_micro.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Api gateway configuration.
 *
 * @Author: DaLQA
 * @Date: 2024 -07-28 23:03
 */
@Configuration
public class ApiGatewayConfiguration {
	public static final String URI_PREFIX_V1 = "/api/v1";
	public static final String LB_CURRENCY_CONVERSION_SERVICE = "lb://currency-conversion-service";
	public static final String LB_CURRENCY_EXCHANGES_SERVICE = "lb://currency-exchanges-service";
	
	/**
	 * Gate way route route locator.
	 *
	 * @param builder the builder
	 * @return the route locator
	 */
	@Bean
	public RouteLocator gateWayRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path(URI_PREFIX_V1 + "/currency-exchange/**")
						.uri(LB_CURRENCY_EXCHANGES_SERVICE))
				.route(p -> p.path(URI_PREFIX_V1 + "/currency-conversion/**")
						.uri(LB_CURRENCY_CONVERSION_SERVICE))
				.route(p -> p.path(URI_PREFIX_V1 + "/currency-conversion/{segment}/feign")
						.uri(LB_CURRENCY_CONVERSION_SERVICE))
				.route(p -> p.path(URI_PREFIX_V1 + "/currency-conversion-new/**")
						.filters(f -> f.rewritePath(
								URI_PREFIX_V1 + "/currency-conversion-new/(?<segment>.*)",
								URI_PREFIX_V1 + "/currency-conversion/${segment}/feign"))
						
						.uri(LB_CURRENCY_CONVERSION_SERVICE))
				.build();
	}
}
