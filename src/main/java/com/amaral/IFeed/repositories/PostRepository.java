package com.amaral.IFeed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaral.IFeed.entities.Post;

public interface PostRepository extends JpaRepository<Post, String> {
}
