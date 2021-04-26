package com.yk.theater.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationInput {

    private int reservationId;
    private int customerId;
    private long scheduleId;
    private long totalPrice;
    private String seatId;

    public ReservationInput(int customerId,
                            long scheduleId,
                            long totalPrice,
                            String seatId) {
        this.customerId = customerId;
        this.scheduleId = scheduleId;
        this.totalPrice = totalPrice;
        this.seatId = seatId;
    }
}
