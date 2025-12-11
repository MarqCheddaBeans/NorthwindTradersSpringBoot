package com.pluralsight.SakilaSpring.dao;

import com.pluralsight.SakilaSpring.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JbdcFilmDao implements IFilmDao{

    @Autowired
    private DataSource ds;

    @Override
    public void add(Film film) {

        String sql = "INSERT INTO film (title, rental_rate, language_id) VALUES(?,?,?)";

        try(Connection c = ds.getConnection();
            PreparedStatement q = c.prepareStatement(sql)
        ){
            q.setString(1, film.getTitle());
            q.setDouble(2, film.getRentalRate());

            q.setInt(3,1);

            q.executeUpdate();
        }catch (SQLException e){
            System.out.println("WHAT DID YOU DO!");
        }

    }

    @Override
    public List<Film> getAll() {

        List<Film> films = new ArrayList<>();

        try(
                Connection c = ds.getConnection();
                PreparedStatement q = c.prepareStatement("""
                        SELECT film_id,title,rental_rate
                        FROM film
                        """);
                ResultSet r = q.executeQuery()
                ){
            while (r.next()) {
                // Create a new Film object.
                Film film = new Film();

                // Set the film's ID from the "film_id" column.
                film.setFilmID(r.getInt("film_id"));

                // Set the film's title from the "title" column.
                film.setTitle(r.getString("title"));

                // Set the film's rental rate from the "rental_rate" column.
                film.setRentalRate(r.getDouble("rental_rate"));

                // Add the Film object to our list.
                films.add(film);
            }

        }catch(SQLException e){
            System.out.println("Oh No");
        }
        return films;
    }
}
