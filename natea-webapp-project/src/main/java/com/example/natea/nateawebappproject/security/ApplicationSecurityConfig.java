package com.example.natea.nateawebappproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import static com.example.natea.nateawebappproject.security.ApplicationUserRole.*;


import com.example.natea.nateawebappproject.service.NATEAUserDetailsService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

    private final PasswordEncoder passwordEncoder;
    private final NATEAUserDetailsService NateaUserDetailsService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, NATEAUserDetailsService NateaUserDetailsService){
        this.passwordEncoder = passwordEncoder;
        this.NateaUserDetailsService = NateaUserDetailsService;
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
        //auth.userDetailsService(NateaUserDetailsService);
    }
    
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(NateaUserDetailsService);
        return provider;
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // order matters 
        http
                .csrf().disable() // TODO: important, need to avoid csrf attack on logout get (should be post instead) request
                .authorizeRequests()
                .antMatchers("/","index", "/css/*","/js/*").permitAll()
                //.antMatchers(HttpMethod.GET, "/members/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
                /*
                .antMatchers(HttpMethod.GET, "/members/**").hasAuthority(ApplicationUserPermission.ADMIN_READ.getPermission())
                .antMatchers(HttpMethod.POST, "/members/**").hasAuthority(ApplicationUserPermission.ADMIN_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/members/**").hasAuthority(ApplicationUserPermission.ADMIN_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/members/**").hasAuthority(ApplicationUserPermission.ADMIN_WRITE.getPermission())
                */
                .anyRequest()
                .authenticated()
                .and().formLogin();
                //.loginPage("/login").permitAll();
                /*
                .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))  // TODO: may need to change to POST
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/login");
                */
    }
/*
    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails annaSmithUser = User.builder()
            .username("annasmith")
            .password(passwordEncoder.encode("password"))
            //.roles(ApplicationUserRole.MEMBER.name())
            .authorities(ADMIN.getGrantedAuthorities())
            .build();

        UserDetails yingUser = User.builder()
            .username("ying")
            .password(passwordEncoder.encode("passwordother"))
            //.roles(ApplicationUserRole.ADMIN.name())
            .authorities(ADMIN.getGrantedAuthorities())
            .build();

        return new InMemoryUserDetailsManager(
            annaSmithUser,
            yingUser
        );
    }
    */
}