package com.salesianostriana.dam.trianaadvisor.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comentario {

	@Id
	@GeneratedValue
	private Long id;
	
	private String texto;
	
	private int valoracion;
	
	private LocalDateTime fecha = LocalDateTime.now();
	
	@ManyToOne
	private Bar bar;

	public Comentario(String texto, int valoracion, Bar bar) {
		this.texto = texto;
		this.valoracion = valoracion;
		this.bar = bar;
	}

	public Comentario(String texto, int valoracion) {
		this.texto = texto;
		this.valoracion = valoracion;
	}
	
	
	
	
}
