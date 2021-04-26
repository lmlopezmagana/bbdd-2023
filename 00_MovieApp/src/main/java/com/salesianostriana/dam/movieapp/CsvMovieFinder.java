package com.salesianostriana.dam.movieapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvMovieFinder implements MovieFinder {

	
	private String file;
	
	public CsvMovieFinder() {
		file = "movies.txt";
	}
	
	public CsvMovieFinder(String file) {
		this.file = file;
	}
	
	@Override
	public List<Movie> findAll() {
		
		try {
			return Files.lines(Paths.get(file))
				.map(line -> {
					String[] parts = line.split(";");
					return new Movie(parts[0], parts[1]);
				})
				.collect(Collectors.toUnmodifiableList());
		} catch (IOException e) {
			return null;
		}
		
		
		
	}

}
