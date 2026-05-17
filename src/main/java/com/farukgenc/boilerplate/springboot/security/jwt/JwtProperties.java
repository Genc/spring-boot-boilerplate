package com.farukgenc.boilerplate.springboot.security.jwt;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created on October, 2022
 *
 * @author Faruk
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

	private String issuer;

	private String secretKey;

	private long expirationMinute;

	@PostConstruct
	public void validate() {
		if (secretKey == null || secretKey.isBlank()) {
			throw new IllegalStateException(
				"JWT secretKey is not configured. Set JWT_SECRETKEY environment variable or jwt.secretKey in application.yml. "
				+ "Generate a strong key with: openssl rand -base64 32"
			);
		}
		if (secretKey.length() < 32) {
			throw new IllegalStateException(
				"JWT secretKey must be at least 32 characters for adequate security. Current length: " + secretKey.length()
			);
		}
	}

}
