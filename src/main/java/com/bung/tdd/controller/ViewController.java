package com.bung.tdd.controller;

import com.bung.tdd.domain.Post;
import com.bung.tdd.dto.PostRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String getPage(Model model) {

        List<Post> postEntityList = new ArrayList<>();
        model.addAttribute("VIEWLIST", postEntityList);

        return "viewPage";
    }

    @PostMapping("/view")
    public String postPage(PostRequest request) {

        return "redirect:/view";
    }
}
