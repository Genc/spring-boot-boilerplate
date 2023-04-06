package com.farukgenc.boilerplate.springboot.security.jwt;

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

}
