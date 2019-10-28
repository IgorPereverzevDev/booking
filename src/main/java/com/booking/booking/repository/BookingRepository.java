package com.booking.booking.repository;

import com.booking.booking.entity.Booking;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface BookingRepository extends ReactiveCrudRepository<Booking, Long> {

    @Query("SELECT * FROM room JOIN booking ON room.id = booking.id")
    Flux<Booking> findBookingRooms();

    @Query("SELECT * FROM room AS r WHERE r.id NOT IN(SELECT m.room_id FROM booking AS b\n" +
            " JOIN booking_map AS m ON b.id = m.id")
    Flux<Booking> findAvailableRooms();

}
