package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    void createPost(Post post);

    List<Post> getAllPosts();

    Optional<Post> getPostById(Long id);

    void deletePostById(Long id);

    void search(String keyword);

}



