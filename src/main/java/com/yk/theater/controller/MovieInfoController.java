package com.yk.theater.controller;

import com.yk.theater.dto.*;
import com.yk.theater.mapper.CustomerMapper;
import com.yk.theater.mapper.ReservationMapper;
import com.yk.theater.service.MovieService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MovieInfoController {
    private MovieService movieService;
    private ReservationMapper reservationMapper;
    private CustomerMapper customerMapper;
    private Reservation reservation;

    public MovieInfoController(MovieService movieService,
                               ReservationMapper reservationMapper,
                               CustomerMapper customerMapper,
                               Reservation reservation) {
        this.movieService = movieService;
        this.reservationMapper = reservationMapper;
        this.customerMapper = customerMapper;
        this.reservation = reservation;
    }

    @GetMapping("/movie/all")
    public List<MovieInfo> getMovieInfos() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable long movieId) {
        System.out.println(movieId);
        return movieService.getMovie(movieId);
    }

    @GetMapping("/seat/{movieId}")
    public List<SeatInfo> getSeatInfos(@PathVariable long movieId) {
        return movieService.getAllSeats(movieId);
    }

    @GetMapping("/reservation/{movieId}")
    public MovieInfo reservationForm(@PathVariable long movieId) {
        return movieService.getMovie(movieId);
    }

    @PostMapping("/reservation/{scheduleId}")
    public Reservation reservation(@PathVariable long scheduleId,
                                  @RequestParam("tel") String tel,
                                  @RequestParam("people") long people,
                                  @RequestParam("seatRow") String seatRow,
                                  @RequestParam("seatColumn") String seatColumn,
                                  Model model) {

        System.out.println(scheduleId + ": " + tel+ ": " + people + ": " + seatRow+ ": " + seatColumn);
        MovieInfo movieInfo = movieService.getMovie(scheduleId);
        // 영화정보 받아오기
        if(movieInfo == null) {
            System.out.println("영화정보를 받을 수 없습니다.");
        }

        // 고객정보 입력하기
        CustomerInput cust = new CustomerInput(tel, people);
        customerMapper.insertCustomer(cust);

        // 좌석입력하기
        String seats = "";
        String[] rows = seatRow.split(",");
        String[] columns = seatColumn.split(",");
        for (int i = 0; i < rows.length; i++) {
            SeatInput seat = new SeatInput(scheduleId,
                                    rows[i].getBytes(StandardCharsets.US_ASCII)[0] - 64,
                                            Long.parseLong(columns[i]));
            movieService.insertSeat(seat);

            seats += seat.getSeatId();
            seats += ",";
        }

        // 예약정보입력하기
        ReservationInput reservation = new ReservationInput(cust.getCustomerId(),
                                                            scheduleId,
                                                            people * movieInfo.getPrice(),
                                                            seats);
        int reservationId = movieService.insertReservation(reservation);

        Reservation rsv = new Reservation();
        rsv.setReservationId(reservationId);
        rsv.setMovieInfo(movieInfo);
        rsv.setTel(tel);
        rsv.setPeople(people);
        rsv.setSeatRow(seatRow);
        rsv.setSeatColumn(seatColumn);
        return rsv;
    }

}

