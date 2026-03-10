package com.example.bookapi.service;

import com.example.bookapi.exception.UserNotFoundException;
import com.example.bookapi.repository.UserRepository;
import com.example.bookapi.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;


    }
    //Create user....
    public User addUser(User user) {
        return userRepository.save(user);
    }
    //Return all users...
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //Read by id..
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not Found with id "+id));
    }
    //Update
    public User updatedUser(int id, User userDetails) {
        User existing = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id " + id));

        // modelMapper ki jagah manually set karo
        existing.setName(userDetails.getName());
        existing.setEmail(userDetails.getEmail());

        return userRepository.save(existing);
    }
    //Delete
    public void  deleteUser(int id) {
        if(!userRepository.existsById(id)) {
            throw  new UserNotFoundException("User not found with id "+id);
        }
        userRepository.deleteById(id);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
    public List<User> getUsersOlderThan(Integer age) {
        return userRepository.findByAgeGreaterThan(age);
    }
}
