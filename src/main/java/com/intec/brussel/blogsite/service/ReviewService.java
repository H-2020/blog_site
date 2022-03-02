package com.intec.brussel.blogsite.service;
import com.intec.brussel.blogsite.model.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {

    void createComment(Review review);
    Review getCommentById(Long id);
    void deleteCommentById(Long id);

    void createRating(Review rating);
    Review getRatingById(Long id);

}