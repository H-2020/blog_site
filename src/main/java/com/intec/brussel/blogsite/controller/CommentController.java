package com.intec.brussel.blogsite.controller;
import com.intec.brussel.blogsite.model.Review;
import com.intec.brussel.blogsite.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@RequiredArgsConstructor

public class CommentController {


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




}