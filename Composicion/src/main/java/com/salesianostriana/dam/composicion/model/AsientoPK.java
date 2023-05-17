package com.salesianostriana.dam.composicion.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Embeddable
public class AsientoPK implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long avion_id;
	
	
	// HIBERNATE IGNORA LA SECUENCIA
	/*
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "asiento_seq"
			)
	@SequenceGenerator(
			name = "asiento_seq",
			sequenceName = "asiento_seq",
			initialValue = 1
			)
			*/
	private Long asiento_id;

}
