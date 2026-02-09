package com.bung.tdd.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers =  ViewController.class)
class ViewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void get_method_테스트() throws Exception {
        //given

        //when & then
        mockMvc.perform(get("/view"))
                .andExpect(status().isOk())
                .andExpect(view().name("viewPage"))
                .andExpect(model().attributeExists("VIEWLIST"));
    }

    @Test
    void post_method_테스트() throws Exception {
        //given
        String title = "제목";
        String content = "내용";

        //when & then
        mockMvc.perform(post("/view")
                .contentType(MediaType.APPLICATION_JSON)
                .param("title", title)
                .param("content", content))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/view"));
    }

}