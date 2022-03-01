package com.intec.brussel.blogsite.controller;


import com.intec.brussel.blogsite.model.Post;
import com.intec.brussel.blogsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("comment") Post post){
        postService.createPost(post);
        return "post:/";
    }

    @GetMapping("/updatePost}")
    public String updatePost(@PathVariable Long id, Model model){
        Post post  = postService.getPostById(id);
        model.addAttribute("post", post);
        return "update_post";
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Long id ){
        this.postService.deletePostById(id);
        return "redirect:/";
    }

}
