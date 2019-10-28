package com.booking.booking.service;

import com.booking.booking.dto.BookingDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookingService {

    Flux<BookingDto> getAvailableRooms();

    Flux<BookingDto> getBookingRooms();

    Mono<BookingDto> addBooking(BookingDto bookingDto);

    Mono<Void> deleteBooking(String bookingId);
}
