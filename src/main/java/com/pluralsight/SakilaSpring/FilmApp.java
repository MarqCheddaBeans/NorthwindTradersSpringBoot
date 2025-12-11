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
    @Qualifier ("jbdcFilmDao")
    private IFilmDao filmDao;

    public static Scanner scan = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception{

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
                    scan.nextLine();
                    addFilm();
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

        System.out.print("\nEnter film title: ");
        String title = scan.nextLine();

        // Ask the user for the film's rental rate.
        System.out.print("Enter film rental rate: ");
        double rentalRate = Double.parseDouble(scan.nextLine());

        // Create a new Film object and set its data.
        Film film = new Film();
        film.setTitle(title);
        film.setRentalRate(rentalRate);

        // Add the new film to the DAO (which stores it in memory).
        filmDao.add(film);

        // Let the user know that the film was added.
        System.out.println("Film added successfully.");

    }

}
