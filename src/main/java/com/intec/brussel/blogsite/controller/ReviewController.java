package com.intec.brussel.blogsite.controller;
import com.intec.brussel.blogsite.model.Review;
import com.intec.brussel.blogsite.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {


    private final ReviewService reviewService;
    @PostMapping("/createReviews")
    public String createComment(@ModelAttribute("comment")Review review){
        reviewService.createComment(review);
        return "comment:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){
        Review review  = reviewService.getCommentById(id);
        model.addAttribute("comment", review);
        return "update_comment";
    }
    @GetMapping("/delete/{id}")
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