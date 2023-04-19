package com.salesianostriana.dam.ejemplo;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.ejemplo.dao.CrudAlumno;
import com.salesianostriana.dam.ejemplo.modelo.Alumno;
import com.salesianostriana.dam.ejemplo.servicios.AlumnoServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppMain {
	
	private Logger log = LoggerFactory.getLogger(AppMain.class);
	
	private final AlumnoServicio servicio;
	private final CrudAlumno crud;
		
	@PostConstruct
	public void mimain() {

		crud.insert(new Alumno("Jesús", "Barco", "jesus.barco@email.com", LocalDate.of(2002, 4, 29)));
		crud.insert(new Alumno("Luismi", "López", "luismi.lopez@email.com", LocalDate.of(1982, 9, 18)));
		crud.insert(new Alumno("Guillermo", "De La Cruz", "guillermo.delacruz@email.com", LocalDate.of(1994, 9, 28)));

		System.out.println("TODOS LOS ALUMNOS POR ORDEN ALFABÉTICO");
		System.out.println("======================================");
		servicio.getByOrdenAlfabetico()
			.forEach(a -> log.debug(a.toString()));
		
		System.out.println("TODOS LOS ALUMNOS POR ORDEN DE EDAD");
		System.out.println("======================================");
		servicio.getByEdad()
			.forEach(System.out::println);
		
		
		
	}

}
