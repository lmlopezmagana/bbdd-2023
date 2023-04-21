package com.salesianostriana.dam.manytomany.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.manytomany.model.Curso;

public interface CursoRepositorio 
	extends JpaRepository<Curso, Long>{

}
