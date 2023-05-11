package com.salesianostriana.dam.asociaciones.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.asociaciones.model.Alumno;
import com.salesianostriana.dam.asociaciones.model.Asignatura;
import com.salesianostriana.dam.asociaciones.model.Curso;
import com.salesianostriana.dam.asociaciones.model.Notas;
import com.salesianostriana.dam.asociaciones.model.NotasPK;
import com.salesianostriana.dam.asociaciones.repos.NotasRepositorio;
import com.salesianostriana.dam.asociaciones.services.base.BaseServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatriculaNotasServicio 
	extends BaseServiceImpl<Notas, NotasPK, NotasRepositorio>{

	private final AlumnoServicio alumnoServicio;
	
	// Método que matricula a un alumno en todas
	// las asignaturas de un curso.
	public Alumno matriculaCurso(Alumno a, Curso c) {
		a.addToCurso(c);
		alumnoServicio.save(a);
		
		for (Asignatura asig : c.getAsignaturas()) {
			Notas n = new Notas(a, asig);
			n.addToAlumno(a);
			this.save(n);
		}
		
		return a;
		
	}
	
	
}
