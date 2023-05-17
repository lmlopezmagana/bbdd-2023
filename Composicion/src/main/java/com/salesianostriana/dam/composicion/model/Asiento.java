package com.salesianostriana.dam.composicion.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
	
	/*@Id
	@GeneratedValue
	private Long id;*/
	
	@EmbeddedId
	@Builder.Default
	private AsientoPK asientoPK = new AsientoPK();
	
	private int fila, columna;
	
	@Enumerated(EnumType.STRING)
	private TipoAsiento tipo;
	
	@ManyToOne
	@MapsId("avion_id")
	@JoinColumn(name="avion_id")
	private Avion avion;

}
