package com.yk.theater.controller;

import com.yk.theater.dto.MovieInfo;
import com.yk.theater.mapper.MovieInfoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieInfoController {
    private MovieInfoMapper movieInfoMapper;

    public MovieInfoController(MovieInfoMapper movieInfoMapper) {
        this.movieInfoMapper = movieInfoMapper;
    }

    @GetMapping("/movie/all")
    public List<MovieInfo> getMovieInfos() {
        return movieInfoMapper.getAllMovieInfos();
    }
}
