package com.DEVLooping.cruddemo.dao;

import java.util.List;

import com.DEVLooping.cruddemo.entity.UserType;

public interface UserTypeDAO {

    List<UserType> findAll();

    UserType findById(int theId);

    UserType save(UserType theUser);

    void deleteById(int theId);


 }