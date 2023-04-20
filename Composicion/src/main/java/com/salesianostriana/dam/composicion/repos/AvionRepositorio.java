package com.salesianostriana.dam.composicion.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.composicion.model.Avion;

public interface AvionRepositorio 
	extends JpaRepository<Avion, Long> {

}

