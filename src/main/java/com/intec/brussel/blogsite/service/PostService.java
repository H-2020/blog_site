package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.Post;

import java.util.List;
import java.util.Optional;


public interface PostService {

    void createPost(Post post);

    List<Post> getAllPosts();

    Optional<Post> getPostById(Long id);

    void deletePostById(Long id);


    List<Post> search(String keyword);

}


