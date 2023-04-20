package com.salesianostriana.dam.composicion;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.composicion.model.Asiento;
import com.salesianostriana.dam.composicion.model.Avion;
import com.salesianostriana.dam.composicion.model.TipoAsiento;
import com.salesianostriana.dam.composicion.repos.AvionRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {
	
	private final AvionRepositorio repositorio;
	
	@PostConstruct
	public void ejecutar() {
		
		Avion airbus320 = Avion.builder()
				.modelo("Airbus A320")
				.maxPasajeros(300)
				.build();
		
		for(int i = 1; i<=2;i++) {
			for(int j = 1; j<=6; j++) {
				airbus320.addAsiento(
						Asiento.builder()
						.tipo(TipoAsiento.PRIMERA)
						.fila(i)
						.columna(j)
						.build()						
						);
			}
		}
		
		for(int i = 3; i<=50;i++) {
			for(int j = 1; j<=6; j++) {
				airbus320.addAsiento(
						Asiento.builder()
						.tipo(TipoAsiento.TURISTA)
						.fila(i)
						.columna(j)
						.build()						
						);
			}
		}
		
		repositorio.save(airbus320);
		
		/*Asiento asiento = airbus320.getAsientos().get(0);
		airbus320.removeAsiento(asiento);
		
		repositorio.save(airbus320);*/
		
		//repositorio.delete(airbus320);

		
	}

}
