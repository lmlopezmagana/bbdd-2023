package com.salesianostriana.dam.asociaciones.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.asociaciones.model.Alumno;
import com.salesianostriana.dam.asociaciones.model.Curso;
import com.salesianostriana.dam.asociaciones.services.AlumnoServicio;
import com.salesianostriana.dam.asociaciones.services.CursoServicio;
import com.salesianostriana.dam.asociaciones.services.MatriculaNotasServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MatriculaControlador {
	
	private final AlumnoServicio alumnoServicio;
	private final CursoServicio cursoServicio;
	private final MatriculaNotasServicio matriculaNotasServicio;
	
	
	@GetMapping("/matricula/curso/{id}")
	public String matriculaCompletaCurso(@PathVariable Long id) {
		
		//Optional<Alumno> alumno = alumnoServicio.findById(1L);
		//Optional<Curso> curso = cursoServicio.findById(id);
		Alumno alumno = alumnoServicio.findById(1L).orElse(null);
		Curso curso = cursoServicio.findById(1L).orElse(null);
		
		// 
		alumno = matriculaNotasServicio.matriculaCurso(alumno, curso);
		
		System.out.println(alumno);
		System.out.println(alumno.getNotas());
		
		return "index";
	}

}
