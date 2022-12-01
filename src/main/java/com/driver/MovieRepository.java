package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Repository
public class MovieRepository {

    HashMap<String, Movie> movieList = new HashMap<>();
    HashMap<String, Director> directorList = new HashMap<>();
    HashMap<String, String> pair = new HashMap<>();
    public void addMovie(Movie movie){
        movieList.put(movie.getName(),movie);
    }

    public void addDirector(Director director){
        directorList.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director){
        pair.put(movie, director);
    }
    public Movie getMovieByName(String movie){
        return movieList.get(movie);
    }

    public Director getDirectorByName(String director){
        return directorList.get(director);
    }

    public List<String> getMoviesByDirectorName(String director){
        List<String> movies = new ArrayList<>();
        for(String movie : pair.keySet()){
            if(pair.get(movie).equals(director)){
                movies.add(movie);
            }
        }
        return movies;
    }
    public List<Movie> getAllMovie(){
        return new ArrayList<>(movieList.values());
    }

    public void deleteDirectorByName(String director){
        List<String> m = getMoviesByDirectorName(director);
        for(String movie : m){
            movieList.remove(movie);
        }
        directorList.remove(director);
    }

    public void deleteAllDirectors(){
        for(String director : directorList.keySet()){
            deleteDirectorByName(director);
        }
    }
}
