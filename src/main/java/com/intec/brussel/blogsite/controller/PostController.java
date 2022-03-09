package com.intec.brussel.blogsite.controller;


import com.intec.brussel.blogsite.model.Post;
import com.intec.brussel.blogsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Post> posts = this.postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "/home";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Post post) {
        this.postService.createPost(post);
        return "redirect:/write-post";
    }

    @GetMapping("/update/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postService.getPostById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", optionalPost);
        }
        return "update:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        Optional<Post> optionalPost = this.postService.getPostById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            this.postService.deletePostById(id);
        }
        return "redirect:/";
    }




}

