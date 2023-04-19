package com.salesianostriana.dam.e01ejerciciodao.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.salesianostriana.dam.e01ejerciciodao.dao.CrudAlumno;
import com.salesianostriana.dam.e01ejerciciodao.modelo.Alumno;

public class CrudAlumnoEnMemoria implements CrudAlumno {
	
	private List<Alumno> listaAlumnos;
	
	
	public CrudAlumnoEnMemoria() {
		listaAlumnos = new ArrayList<>();
	}

	@Override
	public List<Alumno> findAll() {
		return listaAlumnos;
	}

	@Override
	public Alumno findById(long id) {
		// Versión con streams + lambda
		return listaAlumnos.stream().filter(x -> x.getId() == id).findFirst().get();
		
		// Versión sin lambdas
		/* boolean encontrado = false;
		 * Alumno resultado = null;
		for(int i = 0; i < listaAlumnos.size() && !encontrado; i++) {
			if (listaAlumnos.get(i).getId() == id) {
				encontrado = true;
				resultado = listaAlumnos.get(i);
			}
		}
		return resultado;
		*/
	}

	@Override
	public void insert(Alumno alumno) {
		listaAlumnos.add(alumno);
	}

	@Override
	public void edit(Alumno alumno) {
		
		// @formatter:off
		
		/*listaAlumnos
		.stream()
		.filter(x -> x.getId() == alumno.getId())
		.map((Alumno x) -> {
			x.setApellidos(alumno.getApellidos());
			x.setNombre(alumno.getNombre());
			x.setEmail(alumno.getEmail());
			x.setFechaNacimiento(alumno.getFechaNacimiento());
			
			return x;
		});*/
	
		// @formatter:on
		
		boolean encontrado = false;
		for(int i = 0; i < listaAlumnos.size() && !encontrado; i++) {
			if (listaAlumnos.get(i).getId() == alumno.getId()) {
				encontrado = true;
				listaAlumnos.get(i).setApellidos(alumno.getApellidos());
				listaAlumnos.get(i).setNombre(alumno.getNombre());
				listaAlumnos.get(i).setEmail(alumno.getEmail());
				listaAlumnos.get(i).setFechaNacimiento(alumno.getFechaNacimiento());
			}
		}
		
		
		
		
	}

	@Override
	public void delete(Alumno alumno) {
		listaAlumnos.remove(alumno);		
	}

}
