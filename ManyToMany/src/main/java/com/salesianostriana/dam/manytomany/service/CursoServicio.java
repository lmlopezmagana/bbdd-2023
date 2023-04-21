package com.salesianostriana.dam.manytomany.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.manytomany.model.Curso;
import com.salesianostriana.dam.manytomany.repos.CursoRepositorio;
import com.salesianostriana.dam.manytomany.service.base.BaseServiceImpl;

@Service
public class CursoServicio 
	extends BaseServiceImpl<Curso, Long, CursoRepositorio>{

}
