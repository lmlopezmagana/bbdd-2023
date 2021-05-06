package com.example.demo;

import org.springframework.stereotype.Service;

@Service("enIngles")
public class EnglishSaludator implements Saludator {

	@Override
	public String saludar() {
		return "Hello World!";
	}

	@Override
	public String saludar(String nombre) {
		return String.format("Hello, %s", nombre);
	}

}
