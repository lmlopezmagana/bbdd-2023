package com.salesianostriana.dam.asociaciones.repos;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.asociaciones.model.Alumno;

public interface AlumnoRepositorio
	extends JpaRepository<Alumno, Long>{
	
	List<Alumno> findByApellidosContainsIgnoreCase(String apellidos);
	
	List<Alumno> findByApellidosContainsIgnoreCaseOrNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrderByApellidosDesc(String apellidos, String nombre, String email);
	
	
	@Query("""
			select a
			from Alumno a
			where a.apellidos = ?1
				or a.nombre = ?2
			""")
	List<Alumno> buscarPorTodo(String ape, String nom);
	
	@Query("""
			select a
			from Alumno a
			where a.apellidos = :ape
				or a.nombre = :nom
			""")
	List<Alumno> buscarPorTodov2(String ape, String nom);
	
	@Query("""
			select a
			from Alumno a
			where a.apellidos = :ape
				or a.nombre = :nom
			""")
	List<Alumno> buscarPorTodov3(
			@Param("ape") String apellidos, 
			@Param("nom") String nombre);
	
	
	
	// SELECT * FROM ALUMNO WHERE APELLIDOS = '..';

}
