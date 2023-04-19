package com.salesianostriana.dam.ejemplo.servicios;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ejemplo.dao.CrudAlumno;
import com.salesianostriana.dam.ejemplo.modelo.Alumno;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlumnoServicio {
	
	private final CrudAlumno crudAlumno;
	
	public List<Alumno> getByOrdenAlfabetico() {
		return crudAlumno.findAll()
					.stream()
					.sorted(Comparator.comparing(Alumno::getApellidos))
					.collect(Collectors.toUnmodifiableList());
	}
	
	public List<Alumno> getByEdad() {
		return crudAlumno.findAll()
					.stream()
					.sorted(Comparator.comparing(Alumno::getEdad).reversed())
					.collect(Collectors.toUnmodifiableList());
	}
	
	/*
	private List<Alumno> getBy() {
		
	}
	*/
	
}
