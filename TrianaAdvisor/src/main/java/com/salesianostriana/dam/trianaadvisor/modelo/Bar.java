package com.salesianostriana.dam.trianaadvisor.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Bar {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	private String tipo;
	
	private String localizacion;
	
	@OneToMany(mappedBy = "bar", fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL, orphanRemoval = true) 
	private List<Comentario> comentarios = new ArrayList<>();

	public Bar(String nombre, String tipo, String localizacion) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.localizacion = localizacion;
	}
	
	
	// Métodos HELPER
	
	public void addComentario(Comentario c) {
		this.comentarios.add(c);
		c.setBar(this);
	}
	
	public void removeComentario(Comentario c) {
		this.comentarios.remove(c);
		c.setBar(null);
	}
	
	

}
