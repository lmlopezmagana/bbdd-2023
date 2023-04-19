package com.salesianostriana.dam.trianaadvisor.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.trianaadvisor.modelo.Bar;
import com.salesianostriana.dam.trianaadvisor.repos.BarRepository;
import com.salesianostriana.dam.trianaadvisor.servicios.base.BaseService;

@Service
public class BarServicio 
	extends BaseService<Bar, Long, BarRepository>{

}
