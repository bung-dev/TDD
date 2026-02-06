package com.bung.tdd.service;

import com.bung.tdd.domain.Post;
import com.bung.tdd.dto.PostRequest;
import com.bung.tdd.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long createPost(PostRequest request){
        if (request.title().isBlank()) {
            throw new IllegalArgumentException("제목이 없습니다");
        }
        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .build();

        return postRepository.save(post).getId();
    }
}
