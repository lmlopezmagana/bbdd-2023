package com.salesianostriana.dam.composicion.servicio;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.composicion.model.Avion;
import com.salesianostriana.dam.composicion.repos.AvionRepositorio;
import com.salesianostriana.dam.composicion.servicio.base.BaseServiceImpl;

@Service
public class AvionServicio 
	extends BaseServiceImpl<Avion, Long, AvionRepositorio>{

	@Override
	public Avion save(Avion t) {
		
		for(int i = 0; i < t.getAsientos().size(); i++) {
			t.getAsientos().get(i).getAsientoPK().setAsiento_id(i+1L);
		}
		
		return super.save(t);
	}
	
	
	

}
