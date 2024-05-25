package com.example.phone_number_poc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.phone_number_poc.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMobileNo(String mobileNo);
}

