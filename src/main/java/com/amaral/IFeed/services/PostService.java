package com.amaral.IFeed.services;

import org.springframework.stereotype.Service;

import com.amaral.IFeed.dtos.CreatePostDTO;
import com.amaral.IFeed.entities.Post;
import com.amaral.IFeed.entities.User;
import com.amaral.IFeed.repositories.PostRepository;
import com.amaral.IFeed.repositories.UserRepository;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public CreatePostDTO createPost(CreatePostDTO post) {

        User user = userRepository
                .findById(post.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getIsAdmin()) {
            throw new RuntimeException("User is not an admin");
        }

        Post postEntity = new Post();
        postEntity.setText(post.content());
        postEntity.setUser(user);

        this.postRepository.save(postEntity);

        return new CreatePostDTO(postEntity.getText(), postEntity.getUser().getId());
    }
}
