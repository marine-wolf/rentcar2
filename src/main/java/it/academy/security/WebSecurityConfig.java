package it.academy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = {"it.academy"})
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/car-list*").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers(HttpMethod.GET, "/add-user*").permitAll()
                .antMatchers(HttpMethod.POST, "/add-user*").permitAll()
                .antMatchers(HttpMethod.POST, "/car-show*").permitAll()
                .antMatchers(HttpMethod.GET, "/car-show*").permitAll()
                .antMatchers(HttpMethod.GET, "/add-car*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-car*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/delete*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/delete*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/user-list*").hasRole("ADMIN")//
                .antMatchers(HttpMethod.GET, "/payment-list*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/contract-list*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add-contract*").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/add-contract*").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/add-payment*").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/add-payment*").hasAnyRole("ADMIN", "USER")//
                .and()
                .csrf().disable()
                .formLogin();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth,
                                        @Qualifier("authService") AuthenticationService service) throws Exception {
        auth.userDetailsService(service);
    }

}
