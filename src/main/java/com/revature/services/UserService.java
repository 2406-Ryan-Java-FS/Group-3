package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.models.User;

import com.revature.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
   
    
    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setPassword(userDetails.getPassword());
                    user.setRole(userDetails.getRole());
                    user.setTokenExpiresOn(userDetails.getTokenExpiresOn());
                    user.setTokenIssuedOn(userDetails.getTokenIssuedOn());
                    user.setTokenId(userDetails.getTokenId());
                    user.setTokenPassword(userDetails.getTokenPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    
    
}
