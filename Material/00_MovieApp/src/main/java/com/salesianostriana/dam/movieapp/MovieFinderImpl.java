package com.salesianostriana.dam.movieapp;

import java.util.List;

public class MovieFinderImpl implements MovieFinder {
	
	List<Movie> peliculas = List.of(
			new Movie("Cadena perpetua", "Frank Darabont"),
			new Movie("El padrino", "Francis Ford Copola"),
			new Movie("El padrino. Parte II", "Francis Ford Copola"),
			new Movie("El caballero oscuro", "Christopher Nolan"),
			new Movie("12 hombres sin piedad", "Sidney Lumet"));
	
	
	
	@Override
	public List<Movie> findAll() {
		return peliculas;
	}

}
