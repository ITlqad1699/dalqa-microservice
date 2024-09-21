package com.micro_core.currency_conversion_service.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

/**
 * @Author: DaLQA
 * @Date: 2024-07-27 10:12
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "currency_conversion")
public class CurrencyConversion {
	
	@Id
	private Long id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private String environment;
	
}
