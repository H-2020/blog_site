package com.intec.brussel.blogsite.repository;

import com.intec.brussel.blogsite.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllByTitleIsLikeOrContentIsLike(String title, String content);

}