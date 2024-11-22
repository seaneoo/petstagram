package dev.seano.petstagram.auth;

import dev.seano.petstagram.auth.dto.SignInRequest;
import dev.seano.petstagram.auth.dto.SignUpRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return ResponseEntity.ok(signUpRequest.toString());
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(signInRequest.toString());
    }
}
