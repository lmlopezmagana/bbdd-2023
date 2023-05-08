package com.salesianostriana.dam.asociaciones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.asociaciones.model.Notas;
import com.salesianostriana.dam.asociaciones.model.NotasPK;

public interface NotasRepositorio 
	extends JpaRepository<Notas, NotasPK>{

}
