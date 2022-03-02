package com.intec.brussel.blogsite.controller;

import com.intec.brussel.blogsite.model.Post;
import com.intec.brussel.blogsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping({ "/"})
public class HomeController {

    private final PostService postService;



    @GetMapping("/")
    public String displayAllPosts(Model model) {


        List<Post> posts = this.postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "home";
    }
}
