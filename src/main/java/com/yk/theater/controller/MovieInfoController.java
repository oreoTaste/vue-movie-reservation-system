package com.yk.theater.controller;

import com.yk.theater.dto.MovieInfo;
import com.yk.theater.mapper.CustomerMapper;
import com.yk.theater.mapper.ReservationMapper;
import com.yk.theater.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieInfoController {
    private MovieService movieService;
    private ReservationMapper reservationMapper;
    private CustomerMapper customerMapper;

    public MovieInfoController(MovieService movieService,
                               ReservationMapper reservationMapper,
                               CustomerMapper customerMapper) {
        this.movieService = movieService;
        this.reservationMapper = reservationMapper;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/movie/all")
    public List<MovieInfo> getMovieInfos() {
        return movieService.getAllMovies();
    }

    @GetMapping("/reservation/{movieId}")
    public MovieInfo reservationForm(@PathVariable Long movieId) {
        return movieService.getMovie(movieId);
    }

    @PostMapping("/reservation/{scheduleId}")
    public void reservation(@PathVariable Long scheduleId,
                            @RequestParam("tel") String tel,
                            @RequestParam("people") long people,
                            @RequestParam("seatRow") long seatRow,
                            @RequestParam("seatColumn") long seatColumn) {

        MovieInfo movieInfo = movieService.getMovie(scheduleId);
        System.out.println("movie 정보 받아오기 성공!");
        int customerId = customerMapper.insertCustomer(tel, people);
        System.out.println("고객정보 입력 성공!");
        int seatId = movieService.insertSeat(scheduleId, seatRow, seatColumn);
        System.out.println("좌석정보 입력 성공!");
        if(movieService.insertReservation(customerId,scheduleId, people * movieInfo.getPrice(), seatId)) {
            System.out.println("예약정보 입력 성공!");
        }
    }

}

