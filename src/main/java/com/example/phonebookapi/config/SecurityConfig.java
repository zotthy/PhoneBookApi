package com.example.phonebookapi.config;

import com.example.phonebookapi.Security.BearerTokenFilter;
import com.example.phonebookapi.Security.JwtAuthenticationFilter;
import com.example.phonebookapi.Security.JwtService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Profile("final")
@Configuration
class SecurityConfigFinal {
    private final JwtService jwtService;

    public SecurityConfigFinal(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           MvcRequestMatcher.Builder mvc,
                                           AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        AuthenticationManager authenticationManager = authenticationManagerBuilder.getOrBuild();
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtService);
        BearerTokenFilter bearerTokenFilter = new BearerTokenFilter(jwtService);
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(mvc.pattern("/auth")).permitAll()
                .requestMatchers(mvc.pattern("/admin/acceptable")).hasRole("ADMIN")
                .requestMatchers(mvc.pattern("/admin/acceptable/{id}")).hasRole("ADMIN")
                .requestMatchers(mvc.pattern("/admin/acceptable/update/{id}")).hasRole("ADMIN")
                .requestMatchers(mvc.pattern("admin/all-data")).hasRole("ADMIN")
                .requestMatchers(mvc.pattern(HttpMethod.PUT,"/admin/acceptable/{id})")).hasRole("ADMIN")
                .requestMatchers(mvc.pattern("/data/all")).permitAll()
                .requestMatchers(mvc.pattern("/data/find")).permitAll()
                .requestMatchers(mvc.pattern("/data/add")).hasRole("USER")
                .requestMatchers(mvc.pattern("/data/{id}")).hasRole("USER")
                .anyRequest().permitAll()
        );
        http.sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrfCustomizer -> csrfCustomizer.disable());
        http.addFilterBefore(jwtAuthenticationFilter, AuthorizationFilter.class);
        http.addFilterBefore(bearerTokenFilter, AuthorizationFilter.class);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

@Profile("h2")
@Configuration
class SecurityConfigH2 {
    private final JwtService jwtService;

    public SecurityConfigH2(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           MvcRequestMatcher.Builder mvc,
                                           AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        AuthenticationManager authenticationManager = authenticationManagerBuilder.getOrBuild();
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtService);
        BearerTokenFilter bearerTokenFilter = new BearerTokenFilter(jwtService);
        PathRequest.H2ConsoleRequestMatcher h2ConsoleRequestMatcher = PathRequest.toH2Console(); //dostep do h2
        http.authorizeHttpRequests(requests -> requests
                .anyRequest().permitAll()
        );
        http.sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrfCustomizer -> csrfCustomizer.disable());
        http.headers().frameOptions().disable();
        http.addFilterBefore(jwtAuthenticationFilter, AuthorizationFilter.class);
        http.addFilterBefore(bearerTokenFilter, AuthorizationFilter.class);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}