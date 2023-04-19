package com.salesianostriana.dam.demojpa.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.demojpa.modelo.Alumno;

public interface AlumnoRepository
	extends JpaRepository<Alumno, Long> {
	
	List<Alumno> findByApellidosContainsOrderByApellidosAsc(String apellidos);

	List<Alumno> findByCursoIdOrderByApellidosAsc(Long id);
	
	
}
