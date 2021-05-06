package com.salesianostriana.dam.ejemplo.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
	
	private long id;
	
	private String nombre, apellidos, email;
	
	private LocalDate fechaNacimiento;
	
	public Alumno(String nombre, String apellidos, String email, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public int getEdad() {
		return (int) ChronoUnit.YEARS
				.between(fechaNacimiento, 
						LocalDate.now()
						.with(TemporalAdjusters.lastDayOfYear()));
	}




	
	
	

}
