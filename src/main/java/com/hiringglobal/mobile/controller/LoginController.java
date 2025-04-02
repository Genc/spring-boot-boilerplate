package com.hiringglobal.mobile.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hiringglobal.mobile.security.dto.LoginRequest;
import com.hiringglobal.mobile.security.dto.LoginResponse;
import com.hiringglobal.mobile.security.jwt.JwtTokenService;

/**
 * Created on March, 2025
 *
 * @author HungPG
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

	private final JwtTokenService jwtTokenService;

	@PostMapping
	@Operation(tags = "Login Service", description = "You must log in with the correct information to successfully obtain the token information.")
	public ResponseEntity<LoginResponse> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {

		final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

		return ResponseEntity.ok(loginResponse);
	}

}
