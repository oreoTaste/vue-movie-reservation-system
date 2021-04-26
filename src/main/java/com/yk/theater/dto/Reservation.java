package com.yk.theater.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class Reservation {
    private int reservationId;
    private MovieInfo movieInfo;
    private String tel;
    private long people;
    private String seatRow;
    private String seatColumn;
}
