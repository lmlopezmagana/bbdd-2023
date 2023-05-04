package com.salesianostriana.dam.herencia.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class ClienteVip extends Cliente {
	
	private LocalDate fechaVip;

	public ClienteVip(Long id, String email, String nombre, String apellidos, LocalDate fechaVip) {
		super(id, email, nombre, apellidos);
		this.fechaVip = fechaVip;
	}
	
	

}
