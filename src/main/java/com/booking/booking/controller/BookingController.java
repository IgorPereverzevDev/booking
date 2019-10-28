package com.booking.booking.controller;

import com.booking.booking.dto.BookingDto;
import com.booking.booking.service.BookingService;
import com.booking.booking.service.BookingServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@RestController
public class BookingController {

    private BookingService employeeService;

    public BookingController(BookingServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    Flux<BookingDto> greet(RoomRequest request) {
        return Flux.fromStream(Stream.generate(() -> new BookingDto()))
                .delayElements(Duration.ofSeconds(1));
    }

    Flux<BookingDto> greet(RoomRequest request) {
        return Flux.fromStream(Stream.generate(() -> new BookingDto()))
                .delayElements(Duration.ofSeconds(1));
    }

    @RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
    Flux<BookingDto> (BookingDto request) {
        return Flux.fromStream(Stream.generate(() -> new BookingDto()))
                .delayElements(Duration.ofSeconds(1));
    }

    Flux<BookingDto> greet(RoomRequest request) {
        return Flux.fromStream(Stream.generate(() -> new BookingDto()))
                .delayElements(Duration.ofSeconds(1));
    }


}
