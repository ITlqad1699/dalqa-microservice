package com.micro_core.limit_services.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: DaLQA
 * @Date: 2024-07-27 10:12
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Limits {
	private int maximum;
	private int minimum;
}
