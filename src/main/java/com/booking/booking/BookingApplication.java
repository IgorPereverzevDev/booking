package com.booking.booking;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.reactive.TransactionalOperator;

@SpringBootApplication
@EnableTransactionManagement
public class BookingApplication {

    @Bean
    ReactiveTransactionManager transactionManager(@Qualifier("connectionFactory") ConnectionFactory cf) {
        return new R2dbcTransactionManager(cf);
    }

    @Bean
    TransactionalOperator transactionalOperator(@Qualifier("transactionManager") ReactiveTransactionManager txm) {
        return TransactionalOperator.create(txm);
    }

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

}
