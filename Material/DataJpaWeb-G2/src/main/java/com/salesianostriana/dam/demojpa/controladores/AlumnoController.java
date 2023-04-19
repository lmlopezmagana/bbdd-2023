package com.salesianostriana.dam.demojpa.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.demojpa.modelo.Alumno;
import com.salesianostriana.dam.demojpa.modelo.Curso;
import com.salesianostriana.dam.demojpa.modelo.DatosMaestros;
import com.salesianostriana.dam.demojpa.servicios.AlumnoServicio;
import com.salesianostriana.dam.demojpa.servicios.CursoServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AlumnoController {
	
	private final AlumnoServicio servicio;
	private final CursoServicio cursoServicio;
	
	@GetMapping({"/", "/alumnos"})
	public String todosLosAlumnos(Model model, 
			@RequestParam("q") Optional<String> consulta) {
		
		List<Alumno> alumnos;
		
		if (consulta.isEmpty()) {
			alumnos = servicio.findAll();
		} else {
			alumnos = servicio.buscarPorApellido(consulta.get());
		}

		model.addAttribute("alumnos", alumnos);					

		return "index";
	}
	
	@GetMapping("/alumnos/curso/{id}")
	public String todosLosAlumnos(Model model, 
			@PathVariable("id") Long id) {
		
		model.addAttribute("alumnos", servicio.todosLosAlumnosDeUnCurso(id));					

		return "index";
	}
	
	@GetMapping("/alumnos/{id}")
	public String unAlumno(
			@PathVariable("id") Long alumnoId, Model model) {
		Alumno a = servicio.findById(alumnoId).orElse(null);
		model.addAttribute("alumno", a);
		
		return "detail";
	}
	
	@GetMapping("/alumno/nuevo")
	public String showForm(Model model) {
		
		//model.addAttribute("cursos", cursoServicio.findAll());
		model.addAttribute("alumno", new Alumno());
		
		return "formulario";
	}
	
	@PostMapping("/alumno/submit")
	public String processForm(@ModelAttribute("alumno") Alumno nuevo) {
		
		servicio.save(nuevo);
		
		return "redirect:/alumnos";
	}
	
	
	@ModelAttribute("tipo_alumno")
	public List<String> tiposAlumnos() {
		return DatosMaestros.tipos_alumnos();
	}
	
	@ModelAttribute("cursos")
	public List<Curso> cursos() {
		return cursoServicio.findAll();
	}
	
	

}
