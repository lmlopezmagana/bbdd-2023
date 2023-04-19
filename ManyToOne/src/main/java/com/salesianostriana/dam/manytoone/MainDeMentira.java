package com.salesianostriana.dam.manytoone;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.manytoone.model.Alumno;
import com.salesianostriana.dam.manytoone.model.Curso;
import com.salesianostriana.dam.manytoone.repos.AlumnoRepositorio;
import com.salesianostriana.dam.manytoone.repos.CursoRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {
	
	private final AlumnoRepositorio alumnoRepositorio;
	private final CursoRepositorio cursoRepositorio;
	
	@PostConstruct
	public void ejecutar() {
		
		Alumno a1 = new Alumno();
		a1.setNombre("Pepe");
		a1.setApellidos("Pérez Pérez");
		a1.setEmail("pepe@gmail.com");
		
		Alumno a2 = new Alumno();
		a2.setNombre("María");
		a2.setApellidos("Ruiz Hidalgo");
		a2.setEmail("lamari14@msn.com");
		
		alumnoRepositorio.save(a1);
		alumnoRepositorio.save(a2);
		
		Curso c = new Curso();
		c.setNombre("1º DAM");
		c.setTutor("Miguel");
		
		cursoRepositorio.save(c);
		
		a1.setCurso(c);
		a2.setCurso(c);

		alumnoRepositorio.save(a1);
		alumnoRepositorio.save(a2);

		
		List<Curso> cursos = 
				cursoRepositorio.findAll();
		
		for(Curso curso : cursos) {
			System.out.println(curso);
		}
		
	}

}
