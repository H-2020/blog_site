package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.Post;
import com.intec.brussel.blogsite.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;


    @Override
    public void createPost(@RequestBody Post post) {
        this.postRepo.save(post);

    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        Optional<Post> optionalPost = postRepo.findById(id);
        Post post = null;
        if (optionalPost.isPresent()) {
            post = optionalPost.get();
        } else {
            throw new RuntimeException("Post is not found for this ID : " + id);
        }
        return Optional.of(post);
    }

    @Override
    public void deletePostById(Long id) {
        this.postRepo.deleteById(id);
    }

    @Override
    public List<Post> search(String keyword) {
    return this.postRepo.findAllByTitleIsLikeOrContentIsLike(keyword,keyword);
    }

}