package com.amaral.IFeed.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaral.IFeed.dtos.CreateUserDTO;
import com.amaral.IFeed.entities.User;
import com.amaral.IFeed.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity<User> creatUser(@RequestBody CreateUserDTO userDTO) {
        User userCreated = userService.createUser(userDTO);
        return ResponseEntity.ok(userCreated);
    }
    
}
