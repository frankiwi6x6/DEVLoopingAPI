package com.DEVLooping.cruddemo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.DEVLooping.cruddemo.dao.PostDAO;
import com.DEVLooping.cruddemo.entity.Post;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostDAO postDAO;

    public PostServiceImpl(PostDAO thePostDAO){
        postDAO=thePostDAO;

    }

    @Override
    public List<Post> findAll() {
        return postDAO.findAll();
    }

    @Override
    public Post findById(int theId) {
        return postDAO.findById(theId);
    }
    @Transactional
    @Override
    public Post save(Post thePostDAO) {
        return postDAO.save(thePostDAO);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        postDAO.deleteById(theId);

    }

}
