package com.salesianostriana.dam.movieapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieLister {
	
	private MovieFinder finder;
	
	public MovieLister() {
		//finder = new MovieFinderImpl();
		finder = new CsvMovieFinder();
	}
	
	public MovieLister(MovieFinder finder) {
		this.finder = finder;
	}
	
	
	public List<Movie> moviesDirectedBy(String director)
	  {
	      List<Movie> allMovies = finder.findAll();

	      List<Movie> result = new ArrayList<>();
	      
	      for(Movie m : allMovies) {
	    	  if (m.getDirector().equals(director))
	    		  result.add(m);
	      }
	      
	      
	      return Collections.unmodifiableList(result);
	  }


}
 