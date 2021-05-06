package com.example.demo;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnglishSaludator implements Saludator {

	private boolean uppercase = false;
	
	private Logger log = LoggerFactory.getLogger(EnglishSaludator.class);
	
	@Override
	public String saludar() {
		return "Hello World!";
	}

	@Override
	public String saludar(String nombre) {
		return String.format("Hello, %s", nombre);
	}
	
	@Override
	public void configUpperCase(boolean inUpperCase) {
		this.uppercase = inUpperCase;
	}

	@PreDestroy
	public void destroy() {
		log.info("El bean se destruirá en 3...2...1");
	}

}
