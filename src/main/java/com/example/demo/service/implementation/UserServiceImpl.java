package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(User entity) {
        userRepository.save(entity);
        return userRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        userRepository.deleteById(id);
        return userRepository.findById(id).isEmpty();
    }

    @Override
    public User verifyUser(String guidString) {
        User user = userRepository.findByGuid(guidString);
        if (user != null) {
            return user;
        }

        return null;
    }

    @Override
    public User validatePassword(User user, String recentPassword, String newPassword, String confirmPassword) {
        if (!passwordEncoder.matches(recentPassword, user.getPassword())) {
            return null; // Recent password is incorrect
        }
        if (!newPassword.equals(confirmPassword)) {
            return null; // New password and confirm password do not match
        }
        return user; // Passwords are valid
    }
    
    @Override
    public User authenticate(String username, String password) {
      User user = userRepository.findByUsername(username);
      if (user != null && passwordEncoder.matches(password, user.getPassword())) {
        return user;
      }
      return null;
    }
}
