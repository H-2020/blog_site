package com.intec.brussel.blogsite.controller;
import com.intec.brussel.blogsite.model.Review;
import com.intec.brussel.blogsite.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/blogsite")
public class ReviewController {


    private final ReviewService reviewService;
    @PostMapping("/createComment")
    public String createComment(@ModelAttribute("comment")Review review){
        reviewService.createComment(review);
        return "comment:/";
    }

    @GetMapping("/showUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){
        Review review  = reviewService.getCommentById(id);
        model.addAttribute("comment", review);
        return "update_comment";
    }

    public String deleteComment(@PathVariable (value = "id") Long id){
        this.reviewService.deleteCommentById(id);
        return "redirect:/";
    }


    @GetMapping
    public String main(Model model) {
        model.addAttribute("rating", new Review());
        return "index";
    }

    @PostMapping
    public String save(Review rating, Model model) {
        model.addAttribute("rating", rating);
        return "saved";
    }




}