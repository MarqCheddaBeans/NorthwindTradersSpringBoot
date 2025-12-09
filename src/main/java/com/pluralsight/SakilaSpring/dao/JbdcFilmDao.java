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

    }

    @Override
    public List<Film> getAll() {

        List<Film> films = new ArrayList<>();

        try(
                Connection c = ds.getConnection();
                PreparedStatement q = c.prepareStatement("""
                        SELECT *
                        FROM films
                        """)
                ){
            ResultSet r = q.executeQuery();
            while(r.next()){
                String
            }

        }catch(SQLException e){
            System.out.println("Oh No");
        }
    }
}
