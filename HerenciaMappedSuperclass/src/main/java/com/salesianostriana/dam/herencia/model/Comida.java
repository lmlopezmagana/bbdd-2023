package com.salesianostriana.dam.herencia.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comida extends Producto {
	
	private boolean esFrio;
	
	private String tipo;

	public Comida(Long id, String nombre, float precio, boolean esFrio, String tipo) {
		super(id, nombre, precio);
		this.esFrio = esFrio;
		this.tipo = tipo;
	}
	
	

}
