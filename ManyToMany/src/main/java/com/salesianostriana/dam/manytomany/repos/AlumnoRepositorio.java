package com.salesianostriana.dam.manytomany.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.manytomany.model.Alumno;

public interface AlumnoRepositorio
	extends JpaRepository<Alumno, Long>{

}
