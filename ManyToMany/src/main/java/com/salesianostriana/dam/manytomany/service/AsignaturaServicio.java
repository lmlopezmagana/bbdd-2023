package com.salesianostriana.dam.manytomany.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.manytomany.model.Asignatura;
import com.salesianostriana.dam.manytomany.repos.AsignaturaRepositorio;
import com.salesianostriana.dam.manytomany.service.base.BaseServiceImpl;

@Service
public class AsignaturaServicio 
	extends BaseServiceImpl<Asignatura, Long, AsignaturaRepositorio>{

}
