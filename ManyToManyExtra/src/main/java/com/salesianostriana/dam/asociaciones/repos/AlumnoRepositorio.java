package com.salesianostriana.dam.asociaciones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.asociaciones.model.Alumno;

public interface AlumnoRepositorio
	extends JpaRepository<Alumno, Long>{

}
