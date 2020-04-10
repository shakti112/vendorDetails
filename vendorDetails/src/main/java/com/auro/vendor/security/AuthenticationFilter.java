package com.auro.vendor.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auro.vendor.dto.UserLoginInfoDto;
import com.auro.vendor.model.UserLoginInfo;
import com.auro.vendor.vendorService.UserLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final UserLoginService userLoginService;
	private final String TOKEN_SECRET = "h4of9eh48vmg02nfu30v27yen295hfj65";

	public AuthenticationFilter(AuthenticationManager authenticationManager, UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {

			UserLoginInfo userLoginInfo = new ObjectMapper().readValue(req.getInputStream(), UserLoginInfo.class);

			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					userLoginInfo.getPhone(), userLoginInfo.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		// Get User Details from Database
		String userName = ((User) auth.getPrincipal()).getUsername();
		UserLoginInfoDto userLoginInfoDto = userLoginService.getUserByPhone(userName);

		// Generate GWT
		String token = Jwts.builder().setSubject(userLoginInfoDto.getLoginId())
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong("3600000")))
				.signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();

		res.addHeader("Token", token);
		res.addHeader("UserID", userLoginInfoDto.getLoginId());
	}
}