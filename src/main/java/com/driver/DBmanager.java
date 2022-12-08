package com.driver;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DBmanager {

    public DBmanager() throws SQLException {
        getConnnection();
        createDirectorTable();
        createMovieTable();
        createPairTable();
    }
    public Connection connection;

    public Connection getConnnection() throws SQLException {
        if(connection== null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/watchlist", "root", "bharat");
        }
        return connection;
    }

    public void createMovieTable() throws SQLException {
        String sql = "create table if not exists movies(id INT(3) primary key auto_increment, name varchar(20)," +
                " durationInMinutes INT(3), imdbRating varchar(4))";
        Statement st = connection.createStatement();
        st.execute(sql);
    }
    public void createDirectorTable() throws SQLException {
        String sql = "create table if not exists directors(id INT(3) primary key auto_increment, name varchar(20)," +
                " numberOfMovies INT(3), imdbRating varchar(4))";
        Statement st = connection.createStatement();
        st.execute(sql);
    }
    public void createPairTable() throws SQLException {
        String sql = "create table if not exists movie_directors_pair(movie_name varchar(10), director_name varchar(20))";
        Statement st = connection.createStatement();
        st.execute(sql);
    }
    public void insertMovie(Movie movie) throws SQLException {
        String sql = "insert into movies(name, durationInMinutes, imdbRating) values('"+movie.getName()+"'," +
                ""+movie.getDurationInMinutes()+", '"+movie.getImdbRating()+"' )";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }
    public void insertDirector(Director director) throws SQLException {
        String sql = "insert into directors(name, numberOfMovies, imdbRating) values('"+director.getName()+"'," +
                ""+ director.getNumberOfMovies()+", '"+director.getImdbRating()+"' )";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }
    public void insertIntoPairs(String movie, String director) throws SQLException {
        String sql = "insert into movie_directors_pair(movie_name, director_name) values('"+movie+"', '"+director+"')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }
    public String getMovie(String movie) throws SQLException {
        String sql = "select * from movies where movies.name = '"+movie+"'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        StringBuilder ans = new StringBuilder();
        while(rs.next())
        {    String id = rs.getString("id");
            String name = rs.getString("name");
            String duration = rs.getString("durationInMinutes");
            String rating = rs.getString("imdbRating");
            ans.append(id+" "+ name+" "+duration+" "+rating);
        }
        return ans.toString();
    }
    public String getDirector(String director) throws SQLException {
        String sql = "select * from directors where directors.name = '"+director+"'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        StringBuilder ans = new StringBuilder();
        while(rs.next())
        {    String id = rs.getString("id");
            String name = rs.getString("name");
            String duration = rs.getString("numberOfMovies");
            String rating = rs.getString("imdbRating");
            ans.append(id+" "+ name+" "+duration+" "+rating);
        }
        return ans.toString();
    }
    public String getAllMovies() throws SQLException {
        String sql = "select * from movies";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        StringBuilder ans = new StringBuilder();
        while(rs.next()){
            ans.append(rs.getString("id")+" "+ rs.getString("name")+" "+
                    rs.getString("durationInMinutes")+" "+
                    rs.getString("imdbRating") +"\n");
        }
        return ans.toString();
    }
    public String getAllMoviesByDirector(String name) throws SQLException {
        String sql = "select * from movies m inner join movie_directors_pair pair on m.name = pair.movie_name" +
                " and pair.director_name = '"+name+"'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        StringBuilder ans =new StringBuilder();
        while(rs.next()){
            ans.append(rs.getString("id")+" "+ rs.getString("name")+" " +
                    rs.getString("durationInMinutes")+" "+
                    rs.getString("imdbRating") +"\n");
        }
        return ans.toString();
    }
    public void deleteDirectorMovie(String name){

    }
    public void deleteAllDirectors() throws SQLException {
        String sql = "truncate table directors";
        Statement st = connection.createStatement();
        st.execute(sql);
    }
}
