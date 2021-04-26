package com.yk.theater.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeatInfo {
    private int seatId;
    private int row;
    private int col;

}
