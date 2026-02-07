package com.bung.tdd.controller;

import com.bung.tdd.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = PostController.class)
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    PostService postService;

    @Test
    void post_method_테스트() {
        //given


        //when & then

    }

}