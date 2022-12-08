package com.driver;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie) throws SQLException {
        movieService.addMovie(movie);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director) throws SQLException {
        movieService.addDirector(director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName,
                                                       @RequestParam("director") String directorName) throws SQLException {
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<String> getMovieByName(@PathVariable("name") String movieName) throws SQLException {

        return new ResponseEntity<>(movieService.getMovieByName(movieName), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<String> getDirectorByName(@PathVariable("name") String directorName) throws SQLException {

        return new ResponseEntity<>(movieService.getDirectorByName(directorName), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<String> getMoviesByDirectorName(@PathVariable("director") String directorName) throws SQLException {

        return new ResponseEntity<>(movieService.getMoviesByDirectorName(directorName), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<String> findAllMovies() throws SQLException {

        return new ResponseEntity<>(movieService.getAllMovie(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String directorName){
        movieService.deleteDirectorsByName(directorName);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() throws SQLException {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
}
