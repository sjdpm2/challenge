package com.telusinternational.challenge.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.telusinternational.challenge.dto.UserRegistrationDTO;
import com.telusinternational.challenge.model.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDTO registration);
    
    User getLoggedUser();
}