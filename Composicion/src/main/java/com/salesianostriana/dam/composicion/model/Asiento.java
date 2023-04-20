package com.salesianostriana.dam.composicion.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asiento {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int fila, columna;
	
	@Enumerated(EnumType.STRING)
	private TipoAsiento tipo;
	
	@ManyToOne
	private Avion avion;

}
