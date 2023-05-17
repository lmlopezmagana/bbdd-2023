package com.salesianostriana.dam.composicion.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Avion {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String modelo;
	
	private int maxPasajeros;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="avion", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Asiento> asientos = new ArrayList<>();

	// Se devuelve una copia no modificable para evitar que se
	// añadan elementos sin usar el método correspondiente.
	public List<Asiento> getAsientos() {
		return Collections.unmodifiableList(asientos);
	}

	
	// MÉTODOS HELPER
	
	public void addAsiento(Asiento a) {
		a.getAsientoPK().setAsiento_id(getAsientoIdNextval());
		a.setAvion(this);
		this.asientos.add(a);
	}
	
	public void removeAsiento(Asiento a) {
		this.asientos.remove(a);
		a.setAvion(null);
	}

	public void removeAsiento(long asiento_id) {
		Optional<Asiento> a = asientos.stream()
				.filter(asiento -> asiento.getAsientoPK().getAvion_id() == this.id && asiento.getAsientoPK().getAsiento_id() == asiento_id)
				.findFirst();


		if (a.isPresent())
			removeAsiento(a.get());

	}

	public long getAsientoIdNextval() {
		if (this.asientos.size() > 0) {
			return this.asientos.stream()
					.map(Asiento::getAsientoPK)
					.map(AsientoPK::getAsiento_id)
					.max(Comparator.naturalOrder())
					.orElse(0l) + 1l;
		} else
			return 1l;
	}
	
	
	
}
