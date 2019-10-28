package com.booking.booking.service;

import com.booking.booking.dto.BookingDto;
import com.booking.booking.entity.Booking;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookingService {

    Flux<Booking> getAvailableRooms();

    Flux<Booking> getBookingRooms();

    Mono<Booking> addBooking(BookingDto bookingDto);

    Mono<Void> deleteBooking(String bookingId);
}
