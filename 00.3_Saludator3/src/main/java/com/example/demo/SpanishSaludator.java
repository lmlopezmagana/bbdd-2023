package com.example.demo;

public class SpanishSaludator implements Saludator {
	
	private boolean uppercase = false;

	@Override
	public String saludar() {
		//return "Hola Mundo";
		return (!uppercase) ? "Hola Mundo" : "HOLA MUNDO";
	}

	@Override
	public String saludar(String nombre) {
		return String.format("Hola, %s", nombre);
	}

	@Override
	public void configUpperCase(boolean inUpperCase) {
		this.uppercase = inUpperCase;
	}

	
	
}
