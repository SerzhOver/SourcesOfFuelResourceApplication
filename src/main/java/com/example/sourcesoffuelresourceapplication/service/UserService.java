package com.example.sourcesoffuelresourceapplication.service;

import com.example.sourcesoffuelresourceapplication.auth.ApplicationUserDetails;
import com.example.sourcesoffuelresourceapplication.model.User;
import com.example.sourcesoffuelresourceapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public ApplicationUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);

        return new ApplicationUserDetails(optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Username not found")));
    }
}
