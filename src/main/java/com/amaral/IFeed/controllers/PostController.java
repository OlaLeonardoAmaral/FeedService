package com.amaral.IFeed.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaral.IFeed.dtos.CreatePostDTO;
import com.amaral.IFeed.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<CreatePostDTO> createPost(@RequestBody CreatePostDTO post) {
        return ResponseEntity.ok(postService.createPost(post));
    }
}
