package com.DEVLooping.cruddemo.service;

import java.util.List;

import com.DEVLooping.cruddemo.entity.Post;

public interface PostService {

    List<Post> findAll();

    Post findById(int theId);

    Post save(Post thePost);

    void deleteById(int theId);


}
