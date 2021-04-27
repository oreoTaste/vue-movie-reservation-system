package com.yk.theater.service;

import com.yk.theater.dto.MovieInfo;
import com.yk.theater.dto.ReservationInput;
import com.yk.theater.dto.SeatInfo;
import com.yk.theater.dto.SeatInput;
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

    public MovieInfo getMovie(long movieId) {
        return movieInfoMapper.findMovie(movieId);
    }

    public int insertSeat(SeatInput seat) {
        return reservationMapper.insertSeat(seat);
    }

    public int insertReservation(ReservationInput reservationInput) {
        return reservationMapper.insertReservation(reservationInput);
    }

    public List<SeatInfo> getAllSeats(long movieId) {
        return reservationMapper.getAllSeats(movieId);
    }
}
