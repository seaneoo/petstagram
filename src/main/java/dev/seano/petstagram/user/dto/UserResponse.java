package dev.seano.petstagram.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.seano.petstagram.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String username;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    public UserResponse(User user) {
        this(user.getId(), user.getUsername(), user.getCreatedAt());
    }
}
