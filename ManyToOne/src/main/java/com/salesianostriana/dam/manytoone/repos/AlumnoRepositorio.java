package com.salesianostriana.dam.manytoone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.manytoone.model.Alumno;

public interface AlumnoRepositorio
	extends JpaRepository<Alumno, Long>{

}
