package com.salesianostriana.dam.manytomany.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.manytomany.model.Asignatura;

public interface AsignaturaRepositorio 
	extends JpaRepository<Asignatura, Long>{

}
