package com.DEVLooping.cruddemo.service;

import java.util.List;

import com.DEVLooping.cruddemo.entity.User;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);


}