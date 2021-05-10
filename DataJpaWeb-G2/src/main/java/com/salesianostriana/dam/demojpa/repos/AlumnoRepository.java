package com.salesianostriana.dam.demojpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.demojpa.modelo.Alumno;

public interface AlumnoRepository 
	extends JpaRepository<Alumno, Long> {

}
