package com.salesianostriana.dam.asociaciones.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.asociaciones.model.Alumno;
import com.salesianostriana.dam.asociaciones.repos.AlumnoRepositorio;
import com.salesianostriana.dam.asociaciones.services.base.BaseServiceImpl;

@Service
public class AlumnoServicio 
	extends BaseServiceImpl<Alumno, Long, AlumnoRepositorio> {

}
