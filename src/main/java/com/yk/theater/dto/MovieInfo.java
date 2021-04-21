package com.yk.theater.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieInfo {
    private int scheduleId;
    private int roomNo;
    private String movieName;
    private String movieTime;
    private int price;
    private int seatRow;
    private int seatColumn;

}
