package dev.seano.petstagram.auth;

import dev.seano.petstagram.auth.dto.SignInRequest;
import dev.seano.petstagram.auth.dto.SignUpRequest;
import dev.seano.petstagram.user.User;
import dev.seano.petstagram.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;

@Service
public class AuthService {

    final UserService userService;

    final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public User signUp(SignUpRequest signUpRequest) {
        if (userService.findByUsername(signUpRequest.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        var password = passwordEncoder.encode(signUpRequest.getPassword()).getBytes(StandardCharsets.UTF_8);
        var user = User.builder().username(signUpRequest.getUsername()).password(password).build();
        return userService.save(user);
    }

    public User signIn(SignInRequest signInRequest) {
        var user = userService.findByUsername(signInRequest.getUsername());
        if (user.isPresent()) {
            if (passwordEncoder.matches(signInRequest.getPassword(), user.get().getPassword())) {
                return user.get();
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }
}
