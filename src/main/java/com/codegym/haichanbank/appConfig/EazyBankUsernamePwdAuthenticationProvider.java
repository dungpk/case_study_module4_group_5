//package com.codegym.haichanbank.appConfig;
//
<<<<<<< HEAD
//import com.codegym.haichanbank.model.Authority;
//import com.codegym.haichanbank.model.Customer;
//import com.codegym.haichanbank.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
=======
//import com.codegym.haichanbank.model.Customer;
//import com.codegym.haichanbank.repository.CustomerRepository;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
>>>>>>> f90c68b692e92908d8bda915510168a4ffb37964
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
<<<<<<< HEAD
//import java.util.Set;
//
//@Component
//public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
=======
//
//@Component
//public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
//
//@Autowired
//private CustomerRepository customerRepository;
>>>>>>> f90c68b692e92908d8bda915510168a4ffb37964
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String pwd = authentication.getCredentials().toString();
//        List<Customer> customer = customerRepository.findByEmail(username);
//        if (customer.size() > 0) {
//            if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
//                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(customer.get(0).getAuthorities()));
//            } else {
//                throw new BadCredentialsException("Invalid password!");
//            }
//        }else {
//            throw new BadCredentialsException("No user registered with this details!");
//        }
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Authority authority : authorities) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
//        }
//        return grantedAuthorities;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
<<<<<<< HEAD
//    }
//
=======
//        }
//
//
//
//
//
//@Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//            CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
//            requestHandler.setCsrfRequestAttributeName("_csrf");
//            JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//            jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
//
//            http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
//@Override
//public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//        config.setAllowedMethods(Collections.singletonList("*"));
//        config.setAllowCredentials(true);
//        config.setAllowedHeaders(Collections.singletonList("*"));
//        config.setExposedHeaders(Arrays.asList("Authorization"));
//        config.setMaxAge(3600L);
//        return config;
//        }
//        })).csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact","/register")
//        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//        .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
//        .authorizeHttpRequests((requests)->requests
//        .requestMatchers("/myAccount").hasRole("USER")
//        .requestMatchers("/myBalance").hasAnyRole("USER","ADMIN")
//        .requestMatchers("/myLoans").authenticated()
//        .requestMatchers("/myCards").hasRole("USER")
//        .requestMatchers("/user").authenticated()
//        .requestMatchers("/notices","/contact","/register").permitAll())
//        .oauth2ResourceServer(oauth2ResourceServerCustomizer ->
//        oauth2ResourceServerCustomizer.jwt(jwtCustomizer -> jwtCustomizer.jwtAuthenticationConverter(jwtAuthenticationConverter)));
//        return http.build();
//        }
//
>>>>>>> f90c68b692e92908d8bda915510168a4ffb37964
//}
//
