package com.salesianostriana.dam.serviciobase.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.serviciobase.model.Alumno;

public interface AlumnoRepositorio 
	extends JpaRepository<Alumno, Long> {

}
