drop table if exists `CURRENCY_CONVERSION` cascade;

CREATE TABLE `CURRENCY_CONVERSION`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `currency_from` varchar(100),
    `currency_to` varchar(100),
    `conversion_multiple` DOUBLE,
    `quantity` int,
    `total_calculated_amount` DOUBLE,
    `environment` varchar(500),
    PRIMARY KEY (`id`)
);

--`id`, `currency_from`, `currency_to`, `conversion_multiple`,`environment`