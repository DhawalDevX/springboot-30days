package com.example.bookapi.repository;

import com.example.bookapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByName(String name);
    List<User> findByAgeGreaterThan(Integer age);

}
