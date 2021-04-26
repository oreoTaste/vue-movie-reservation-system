package com.yk.theater.mapper;

import com.yk.theater.dto.ReservationInput;
import com.yk.theater.dto.SeatInfo;
import com.yk.theater.dto.SeatInput;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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
    @Options(useGeneratedKeys = true, keyColumn = "seat_id", keyProperty = "seatId")
    int insertSeat(SeatInput seat);

    @Insert("INSERT INTO reservation ("
                + "   CUSTOMER_ID"
                + " , SCHEDULE_ID"
                + " , TOTAL_PRICE"
                + " , SEAT_ID"
                + ")"
                + " VALUES ("
                + " #{customerId}"
                + ", #{scheduleId}"
                + ", #{totalPrice}"
                + ", #{seatId}"
                + ")")
    @Options(useGeneratedKeys = true, keyColumn = "reservation_id", keyProperty = "reservationId")
    int insertReservation(ReservationInput reservationInput);


    @Select("SELECT"
            + " *"
            + " FROM reservation_seat "
            + " WHERE schedule_id = #{movieId}")
    List<SeatInfo> getAllSeats(Long movieId);
}
