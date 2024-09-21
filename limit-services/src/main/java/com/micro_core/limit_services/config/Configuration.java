package com.micro_core.limit_services.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: DaLQA
 * @Date: 2024-07-27 11:18
 */
@Getter
@Setter
@Component
@ConfigurationProperties("limits-services")
public class Configuration {
	private int maximum;
	private int minimum;
}
