package org.userregistrationapplication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// User Service
@Service
class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Error: Username already exists!";
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Error: Email is already registered!";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }
}
