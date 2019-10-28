package com.booking.booking.controller;

import com.booking.booking.dto.BookingDto;
import com.booking.booking.service.BookingService;
import com.booking.booking.service.BookingServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookingController {

    private BookingService employeeService;

    public BookingController(BookingServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = {"/rooms"})
    Flux<BookingDto> getAvailableRooms() {
        return employeeService.getAvailableRooms();
    }

    @PostMapping(value = {"/booking"})
    Mono<BookingDto> createBooking(BookingDto request) {
        return employeeService.addBooking(request);
    }

    @GetMapping(value = {"/bookings"})
    Flux<BookingDto> getBookings() {
        return employeeService.getBookingRooms();
    }

    @DeleteMapping(value = {"/bookings/id"})
    Mono<Void> cancelBooking(BookingDto request) {
        return employeeService.deleteBooking(request.getId());
    }

}
