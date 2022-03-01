package com.intec.brussel.blogsite.repository;
import com.intec.brussel.blogsite.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Long> {
}