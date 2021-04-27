package com.yk.theater.mapper;

import com.yk.theater.dto.MovieInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieInfoMapper {
    @Select("SELECT" +
            "   *" +
            " FROM" +
            " movieInfo")
    List<MovieInfo> getAllMovieInfos();


    @Select("SELECT" +
            " *" +
            " FROM movieInfo" +
            " WHERE scheduleId = #{movieId}")
    MovieInfo findMovie(long movieId);
}
