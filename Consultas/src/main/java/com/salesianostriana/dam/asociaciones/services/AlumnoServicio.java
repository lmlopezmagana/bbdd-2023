package com.salesianostriana.dam.asociaciones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.asociaciones.model.Alumno;
import com.salesianostriana.dam.asociaciones.repos.AlumnoRepositorio;
import com.salesianostriana.dam.asociaciones.services.base.BaseServiceImpl;

@Service
public class AlumnoServicio 
	extends BaseServiceImpl<Alumno, Long, AlumnoRepositorio> {

	
	public List<Alumno> buscarPorApellido(String a) {
		return this.repository.findByApellidosContainsIgnoreCase(a);
	}
	
	public List<Alumno> buscarPorCualquierCosa(String cosa) {
		return this.repository.findByApellidosContainsIgnoreCaseOrNombreContainsIgnoreCaseOrEmailContainsIgnoreCase(cosa, cosa, cosa);
	}
	
}
