package com.yk.theater.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeatMapper {
    @Insert("INSERT INTO reservation_seat (" +
            "schedule_id" +
            ", seat_row" +
            ", seat_column" +
            ")" +
            "values(" +
            " " +
            ")")
    int insertCustomer(String tel, long people);
}
