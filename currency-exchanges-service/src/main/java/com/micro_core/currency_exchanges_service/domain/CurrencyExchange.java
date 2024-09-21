package com.micro_core.currency_exchanges_service.domain;

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
@Table(name = "currency_exchange")
public class CurrencyExchange {
	
	@Id
	private Long id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
}