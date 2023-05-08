package com.salesianostriana.dam.asociaciones.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.asociaciones.model.Asignatura;
import com.salesianostriana.dam.asociaciones.repos.AsignaturaRepositorio;
import com.salesianostriana.dam.asociaciones.services.base.BaseServiceImpl;

@Service
public class AsignaturaServicio
	extends BaseServiceImpl<Asignatura, Long, AsignaturaRepositorio>{

}
