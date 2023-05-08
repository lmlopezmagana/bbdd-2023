package com.salesianostriana.dam.asociaciones.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.asociaciones.model.Curso;
import com.salesianostriana.dam.asociaciones.repos.CursoRepositorio;
import com.salesianostriana.dam.asociaciones.services.base.BaseServiceImpl;

@Service
public class CursoServicio 
	extends BaseServiceImpl<Curso, Long, CursoRepositorio>{

}
