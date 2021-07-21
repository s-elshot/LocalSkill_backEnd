package nl.graduateproject.localSkill.service.security;


import nl.graduateproject.localSkill.service.security.jwt.AuthEntryPointJwt;
import nl.graduateproject.localSkill.service.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Hier gebruiken we de EnableGlobalMethodSecurity(prePostIsEnabled = true) om de @PreAuthorize annotaties te gebruiken
 * op andere plekken in de applicatie.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/item/").permitAll()
                .antMatchers("/customer/**").permitAll()
//                .antMatchers("/customer/**").hasRole("USER")
//                .antMatchers("/customer/**").hasRole("MODERATOR")
//                .antMatchers("/file/**").hasRole("USER")
//                .antMatchers("/file/**").hasRole("MODERATOR")
//                .antMatchers("/message/**").hasRole("USER")
//                .antMatchers("/message/**").hasRole("MODERATOR")
//                .antMatchers("/invoice/**").hasRole("USER")
//                .antMatchers("/invoice/**").hasRole("MODERATOR")

                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/customer/**").hasRole("USER")
                .antMatchers("/api/test/**").permitAll();
//                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
