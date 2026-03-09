package com.example.bookapi.controller;

import com.example.bookapi.dto.BookDTO;
import com.example.bookapi.dto.UserDTO;
import com.example.bookapi.exception.UserNotFoundException;
import com.example.bookapi.model.User;
import com.example.bookapi.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    public UserController(UserService userService,ModelMapper modelMapper) {
        this.userService=userService;
        this.modelMapper=modelMapper;
    }
    @PostMapping
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO dto) {
        User user=modelMapper.map(dto, User.class);
        User saved=userService.addUser(user);
        UserDTO response=modelMapper.map(saved, UserDTO.class);
        return ResponseEntity.status(201).body(response);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users=userService.getAllUsers();

        List<UserDTO> response=new ArrayList<>();

        for(User user:users) {
            response.add(modelMapper.map(user, UserDTO.class));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        User user=userService.getUserById(id);

        return  ResponseEntity.ok(modelMapper.map(user, UserDTO.class));

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable int id,
            @Valid @RequestBody UserDTO dto) {
        User user = modelMapper.map(dto, User.class);
        User updated = userService.updatedUser(id, user);
        return ResponseEntity.ok(
                modelMapper.map(updated, UserDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(
            @PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(
                modelMapper.map(user, UserDTO.class));
    }

}
