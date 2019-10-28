package com.booking.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private String id;
    private Date startDate;
    private Date endDate;
    private List<Room> rooms;
}
