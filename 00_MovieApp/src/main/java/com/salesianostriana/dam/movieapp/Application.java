
package com.salesianostriana.dam.movieapp;

public class Application {
	
		
  public static void main(String[] args) {

	  MovieLister lister = new MovieLister();
	  
	  
	  for(Movie m: lister.moviesDirectedBy("Christopher Nolan"))
		  System.out.println(m);
	  
	  
  
  }
}
