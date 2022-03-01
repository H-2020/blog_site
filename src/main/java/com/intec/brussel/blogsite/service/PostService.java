package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    void deletePostById(Long id);

    void search(String keyword);
}
