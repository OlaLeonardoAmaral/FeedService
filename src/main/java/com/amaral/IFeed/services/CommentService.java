package com.amaral.IFeed.services;

import org.springframework.stereotype.Service;

import com.amaral.IFeed.dtos.CommentDTO;
import com.amaral.IFeed.entities.Comment;
import com.amaral.IFeed.entities.Post;
import com.amaral.IFeed.entities.User;
import com.amaral.IFeed.repositories.CommentRepository;
import com.amaral.IFeed.repositories.PostRepository;
import com.amaral.IFeed.repositories.UserRepository;

@Service
public class CommentService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, UserRepository userRepository,
            CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public CommentDTO commentPost(CommentDTO comment) {
        User user = userRepository
                .findById(comment.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postRepository.findById(comment.postId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment commentEntity = new Comment();
        commentEntity.setText(comment.text());
        commentEntity.setUser(user);
        commentEntity.setPost(post);
        this.commentRepository.save(commentEntity);

        return new CommentDTO(
                commentEntity.getText(),
                commentEntity.getUser().getId(),
                commentEntity.getPost().getId());
    }
}
