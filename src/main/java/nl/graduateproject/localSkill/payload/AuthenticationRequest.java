package nl.graduateproject.localSkill.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    // kan dit ondanks dat er in authority iets anders is gedefineerd?
    private String username;
    private String password;

}
