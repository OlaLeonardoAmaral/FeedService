package com.amaral.IFeed.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaral.IFeed.dtos.CommentDTO;
import com.amaral.IFeed.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CommentDTO> createPost(@RequestBody CommentDTO comment) {
        return ResponseEntity.ok(commentService.commentPost(comment));
    }
}
