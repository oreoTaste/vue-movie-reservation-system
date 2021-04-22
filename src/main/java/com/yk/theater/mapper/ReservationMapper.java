package com.yk.theater.mapper;

import com.yk.theater.dto.MovieInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReservationMapper {
    @Insert("INSERT INTO reservation_seat ("
            + "  schedule_id"
            + ", seat_row"
            + ", seat_column"
            + ")"
            + " VALUES ("
            + " #{scheduleId}"
            + " , #{seatRow}"
            + " , #{seatColumn}"
            + ");")
    int insertSeat(Long scheduleId, long seatRow, long seatColumn);

    @Insert("INSERT INTO reservation ("
                + "   CUSTOMER_ID"
                + " , SCHEDULE_ID"
                + " , TOTAL_PRICE"
                + " , SEAT_ID"
                + ")"
                + " VALUES ("
                + " #{customerId}"
                + " #{scheduleId}"
                + " #{totalPrice}"
                + " #{seatId}"
                + ");")
    boolean insertReservation(long customerId, long scheduleId, long totalPrice, long seatId);


}
