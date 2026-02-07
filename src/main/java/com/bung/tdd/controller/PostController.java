package com.bung.tdd.controller;

import com.bung.tdd.domain.Post;
import com.bung.tdd.dto.PostRequest;
import com.bung.tdd.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody PostRequest postRequest) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
