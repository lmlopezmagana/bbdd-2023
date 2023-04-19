package com.salesianostriana.dam.ejemplo.dao;

import java.util.List;

import com.salesianostriana.dam.ejemplo.modelo.Alumno;

public interface CrudAlumno {
	
	List<Alumno> findAll();
	Alumno findOne(long id);
	void insert(Alumno alumno);
	void edit(Alumno alumno);
	void delete(Alumno alumno);

}
