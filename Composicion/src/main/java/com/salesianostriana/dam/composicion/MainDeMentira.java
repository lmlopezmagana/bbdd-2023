package com.salesianostriana.dam.composicion;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.composicion.model.Asiento;
import com.salesianostriana.dam.composicion.model.Avion;
import com.salesianostriana.dam.composicion.model.TipoAsiento;
import com.salesianostriana.dam.composicion.servicio.AvionServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {
	
	//private final AvionRepositorio repositorio;
	private final AvionServicio servicio;
	
	@PostConstruct
	public void ejecutar() {
		
		Avion airbus320 = Avion.builder()
				.modelo("Airbus A320")
				.maxPasajeros(300)
				.build();
		
		//repositorio.save(airbus320);

		
		/*Asiento a = Asiento.builder()
				.tipo(TipoAsiento.PRIMERA)
				.fila(1)
				.columna(1)
				.build();
		
		airbus320.addAsiento(a);*/
		
		
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
		
		
		
		servicio.save(airbus320);
		
		airbus320.getAsientos().get(0).setTipo(TipoAsiento.TURISTA);
		
		airbus320.getAsientos().remove(123);
		
		servicio.save(airbus320);


		/*
		Asiento asiento = airbus320.getAsientos().get(0);
		airbus320.removeAsiento(asiento);
		
		airbus320 = repositorio.save(airbus320);

		repositorio.delete(airbus320);
		 */
		
	}

}
