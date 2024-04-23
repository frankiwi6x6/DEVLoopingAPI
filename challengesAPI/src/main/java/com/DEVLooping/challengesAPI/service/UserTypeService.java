package com.DEVLooping.challengesAPI.service;

import java.util.List;

import com.DEVLooping.challengesAPI.entity.UserType;

public interface UserTypeService {

    List<UserType> findAll();

    UserType findById(int theId);

    UserType save(UserType theUser);

    void deleteById(int theId);


}
