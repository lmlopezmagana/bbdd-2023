package com.salesianostriana.dam.asociaciones.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notas {
	/*
	 * Así no nos vale, no es suficiente
	 * 
	 * @Id
	 * 
	 * @GeneratedValue private Long id;
	 */
	@EmbeddedId
	private NotasPK notasPK = new NotasPK();
	
	
	public Notas(Alumno a, Asignatura as) {
		this.alumno = a;
		this.asignatura = as;
	}

	@ManyToOne
	@MapsId("alumno_id")
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;

	@ManyToOne
	@MapsId("asignatura_id")
	@JoinColumn(name = "asignatura_id")
	private Asignatura asignatura;

	private int primeraEv, segundaEv, terceraEv, notaFinal;

	/*
	 * MÉTODOS HELPER
	 */

	public void addToAlumno(Alumno a) {
		a.getNotas().add(this);
		this.alumno = a;
	}

	public void removeFromAlumno(Alumno a) {
		a.getNotas().remove(this);
		this.alumno = null;
	}

}
