package com.example.securebank.configuration;

import com.example.securebank.entity.Customer;
import com.example.securebank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecureBankUserDetails implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authority = null;
        List<Customer> listCustomer = customerRepository.findByEmail(username);
        if(listCustomer.size() == 0 ) {
            throw new UsernameNotFoundException("User details not found fot the user: " + username);
        } else {
            username = listCustomer.get(0).getEmail();
            password = listCustomer.get(0).getPwd();
            authority = new ArrayList<>();
            authority.add(new SimpleGrantedAuthority(listCustomer.get(0).getRole()));
        }
        return new User(username, password, authority);
    }
}
