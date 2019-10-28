package com.booking.booking.entity;

import com.booking.booking.constant.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String id;
    private Type type;
}
