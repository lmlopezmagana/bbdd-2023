package com.salesianostriana.dam.demojpa.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.demojpa.modelo.Alumno;
import com.salesianostriana.dam.demojpa.repos.AlumnoRepository;
import com.salesianostriana.dam.demojpa.servicios.base.BaseService;

@Service
public class AlumnoServicio extends BaseService<Alumno, Long, AlumnoRepository>{

	public List<Alumno> buscarPorApellido(String a) {
		return this.repository.findByApellidosContainsOrderByApellidosAsc(a);
	}
	
	public List<Alumno> todosLosAlumnosDeUnCurso(Long id) {
		return this.repository.findByCursoIdOrderByApellidosAsc(id);
	}

	
}
