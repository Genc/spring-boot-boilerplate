package com.farukgenc.boilerplate.springboot.repository;

import com.farukgenc.boilerplate.springboot.model.User;
import com.farukgenc.boilerplate.springboot.model.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_findByUsername_returnsUser() {

        User user = User.builder()
                .name("nishant")
                .username("nishant12")
                .password("12345")
                .email("nish@gmail.com")
                .userRole(UserRole.ADMIN)
                .build();

        userRepository.save(user);

        User userSaved = userRepository.findByUsername(user.getUsername());

        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getId()).isEqualTo(user.getId());

    }

    @Test
    public void UserRepository_findByUsername_returnsNull() {

        User user = User.builder()
                .name("nishant")
                .username("nishant12")
                .password("<PASSWORD>")
                .email("nish@gmail.com")
                .userRole(UserRole.ADMIN)
                .build();

        userRepository.save(user);

        User userSaved = userRepository.findByUsername("nish");

        Assertions.assertThat(userSaved).isNull();

    }

    @Test
    public void UserRepository_existsByEmail_returnsTrue() {
        User user = User.builder()
              .name("nishant")
              .username("nishant12")
              .password("<PASSWORD>")
              .email("nish@gmail.com")
              .userRole(UserRole.ADMIN)
              .build();

        userRepository.save(user);

        boolean userSaved = userRepository.existsByEmail(user.getEmail());

        Assertions.assertThat(userSaved).isTrue();
    }

    @Test
    public void UserRepository_existsByEmail_returnsFalse() {
        User user = User.builder()
             .name("nishant")
             .username("nishant12")
             .password("<PASSWORD>")
             .email("nish@gmail.com")
             .userRole(UserRole.ADMIN)
             .build();

        userRepository.save(user);

        boolean userSaved = userRepository.existsByEmail("nishant@gmail.com");

        Assertions.assertThat(userSaved).isFalse();
    }

    @Test
    public void UserRepository_existsByUsername_returnsTrue() {
        User user = User.builder()
            .name("nishant")
            .username("nishant12")
            .password("<PASSWORD>")
            .email("nish@gmail.com")
            .userRole(UserRole.ADMIN)
            .build();

        userRepository.save(user);

        boolean userSaved = userRepository.existsByUsername(user.getUsername());

        Assertions.assertThat(userSaved).isTrue();
    }

    @Test
    public void UserRepository_existsByUsername_returnsFalse() {
            User user = User.builder()
              .name("nishant")
              .username("nishant12")
              .password("<PASSWORD>")
              .email("nish@gmail.com")
              .userRole(UserRole.ADMIN)
              .build();

            userRepository.save(user);

            boolean userSaved = userRepository.existsByUsername("nishant");

            Assertions.assertThat(userSaved).isFalse();
    }

}