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
    public Flux<BookingDto> getAvailableRooms() {
        return bookingRepository.findAvailableRooms().map(r -> modelMapper.map(r, BookingDto.class));
    }

    @Override
    public Flux<BookingDto> getBookingRooms() {
        return bookingRepository.findBookingRooms().map(r -> modelMapper.map(r, BookingDto.class));
    }

    @Override
    public Mono<BookingDto> addBooking(BookingDto bookingDto) {
        Mono<Booking> room = bookingRepository.save(modelMapper.map(bookingDto, Booking.class));
        return Mono.create(r -> r.success(modelMapper.map(room, BookingDto.class)));
    }

    @Override
    public Mono<Void> deleteBooking(String bookingId) {
        return bookingRepository.deleteById(Long.parseLong(bookingId));
    }
}
