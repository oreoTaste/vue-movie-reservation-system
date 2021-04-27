package com.yk.theater.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class MovieInfo {
    private int scheduleId;
    private int roomNo;
    private String movieName;
    private String movieTime;
    private int price;
    private int totalSeats;
    private int reservedSeats;
    private int seatRow;
    private int seatColumn;


}
