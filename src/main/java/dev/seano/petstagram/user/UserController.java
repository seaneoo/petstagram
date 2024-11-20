package dev.seano.petstagram.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok(userService.findAll().toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return user.map(value -> ResponseEntity.ok(value.toString()))
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
