package com.salesianostriana.dam.demojpa;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.demojpa.modelo.Alumno;
import com.salesianostriana.dam.demojpa.modelo.Curso;
import com.salesianostriana.dam.demojpa.servicios.AlumnoServicio;
import com.salesianostriana.dam.demojpa.servicios.CursoServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final AlumnoServicio alumnoServicio;
	private final CursoServicio cursoServicio;
	
	
	@PostConstruct
	public void init() {
		
		List<Curso> cursos = List.of(
				new Curso("1º DAM", "Miguel Campos"),
				new Curso("2º DAM", "Luismi López"),
				new Curso("2º IEA", "Rafa Villar")
				);
		
		cursos.forEach(cursoServicio::save);
		
				
		Alumno a = new Alumno("Jesús", "Barco", "barco.esjes20@triana.salesianos.edu", cursoServicio.findById(1L).get());
		Alumno b = new Alumno("Luismi", "López", "luismi.lopez@salesianos.edu", cursoServicio.findById(1L).get());
		Alumno c = new Alumno("Ángel", "Naranjo", "angel@angel.com", cursoServicio.findById(2L).get());
		
		
		alumnoServicio.save(a);
		alumnoServicio.save(b);
		alumnoServicio.save(c);
	}

}
