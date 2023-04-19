package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PseudoMain {
	
	@Autowired
	@Qualifier("englishSaludator")
	private Saludator saludador;
	

	
	@PostConstruct
	public void run() {
	
		System.out.println(saludador.saludar());
		
		System.out.println(saludador.saludar("Luismi"));
		
		
	}
	

}
