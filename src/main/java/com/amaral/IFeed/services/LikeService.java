package com.amaral.IFeed.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amaral.IFeed.dtos.LikeDTO;
import com.amaral.IFeed.entities.Like;
import com.amaral.IFeed.entities.Post;
import com.amaral.IFeed.entities.User;
import com.amaral.IFeed.repositories.LikeRepository;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostService postService;
    private final UserService userService;

    public LikeService(LikeRepository likeRepository, PostService postService, UserService userService) {
        this.likeRepository = likeRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public LikeDTO likePost(LikeDTO likeDTO) {

        Post post = postService.findPostById(likeDTO.postId());
        User user = userService.findUserById(likeDTO.userId());

        Optional<Like> like = likeRepository
                .findByPostIdAndUserId(likeDTO.postId(), likeDTO.userId());

        if (like.isPresent()) {
            likeRepository.deleteById(like.get().getId());
            return likeDTO;
        }

        Like likeEntity = new Like();
        likeEntity.setPost(post);
        likeEntity.setUser(user);

        likeRepository.save(likeEntity);
        return likeDTO;
    }

}
