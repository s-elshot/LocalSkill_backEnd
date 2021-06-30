package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.exceptions.RecordNotFoundException;
import nl.graduateproject.localSkill.model.authority.Authority;
import nl.graduateproject.localSkill.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomCustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

//    @Autowired
//    private AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Customer> customer = customerService.getCustomerByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException(username);
        }

        String password = customer.get().getPassword();

        Set<Authority> authorities = customer.get().getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }

}

