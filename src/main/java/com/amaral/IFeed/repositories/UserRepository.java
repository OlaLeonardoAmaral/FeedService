package com.amaral.IFeed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaral.IFeed.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
