package com.amaral.IFeed.services;

import org.springframework.stereotype.Service;

import com.amaral.IFeed.dtos.CreatePostDTO;
import com.amaral.IFeed.entities.Post;
import com.amaral.IFeed.entities.User;
import com.amaral.IFeed.repositories.PostRepository;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public CreatePostDTO createPost(CreatePostDTO post) {

        User user = userService.findUserById(post.userId());

        if (!user.getIsAdmin()) {
            throw new RuntimeException("User is not an admin");
        }

        Post postEntity = new Post();
        postEntity.setText(post.content());
        postEntity.setUser(user);

        this.postRepository.save(postEntity);

        return new CreatePostDTO(postEntity.getText(), postEntity.getUser().getId());
    }

    public Post findPostById(String postId) {
        Post post = postRepository
                .findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return post;

    }
}
