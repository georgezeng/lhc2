package net.geozen.lhc2.web.filter.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.exception.BusinessException;

@Component
public class AuthenticationLogoutHandler
		implements AuthenticationSuccessHandler, AuthenticationFailureHandler, LogoutSuccessHandler, AccessDeniedHandler, AuthenticationEntryPoint {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		writeSuccess(response);
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		throw new BusinessException(exception.getMessage(), exception);
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		clearCookies(response);
		writeSuccess(response);
	}

	protected void clearCookies(HttpServletResponse response) {
		Cookie cookie = new Cookie("token", null); // Not necessary, but saves bandwidth.
		cookie.setPath("/");
		cookie.setHttpOnly(false);
		cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
		response.addCookie(cookie);
	}

	protected void writeSuccess(HttpServletResponse response) throws IOException {
		response.setStatus(HttpStatus.OK.value());
		new ObjectMapper().writeValue(response.getWriter(), Result.genSuccessResult(null));
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
			throws IOException, ServletException {
		clearCookies(response);
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		clearCookies(response);
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}
}