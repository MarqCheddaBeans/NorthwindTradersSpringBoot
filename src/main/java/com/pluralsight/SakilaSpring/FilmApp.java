package com.pluralsight.SakilaSpring;

import com.pluralsight.SakilaSpring.dao.IFilmDao;
import com.pluralsight.SakilaSpring.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class FilmApp implements CommandLineRunner {

    //we are asking spring to inject a filmdao here
    //this is an example of dependency injection and inversion control
    @Autowired
    @Qualifier ("JbdcDao")
    private IFilmDao filmDao;

    @Override
    public void run(String... args) throws Exception{

        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println("""
                    +++++ Film Menu +++++
                    1)List All Films
                    2)Add A Film
                    3)Exit App                    
                    """);

            switch (scan.nextInt()){
                case(1):
                    displayAllFilms();
                    break;
                case(2):
                    System.out.println("Add a film");
                    break;
                case(3):
                    System.out.println("Bye");
                    System.exit(0);
            }
        }

    }

    private void displayAllFilms(){

        List<Film> films = filmDao.getAll();

        films.forEach(System.out::println);

    }

    private void addFilm(){

        System.out.println("""
                Add A Film
              
                """);

        Film film = new Film();
        film.setTitle("Coraline");
        film.setRentalRate(8.99);

        filmDao.add(film);

    }

}
