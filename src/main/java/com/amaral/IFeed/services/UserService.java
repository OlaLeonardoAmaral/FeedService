package com.amaral.IFeed.services;

import org.springframework.stereotype.Service;

import com.amaral.IFeed.dtos.CreateUserDTO;
import com.amaral.IFeed.entities.User;
import com.amaral.IFeed.repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username());
        user.setIsAdmin(userDTO.isAdmin());
        return userRepository.save(user);
    }
}
