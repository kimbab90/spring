package com.company.common.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component("successHandler")
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub

		log.info("Login success");

		List<String> roles = new ArrayList<>();

		authentication.getAuthorities().forEach(role -> {
			roles.add(role.getAuthority());
		});

		log.info(roles);
		
		response.sendRedirect("./all");

//		if (roles.stream().anyMatch(role -> role.equals("ROLE_ADMIN"))) {
//
//			response.sendRedirect("./admin");
//			return;
//		}
//
//		if (roles.stream().anyMatch(role -> role.equals("ROLE_USER"))) {
//
//			response.sendRedirect("./member");
//			return;
//		}

	}

}
