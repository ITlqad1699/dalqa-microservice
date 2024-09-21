package com.micro_core.currency_conversion_service.repository;

import com.micro_core.currency_conversion_service.domain.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Currency exchange repository.
 *
 * @Author: DaLQA
 * @Date: 2024 -07-27 19:42
 */
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
	/**
	 * Find by from and to currency exchange.
	 *
	 * @param from the from
	 * @param to   the to
	 * @return the currency exchange
	 */
	Optional<CurrencyConversion> findByFromAndTo(String from, String to);
}
