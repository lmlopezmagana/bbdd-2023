package com.salesianostriana.dam.composicion.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(AsientoPK.class)
public class Asiento {
	
	@Id
	//@Column(name="asiento_id")
	@GeneratedValue
	private Long id;

	@Id @ManyToOne
	private Avion avion;
	
	private int fila, columna;
	
	@Enumerated(EnumType.STRING)
	private TipoAsiento tipo;
	


}
