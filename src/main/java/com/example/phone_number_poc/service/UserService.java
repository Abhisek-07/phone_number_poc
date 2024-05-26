package com.example.phone_number_poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phone_number_poc.model.User;
import com.example.phone_number_poc.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByMobileNo(user.getMobileNo());
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setComments(user.getComments());
            return userRepository.save(userToUpdate);
        } else {
            return userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
