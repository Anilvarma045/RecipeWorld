package com.RecipeWorld.RecipeWorld.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecipeWorld.RecipeWorld.model.User;
import com.RecipeWorld.RecipeWorld.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);

    }
    
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(Updateuser -> {
                    user.setFullName(user.getFullName());
                    user.setEmail(user.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   
    // Delete user by ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    
    
}
