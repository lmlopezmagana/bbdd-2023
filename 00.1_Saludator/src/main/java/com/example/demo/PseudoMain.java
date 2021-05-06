package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PseudoMain {
	
	private final Saludator saludador;
	/*@Autowired
	private Saludator saludador;*/
	
	
	@PostConstruct
	public void run() {
	
		System.out.println(saludador.saludar());
		
		System.out.println(saludador.saludar("Luismi"));
		
		
	}
	

}
