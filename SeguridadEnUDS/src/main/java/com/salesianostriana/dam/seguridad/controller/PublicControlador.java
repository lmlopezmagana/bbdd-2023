package com.salesianostriana.dam.seguridad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicControlador {
	
	@GetMapping("/")
	public String index() {
		return "main.html";
	}
	
}
