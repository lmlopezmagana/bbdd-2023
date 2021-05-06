package com.salesianostriana.dam.ejemplo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.ejemplo.modelo.Alumno;

@Repository
public class CrudAlumnoEnMemoria implements CrudAlumno {
	
	Map<Long, Alumno> alumnos = new HashMap<>();
	
	@Override
	public List<Alumno> findAll() {
		return Collections
				.unmodifiableList(
						new ArrayList<Alumno>(alumnos.values()));
	}

	@Override
	public Alumno findOne(long id) {
		return alumnos.get(id);
	}

	@Override
	public void insert(Alumno alumno) {
		long id = newId();
		alumno.setId(id);
		alumnos.put(id, alumno);
	}

	@Override
	public void edit(Alumno alumno) {
		if (alumno.getId() == 0) {
			throw new NoSuchElementException("No existe ningún alumno con ID: " + alumno.getId());
		}
		alumnos.put(alumno.getId(), alumno);
	}

	@Override
	public void delete(Alumno alumno) {
		alumnos.remove(alumno.getId(), alumno);
	}
	
	
	private long newId() {
		long max = alumnos
					.keySet()
					.stream()
					.max(Comparator.naturalOrder())
					.orElse(0L);
		return max + 1;			
	}

}
