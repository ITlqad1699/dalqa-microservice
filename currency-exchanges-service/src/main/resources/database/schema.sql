drop table if exists `currency_exchange` cascade;

CREATE TABLE `currency_exchange`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `currency_from` varchar(100),
    `currency_to` varchar(100),
    `conversion_multiple` DOUBLE,
    `environment` varchar(500),
    PRIMARY KEY (`id`)
);

--`id`, `currency_from`, `currency_to`, `conversion_multiple`,`environment`