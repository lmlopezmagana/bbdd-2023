package com.salesianostriana.dam.manytoone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.manytoone.model.Curso;

public interface CursoRepositorio 
	extends JpaRepository<Curso, Long>{

}
