package com.bung.tdd.service;

import com.bung.tdd.domain.Post;
import com.bung.tdd.dto.PostRequest;
import com.bung.tdd.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    PostService postService;

    @Mock
    PostRepository postRepository;


    @Test
    void create_테스트1(){
        //given
        PostRequest postRequest = new PostRequest("제목1", "내용1");
        Post saved = Post.builder()
                .title("제목")
                .content("내용")
                .build();
        ReflectionTestUtils.setField(saved, "id", 1L);
        given(postRepository.save(any(Post.class))).willReturn(saved);

        //when
        Long id = postService.createPost(postRequest);
        //then
        assertThat(id).isInstanceOf(Long.class);
    }

    @Test
    void create_테스트2(){
        //given
        PostRequest postRequest = new PostRequest("제목2", "내용2");
        Post saved = Post.builder()
                .title("제목")
                .content("내용")
                .build();
        ReflectionTestUtils.setField(saved, "id", 1L);
        given(postRepository.save(any(Post.class))).willReturn(saved);
        //when
        Long id = postService.createPost(postRequest);
        //then
        verify(postRepository).save(any(Post.class));
    }

    @Test
    void create_테스트3(){
        //given
        PostRequest postRequest = new PostRequest("", "내용");
        //when & then
        assertThatThrownBy(() -> postService.createPost(postRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("제목이 없습니다");
    }

}