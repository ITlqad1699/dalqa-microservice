package com.micro_core.currency_exchanges_service.repository;

import com.micro_core.currency_exchanges_service.domain.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Currency exchange repository.
 *
 * @Author: DaLQA
 * @Date: 2024 -07-27 19:42
 */
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	/**
	 * Find by from and to currency exchange.
	 *
	 * @param from the from
	 * @param to   the to
	 * @return the currency exchange
	 */
	Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
