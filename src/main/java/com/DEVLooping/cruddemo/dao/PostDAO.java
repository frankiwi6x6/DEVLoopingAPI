package com.DEVLooping.cruddemo.dao;

import java.util.List;

import com.DEVLooping.cruddemo.entity.Post;

public interface PostDAO {

    List<Post> findAll();

    Post findById(int theId);

    Post save(Post thePost);

    void deleteById(int theId);


 }
