package com.salesianostriana.dam.asociaciones.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre, profesor;
	
	@ManyToOne
	private Curso curso;
	
	
	
	
	/**
	 * MÉTODOS HELPER
	 */
	
	public void addToCurso(Curso c) {
		c.getAsignaturas().add(this);
		this.curso = c;
		
	}
	
	public void removeFromCurso(Curso c) {
		c.getAsignaturas().remove(this);
		this.curso = null;
	}

}
