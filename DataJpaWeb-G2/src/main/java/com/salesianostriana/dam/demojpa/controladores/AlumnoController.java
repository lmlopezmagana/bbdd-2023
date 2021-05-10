package com.salesianostriana.dam.demojpa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.demojpa.modelo.Alumno;
import com.salesianostriana.dam.demojpa.servicios.AlumnoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AlumnoController {
	
	private final AlumnoService servicio;
	
	@GetMapping("/alumnos")
	public String todosLosAlumnos(Model model) {
		model.addAttribute("alumnos", servicio.findAll());		
		return "index";
	}
	
	@GetMapping("/alumnos/{id}")
	public String unAlumno(
			@PathVariable("id") Long alumnoId, Model model) {
		Alumno a = servicio.findById(alumnoId).orElse(null);
		model.addAttribute("alumno", a);
		
		return "detail";
	}
	

}
