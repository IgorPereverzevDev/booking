package com.booking.booking;

import com.booking.booking.entity.Booking;
import com.booking.booking.repository.BookingRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

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

    @Bean
    RouterFunction<ServerResponse> routes(BookingRepository repository) {
        return route()
                .GET("/rooms", serverRequest -> ok().body(repository.findAvailableRooms(), Booking.class))
                .GET("/bookings", serverRequest -> ok().body(repository.findAll(), Booking.class))
                .POST("/booking", serverRequest -> ok().body(repository.save()))
                .DELETE("/bookings/{id}", repository.deleteById(String.class))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

}
