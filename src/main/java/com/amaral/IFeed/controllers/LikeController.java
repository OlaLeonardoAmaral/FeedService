package com.amaral.IFeed.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaral.IFeed.dtos.LikeDTO;
import com.amaral.IFeed.services.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }


    @PostMapping
    public ResponseEntity<LikeDTO> like(@RequestBody LikeDTO likeDTO) {
        LikeDTO like = likeService.likePost(likeDTO);
        return ResponseEntity.ok(like);
    }
}
