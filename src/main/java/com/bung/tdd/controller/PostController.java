package com.bung.tdd.controller;

import com.bung.tdd.dto.PostRequest;
import com.bung.tdd.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody PostRequest postRequest) {
        Long id = postService.createPost(postRequest);
        return ResponseEntity.ok(Map.of("id", id));
    }

}
