package nl.graduateproject.localSkill.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }


    public JwtResponse(String jwt, Long id, String username, String email, String firstName, String lastName, String areaCode, String areaCode1, String city, CustomerGuild customerGuild, CustomerType userRole, String password, List<String> roles) {
    }
}
