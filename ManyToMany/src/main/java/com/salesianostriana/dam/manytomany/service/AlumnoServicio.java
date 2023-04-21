package com.salesianostriana.dam.manytomany.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.manytomany.model.Alumno;
import com.salesianostriana.dam.manytomany.repos.AlumnoRepositorio;
import com.salesianostriana.dam.manytomany.service.base.BaseServiceImpl;

@Service
public class AlumnoServicio
	extends BaseServiceImpl<Alumno, Long, AlumnoRepositorio>{

}
