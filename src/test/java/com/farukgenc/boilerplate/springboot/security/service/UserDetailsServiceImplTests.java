package com.farukgenc.boilerplate.springboot.security.service;

import com.farukgenc.boilerplate.springboot.model.User;
import com.farukgenc.boilerplate.springboot.model.UserRole;
import com.farukgenc.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.farukgenc.boilerplate.springboot.utils.GeneralMessageAccessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTests {

    @InjectMocks
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    UserService userService;

    @Mock
    private GeneralMessageAccessor generalMessageAccessor;


    @Test
    public void UserDetailsServiceImpl_loadUserByUsername_returnsUserDetails() {
        // Arrange
        String username = "testUser";

        AuthenticatedUserDto expectedDto = new AuthenticatedUserDto();
        expectedDto.setUserRole(UserRole.USER);
        expectedDto.setUsername(username);
        expectedDto.setPassword("password");


        when(userService.findAuthenticatedUserByUsername(any())).thenReturn(expectedDto);

        // Act
        UserDetails actualDto = userDetailsServiceImpl.loadUserByUsername(username);

        // Assert
        assertEquals(expectedDto.getUsername(), actualDto.getUsername());
    }

    @Test
    public void UserDetailsServiceImpl_loadUserByUsername_throwsUsernameNotFoundException() {

        // Arrange
        String username = "testUser";
        when(userService.findAuthenticatedUserByUsername(any())).thenReturn(null);

        // Act and Assert
        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsServiceImpl.loadUserByUsername(username);
        });
        assertEquals("Invalid username or password.", exception.getMessage());

    }

}
