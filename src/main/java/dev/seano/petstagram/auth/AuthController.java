package dev.seano.petstagram.auth;

import dev.seano.petstagram.auth.dto.SignInRequest;
import dev.seano.petstagram.auth.dto.SignUpRequest;
import dev.seano.petstagram.user.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        var user = authService.signUp(signUpRequest);
        return ResponseEntity.ok(new UserResponse(user));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserResponse> signIn(@RequestBody SignInRequest signInRequest) {
        var user = authService.signIn(signInRequest);
        return ResponseEntity.ok(new UserResponse(user));
    }
}
