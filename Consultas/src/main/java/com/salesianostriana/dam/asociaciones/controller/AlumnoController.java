package com.salesianostriana.dam.asociaciones.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.asociaciones.model.Alumno;
import com.salesianostriana.dam.asociaciones.services.AlumnoServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/alumno/")
@RequiredArgsConstructor
public class AlumnoController {
	
	private final AlumnoServicio alumnoServicio;
	
	 @GetMapping("/")
	 public String buscarPorApellidos(
			 @RequestParam("ape") String apellido) {
		 
		 
		 List<Alumno> result = alumnoServicio.buscarPorApellido(apellido);

		 result.forEach(System.out::println);
		 return "list"; // la plantilla no existe
	 }
	 
	 @GetMapping("/buscar")
	 public String buscar(
			 @RequestParam("q") String consulta) {
		 
		 
		 List<Alumno> result = alumnoServicio.buscarPorCualquierCosa(consulta);

		 result.forEach(System.out::println);
		 return "list"; // la plantilla no existe
	 }
	

}
