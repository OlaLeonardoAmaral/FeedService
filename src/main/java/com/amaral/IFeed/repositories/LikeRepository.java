package com.amaral.IFeed.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaral.IFeed.entities.Like;

public interface LikeRepository extends JpaRepository<Like, String> {
    Optional<Like> findByPostIdAndUserId(String postId, String userId);
} 