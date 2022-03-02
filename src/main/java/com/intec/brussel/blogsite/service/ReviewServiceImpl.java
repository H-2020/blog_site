package com.intec.brussel.blogsite.service;
import com.intec.brussel.blogsite.model.Review;
import com.intec.brussel.blogsite.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Override
    public void createComment(Review review) {
        this.reviewRepo.save(review);
    }

    @Override
    public Review getCommentById(Long id) {
        Optional<Review> optional = reviewRepo.findById(id);
        Review review = null;
        if (optional.isPresent()){
            review=optional.get();
        }else{
            throw new RuntimeException("Comment not found: " + id);
        }
        return review;
    }


    @Override
    public void deleteCommentById(Long id) {
        this.reviewRepo.deleteById(id);
    }

    @Override
    public void createRating(Review rating) {
        this.reviewRepo.save(rating);

    }

    @Override
    public Review getRatingById(Long id) {
        return null;
    }
}