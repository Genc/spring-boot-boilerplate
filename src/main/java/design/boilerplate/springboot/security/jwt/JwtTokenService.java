package design.boilerplate.springboot.security.jwt;

import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.LoginRequest;
import design.boilerplate.springboot.security.dto.LoginResponse;
import design.boilerplate.springboot.security.mapper.UserMapper;
import design.boilerplate.springboot.security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {

	private final UserService userService;

	private final JwtTokenManager jwtTokenManager;

	private final AuthenticationManager authenticationManager;

	public LoginResponse getLoginResponse(LoginRequest loginRequest) {

		final String username = loginRequest.getUsername();
		final String password = loginRequest.getPassword();

		final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		final AuthenticatedUserDto authenticatedUserDto = userService.findAuthenticatedUserByUsername(username);

		final User user = UserMapper.INSTANCE.convertToUser(authenticatedUserDto);
		final String token = jwtTokenManager.generateToken(user);

		log.info(" {} has successfully logged in!", user.getUsername());

		return new LoginResponse(token);
	}

}
