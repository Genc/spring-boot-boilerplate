package com.hiringglobal.mobile.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created on March, 2025
 *
 * @author HungPG
 */
@Getter
@RequiredArgsConstructor
public class RegistrationException extends RuntimeException {

	private final String errorMessage;

}
