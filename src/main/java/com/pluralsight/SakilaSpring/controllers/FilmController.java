package com.pluralsight.SakilaSpring.controllers;

import com.pluralsight.SakilaSpring.dao.IFilmDao;
import com.pluralsight.SakilaSpring.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    @Qualifier("jbdcFilmDao")
    IFilmDao fDao;

    @GetMapping("/films")
    public List<Film> allFilms(){
        return fDao.getAll();
    }

    @PostMapping("/films")
    public void addFilm(@RequestBody Film film){
        fDao.add(film);
    }


}
