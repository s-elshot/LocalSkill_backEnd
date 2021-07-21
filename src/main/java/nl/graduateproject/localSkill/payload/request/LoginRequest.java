package nl.graduateproject.localSkill.payload.Request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
