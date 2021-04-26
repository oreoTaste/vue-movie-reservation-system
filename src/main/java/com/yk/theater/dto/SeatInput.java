package com.yk.theater.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeatInput {
    private int seatId;
    private long scheduleId;
    private long seatRow;
    private long seatColumn;

    public SeatInput(long scheduleId, long seatRow, long seatColumn) {
        this.scheduleId = scheduleId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }
}
