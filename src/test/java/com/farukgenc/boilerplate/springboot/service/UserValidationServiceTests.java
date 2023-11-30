package com.farukgenc.boilerplate.springboot.service;

import com.farukgenc.boilerplate.springboot.exceptions.RegistrationException;
import com.farukgenc.boilerplate.springboot.repository.UserRepository;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationRequest;
import com.farukgenc.boilerplate.springboot.security.service.UserService;
import com.farukgenc.boilerplate.springboot.utils.ExceptionMessageAccessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserValidationServiceTests {

    @InjectMocks
    private UserValidationService userValidationService;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ExceptionMessageAccessor exceptionMessageAccessor;

    private static final String EMAIL_ALREADY_EXISTS = "email_already_exists";

    private static final String USERNAME_ALREADY_EXISTS = "username_already_exists";

    @Test
    public void UserValidationService_checkUsername_throwsRegistrationException() {
        // Arrange
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername("existingUsername");

        when(userRepository.existsByUsername("existingUsername")).thenReturn(true);

        when(exceptionMessageAccessor.getMessage(null, USERNAME_ALREADY_EXISTS))
                .thenReturn("Username already exists");

        // Act
        RegistrationException exception = assertThrows(RegistrationException.class,
                () -> userValidationService.validateUser(registrationRequest));

        // Assert
        assertEquals("Username already exists", exception.getErrorMessage());
        verify(userRepository,times(1)).existsByUsername("existingUsername");

    }

    @Test
    public void UserValidationService_checkEmail_throwsRegistrationException() {
        // Arrange
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setEmail("x@gmail.");

        when(userRepository.existsByEmail("x@gmail.")).thenReturn(true);

        when(exceptionMessageAccessor.getMessage(null, EMAIL_ALREADY_EXISTS))
               .thenReturn("email_already_exists");

        // Act
        RegistrationException exception = assertThrows(RegistrationException.class,
                () -> userValidationService.validateUser(registrationRequest));

        // Assert
        assertEquals("email_already_exists", exception.getErrorMessage());

        verify(userRepository,times(1)).existsByEmail("x@gmail.");
    }


    @Test
    public void UserValidationService_validateUser_doValidation() {
    // Arrange
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setEmail("farukgenc@gmail.com");
        registrationRequest.setUsername("farukgenc");

        //
        userValidationService.validateUser(registrationRequest);

        // Assert
        verify(userRepository,times(1)).existsByUsername("farukgenc");
        verify(userRepository,times(1)).existsByEmail("farukgenc@gmail.com");
    }

}
