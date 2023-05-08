package com.salesianostriana.dam.asociaciones.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Embeddable
public class NotasPK implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long alumno_id;
	private long asignatura_id;

}
