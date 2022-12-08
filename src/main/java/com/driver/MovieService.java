package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Component
@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie) throws SQLException {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) throws SQLException {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) throws SQLException {
        movieRepository.addMovieDirectorPair(movie, director);
    }
    public String getMovieByName(String movie) throws SQLException {
        return movieRepository.getMovieByName(movie);
    }

    public String getDirectorByName(String director) throws SQLException {
        return movieRepository.getDirectorByName(director);
    }

    public String getMoviesByDirectorName(String director) throws SQLException {
        return movieRepository.getMoviesByDirectorName(director);
    }
    public String getAllMovie() throws SQLException {
        return movieRepository.getAllMovie();
    }

    public void deleteDirectorsByName(String director){
        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() throws SQLException {
        movieRepository.deleteAllDirectors();
    }
}
