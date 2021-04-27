package com.example.demo;

public class SpanishSaludator implements Saludator {

	@Override
	public String saludar() {
		return "Hola Mundo";
	}

	@Override
	public String saludar(String nombre) {
		return String.format("Hola, %s", nombre);
	}

	
	
}
