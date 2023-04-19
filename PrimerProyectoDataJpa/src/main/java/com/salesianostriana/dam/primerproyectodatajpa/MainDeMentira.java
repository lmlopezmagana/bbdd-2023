package com.salesianostriana.dam.primerproyectodatajpa;


import com.salesianostriana.dam.primerproyectodatajpa.modelo.Alumno;
import com.salesianostriana.dam.primerproyectodatajpa.repositorios.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component

public class MainDeMentira {

    @Autowired
    private AlumnoRepository repo;

    @PostConstruct
    public void ejecutar() {
        repo.save(new Alumno("Luis Miguel","López Magaña","luismi.lopez@salesianos.edu"));
        repo.save(new Alumno("Ángel","Naranjo González","angel.naranjo@salesianos.edu"));
        repo.save(new Alumno("Rafael", "Villar Liñán", "rafael.villar@salesianos.edu"));

        repo.findAll().forEach(System.out::println);
    }
}
