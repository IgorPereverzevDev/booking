package com.booking.booking.service;

import com.booking.booking.dto.BookingDto;
import com.booking.booking.entity.Booking;
import com.booking.booking.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public Flux<Booking> getAvailableRooms() {
        return bookingRepository.findAvailableRooms();
    }

    @Override
    public Flux<Booking> getBookingRooms() {
        return bookingRepository.findAll();
    }

    @Override
    public Mono<Booking> addBooking(BookingDto bookingDto) {
        return bookingRepository.save(modelMapper.map(bookingDto, Booking.class));
    }

    @Override
    public Mono<Void> deleteBooking(String bookingId) {
        return bookingRepository.deleteById(Long.parseLong(bookingId));
    }
}
