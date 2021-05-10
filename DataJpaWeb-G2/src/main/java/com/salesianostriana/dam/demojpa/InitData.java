package com.salesianostriana.dam.demojpa;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.demojpa.modelo.Alumno;
import com.salesianostriana.dam.demojpa.servicios.AlumnoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final AlumnoService servicio;
	
	@PostConstruct
	public void init() {
		
		Alumno a = new Alumno("Luismi", "López");
		Alumno b = new Alumno("Ángel", "Naranjo");
		Alumno c = new Alumno("Rafa", "Villar");

		servicio.save(a);
		servicio.save(b);
		servicio.save(c);
		
	}

}
