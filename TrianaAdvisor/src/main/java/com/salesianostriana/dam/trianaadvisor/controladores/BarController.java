package com.salesianostriana.dam.trianaadvisor.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.trianaadvisor.modelo.Bar;
import com.salesianostriana.dam.trianaadvisor.modelo.Comentario;
import com.salesianostriana.dam.trianaadvisor.servicios.BarServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BarController {
	
	private final BarServicio barServicio;
	
	@GetMapping("/")
	public String todosLosBares(Model model) {
		
		model.addAttribute("bares", barServicio.findAll());
		
		return "index";
	}
	
	@GetMapping("/formulario")
	public String formularioBar() {
		
		/*
		 * Simulamos que pintamos un formulario,
		 * recogemos sus valores, y los guardamos
		 * a través del servicio.
		 */
		
		Bar mariatrifulca = new Bar("Mariatrifulca", "Moderno, Vistas", "37.3859122,-6.0033743");
		//Bar cibeles = new Bar("Bar Cibeles 2", "Clásico, Económico", "37.381328,-6.0060029");
		//Bar baronesa = new Bar("La Baronesa", "Copas, Desayunos", "37.3804222,-6.0056304");
		
		
		mariatrifulca.addComentario(new Comentario("Una de las mejores vistas de Sevilla",5));
		mariatrifulca.addComentario(new Comentario("Una pasada de precio", 3));
		
		barServicio.save(mariatrifulca);
		
		
		return "redirect:/";
	}

}
