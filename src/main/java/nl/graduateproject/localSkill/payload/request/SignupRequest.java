package nl.graduateproject.localSkill.payload.request;

import lombok.Data;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private  String firstName;
    private String lastName;
    private String areaCode;
    private String city;
    private CustomerGuild customerGuild;
    private CustomerType userRole;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    private Set<String> role;

}
