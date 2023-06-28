package com.codegym.haichanbank.appConfig;

import com.codegym.haichanbank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
//public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

//@Autowired
//private CustomerRepository customerRepository;
//
//@Autowired
//private PasswordEncoder passwordEncoder;
//
//@Override
//public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String pwd = authentication.getCredentials().toString();
//        List<Customer> customer = customerRepository.findByEmail(username);
//        if (customer.size() > 0) {
//        if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
//        return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(customer.get(0).getAuthorities()));
//        } else {
//        throw new BadCredentialsException("Invalid password!");
//        }
//        }else {
//        throw new BadCredentialsException("No user registered with this details!");
//        }
//        }
//
//private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Authority authority : authorities) {
//        grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
//        }
//        return grantedAuthorities;
//        }
//
//@Override
//public boolean supports(Class<?> authentication) {
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//        }





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

//}
