package com.yk.theater.service;

import com.yk.theater.dto.MovieInfo;
import com.yk.theater.mapper.MovieInfoMapper;
import com.yk.theater.mapper.ReservationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieInfoMapper movieInfoMapper;
    private ReservationMapper reservationMapper;

    public MovieService(MovieInfoMapper movieInfoMapper,
                        ReservationMapper reservationMapper) {
        this.movieInfoMapper = movieInfoMapper;
        this.reservationMapper = reservationMapper;
    }
    public List<MovieInfo> getAllMovies() {
        return movieInfoMapper.getAllMovieInfos();
    }

    public MovieInfo getMovie(Long movieId) {
        return movieInfoMapper.findMovie(movieId);
    }

    public int insertSeat(Long scheduleId, long seatRow, long seatColumn) {
        return reservationMapper.insertSeat(scheduleId, seatRow, seatColumn);
    }

    public boolean insertReservation(int customerId, Long scheduleId, long totalPrice, int seatId) {
        return reservationMapper.insertReservation(customerId, scheduleId, totalPrice, seatId);
    }
}
