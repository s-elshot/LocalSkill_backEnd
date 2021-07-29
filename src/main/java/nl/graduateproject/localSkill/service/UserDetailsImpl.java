package nl.graduateproject.localSkill.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final Long id;
    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String areaCode;
    private final String city;
    private final CustomerGuild customerGuild;
    private final CustomerType userRole;
    @JsonIgnore
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(long id, String username, String email,String firstName, String lastName,
                           String areaCode, String city, CustomerGuild customerGuild, CustomerType userRole,String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.areaCode = areaCode;
        this.city = city;
        this.customerGuild = customerGuild;
        this.userRole = userRole;
        this.password = password;
        this.authorities = authorities;
    }


    public static UserDetailsImpl build(Customer user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getAreaCode(),
                user.getCity(),
                user.getCustomerGuild(),
                user.getUserRole(),
                user.getPassword(),
                authorities);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getCity() {
        return city;
    }

    public CustomerGuild getCustomerGuild() {
        return customerGuild;
    }

    public CustomerType getUserRole() {
        return userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username,email,firstName, lastName,areaCode,city,customerGuild, userRole, password, authorities);
    }
}



