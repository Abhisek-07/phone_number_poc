package com.example.phone_number_poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phone_number_poc.model.User;
import com.example.phone_number_poc.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);
        Optional<User> existingUser = userRepository.findByMobileNo(user.getMobileNo());
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            System.out.println(userToUpdate.getMobileNo().toString());
            userToUpdate.setName(user.getName());
            userToUpdate.setComments(user.getComments());
            userToUpdate.setUpdatedAt(currentDateTime); // Update updatedAt field
            return userRepository.save(userToUpdate);
        } else {
            return userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
