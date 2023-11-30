package com.farukgenc.boilerplate.springboot.security.service;

import com.farukgenc.boilerplate.springboot.model.User;
import com.farukgenc.boilerplate.springboot.model.UserRole;
import com.farukgenc.boilerplate.springboot.repository.UserRepository;
import com.farukgenc.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationResponse;
import com.farukgenc.boilerplate.springboot.service.UserValidationService;
import com.farukgenc.boilerplate.springboot.utils.GeneralMessageAccessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTests {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserRepository  userRepository;

    @Mock
    UserValidationService userValidationService;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private GeneralMessageAccessor generalMessageAccessor;


    @Test
    public void UserServiceImpl_findByUsername_returnsUser() {
        // Arrange
        String username = "testUser";
        User expectedUser = User.builder()
                .name("Test")
                .username(username)
                .password("password")
                .email("test@example.com")
                .userRole(UserRole.USER)
                .build();

        when(userRepository.findByUsername(any())).thenReturn(expectedUser);

        // Act
        User actualUser = userServiceImpl.findByUsername(username);

        // Assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void UserServiceImpl_registration_returnsRegistrationResponse() {

        // Arrange
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setName("test");
        registrationRequest.setUsername("test1");
        registrationRequest.setEmail("test@gmail.com");
        registrationRequest.setPassword(" +");

        String encodedPassword = "encodedPassword";

        when(bCryptPasswordEncoder.encode(registrationRequest.getPassword())).thenReturn(encodedPassword);
        when(generalMessageAccessor.getMessage(any(), any(), any())).thenReturn("Registration successful for user");

        // Act
        RegistrationResponse registrationResponse = userServiceImpl.registration(registrationRequest);

        // Assert
        assertEquals("Registration successful for user", registrationResponse.getMessage());
        verify(userValidationService, times(1)).validateUser(registrationRequest);
        verify(userRepository, times(1)).save(any());
        verify(bCryptPasswordEncoder, times(1)).encode(registrationRequest.getPassword());
        verify(bCryptPasswordEncoder, times(1)).encode(" +");
    }

    @Test
    public void UserServiceImpl_findAuthenticatedUserByUsername_returnsAuthenticatedUserDto() {

        //Arrange
        String username = "testUser";

        User user = User.builder()
                .name("Test")
                .username(username)
                .password("password")
                .email("test@example.com")
                .userRole(UserRole.USER)
                .build();

        AuthenticatedUserDto expectedDto = new AuthenticatedUserDto();
        expectedDto.setName("Test");
        expectedDto.setUserRole(UserRole.USER);
        expectedDto.setUsername(username);
        expectedDto.setPassword("password");

        when(userRepository.findByUsername(username)).thenReturn(user);

        // Act
        AuthenticatedUserDto resultDto = userServiceImpl.findAuthenticatedUserByUsername(username);

        // Assert
        assertEquals(expectedDto.getUsername(), resultDto.getUsername());
        assertEquals(expectedDto.getName(), resultDto.getName());
        verify(userRepository, times(1)).findByUsername(username);
    }

}
