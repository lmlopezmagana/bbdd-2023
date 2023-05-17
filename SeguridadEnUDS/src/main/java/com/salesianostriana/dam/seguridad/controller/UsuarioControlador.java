package com.salesianostriana.dam.seguridad.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.seguridad.model.Usuario;
import com.salesianostriana.dam.seguridad.repos.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioControlador {
	
	private final UsuarioRepositorio repo;

	@GetMapping("/me")
	public String me() {

		Usuario u = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(u.toString());

		return "perfil";
	}

	@GetMapping("/me2")
	public String me2(@AuthenticationPrincipal Usuario u) {

		System.out.println(u.toString());

		return "perfil";
	}
	
	@GetMapping("/update")
	public String updateUserInfo(@AuthenticationPrincipal Usuario u) {
		
		u.setEmail("user@triana.salesianos.edu");
		Usuario actualizado = repo.save(u);
		
		Authentication auth = new 
				UsernamePasswordAuthenticationToken(actualizado, null, actualizado.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
				
		return "perfil";
	}

}
