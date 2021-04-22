package com.yk.theater.controller;

import com.yk.theater.dto.MovieInfo;
import com.yk.theater.mapper.CustomerMapper;
import com.yk.theater.mapper.MovieInfoMapper;
import com.yk.theater.mapper.ReservationMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieInfoController {
    private MovieInfoMapper movieInfoMapper;
    private ReservationMapper reservationMapper;
    private CustomerMapper customerMapper;

    public MovieInfoController(MovieInfoMapper movieInfoMapper, ReservationMapper reservationMapper, CustomerMapper customerMapper) {
        this.movieInfoMapper = movieInfoMapper;
        this.reservationMapper = reservationMapper;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/movie/all")
    public List<MovieInfo> getMovieInfos() {
        return movieInfoMapper.getAllMovieInfos();
    }

    @GetMapping("/reservation/{movieId}")
    public MovieInfo reservationForm(@PathVariable Long movieId) {
        return movieInfoMapper.findMovie(movieId);
    }

    @PostMapping("/reservation/{scheduleId}")
    public void reservation(@PathVariable Long scheduleId,
                            @RequestParam("tel") String tel,
                            @RequestParam("people") long people,
                            @RequestParam("seatRow") long seatRow,
                            @RequestParam("seatColumn") long seatColumn) {
        MovieInfo movieInfo = movieInfoMapper.findMovie(scheduleId);
        System.out.println("movie 정보 받아오기 성공!");
        int customerId = customerMapper.insertCustomer(tel, people);
        System.out.println("고객정보 입력 성공!");
        int seatId = reservationMapper.insertSeat(scheduleId, seatRow, seatColumn);
        System.out.println("좌석정보 입력 성공!");
        reservationMapper.insertReservation(customerId,scheduleId, people * movieInfo.getPrice(), seatId);
        System.out.println("예약정보 입력 성공!");
    }

}

