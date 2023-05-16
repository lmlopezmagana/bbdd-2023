package com.salesianostriana.dam.seguridad.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class RoleBasedSuccessHandler 
	implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy =
			new DefaultRedirectStrategy();
	
	private final String ROLE_USER_URL = "/web/index";
	private final String ROLE_ADMIN_URL = "/admin/index";
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		// Determinar el rol
		List<GrantedAuthority> authorities =
				new ArrayList<>(authentication.getAuthorities());
		
		String role = authorities.get(0).toString();
		
		
		String redirectUrl;
		// En función del rol, redirigir a la URL correcta
		if (role.endsWith("ADMIN")) {
			redirectUrl = ROLE_ADMIN_URL;
		} else {
			redirectUrl = ROLE_USER_URL;
		}
		
		if (response.isCommitted()) {
			log.info("Can't redirect");
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, redirectUrl);
		
		
	}

}
