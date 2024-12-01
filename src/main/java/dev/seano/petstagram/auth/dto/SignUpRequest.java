package dev.seano.petstagram.auth.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^\\w+$")
    private String username;

    @NotNull
    @Size(min = 8, max = 100)
    private String password;
}
