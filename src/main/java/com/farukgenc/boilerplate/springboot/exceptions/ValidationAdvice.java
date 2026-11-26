package com.farukgenc.boilerplate.springboot.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@RestControllerAdvice
public class ValidationAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

		final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		final List<String> errorList = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();

		final ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(HttpStatus.BAD_REQUEST, LocalDateTime.now(), errorList);

		final List<String> invalidFields = fieldErrors.stream().map(FieldError::getField).distinct().toList();
		log.warn("Validation errors : {} , Invalid fields : {}", errorList, invalidFields);

		return ResponseEntity.status(validationErrorResponse.getStatus()).body(validationErrorResponse);
	}

}
