<<<<<<< HEAD
package com.codegym.haichanbank.appConfig;

import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
//public class EazyBankUserDetails implements UserDetailsService {
=======
//package com.codegym.haichanbank.appConfig;
//
//import com.codegym.haichanbank.model.Customer;
//import com.codegym.haichanbank.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class EazyBankUserDetails  implements UserDetailsService {
>>>>>>> f90c68b692e92908d8bda915510168a4ffb37964
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        String userName, password = null;
//        List<GrantedAuthority> authorities = null;
//        List<Customer> customer = customerRepository.findByEmail(username);
//        if (customer.size() == 0) {
//            throw new UsernameNotFoundException("User details not found for the user : " + username);
//        } else{
//            userName = customer.get(0).getEmail();
//            password = customer.get(0).getPwd();
//            authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
//        }
//        return new User(username,password,authorities);
//    }
<<<<<<< HEAD
//
=======
>>>>>>> f90c68b692e92908d8bda915510168a4ffb37964
//}
