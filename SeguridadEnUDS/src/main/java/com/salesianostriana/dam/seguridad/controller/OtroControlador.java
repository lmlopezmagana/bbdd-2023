package com.salesianostriana.dam.seguridad.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.seguridad.model.Usuario;

@Controller
@RequestMapping("/web")
public class OtroControlador {
	
	@GetMapping("/index")
	public String index(@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("nombre", usuario.getUsername());
		model.addAttribute("rol", usuario.getAuthorities().toArray()[0].toString());
		return "web/index";
	}

}
