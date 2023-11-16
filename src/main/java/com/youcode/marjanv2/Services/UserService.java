package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.User;
import com.youcode.marjanv2.Repositories.UserRepository;
import com.youcode.marjanv2.Services.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
        ResponseEntity.status(HttpStatus.OK).body("User created successfully");
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new CustomException("User with ID " + userId + " not found");
        }
    }
}