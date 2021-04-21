package com.yk.theater.mapper;

import com.yk.theater.dto.MovieInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieInfoMapper {
    @Select("SELECT SCHEDULE_ID as scheduleId" +
                    ", ROOM_NO as roomNo" +
                    ", MOVIE_NAME as movieName" +
                    ", MOVIE_TIME as movieTime" +
                    ", price" +
                    ", SEAT_ROW as seatRow" +
                    ", SEAT_COLUMN as seatColumn" +
                    " FROM SCHEDULE")
    List<MovieInfo> getAllMovieInfos();


}
