package com.salesianostriana.dam.seguridad.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.seguridad.model.Usuario;

public interface UsuarioRepositorio 
	extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findFirstByUsername(String username);

}
