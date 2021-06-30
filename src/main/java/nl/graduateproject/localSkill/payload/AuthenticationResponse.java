package nl.graduateproject.localSkill.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data

public class AuthenticationResponse {

    private final String jwt;
}
