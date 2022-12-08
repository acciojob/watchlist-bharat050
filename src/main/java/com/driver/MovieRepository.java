package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Repository
public class MovieRepository {
    @Autowired
    DBmanager dBmanager;

//    HashMap<String, Movie> movieList = new HashMap<>();
//    HashMap<String, Director> directorList = new HashMap<>();
//    HashMap<String, String> pair = new HashMap<>();
    public void addMovie(Movie movie) throws SQLException {
       dBmanager.insertMovie(movie);
    }

    public void addDirector(Director director) throws SQLException {
        dBmanager.insertDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) throws SQLException {
        dBmanager.insertIntoPairs(movie, director);
    }
    public String getMovieByName(String movie) throws SQLException {
        return dBmanager.getMovie(movie);
    }

    public String getDirectorByName(String director) throws SQLException {
        return dBmanager.getDirector(director);
    }

    public String getMoviesByDirectorName(String director) throws SQLException {
        return dBmanager.getAllMoviesByDirector(director);
    }
    public String getAllMovie() throws SQLException {
        return dBmanager.getAllMovies();
    }

    public void deleteDirectorByName(String director){
        dBmanager.deleteDirectorMovie(director);
    }

    public void deleteAllDirectors() throws SQLException {
        dBmanager.deleteAllDirectors();
    }
}
