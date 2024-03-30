package com.DEVLooping.cruddemo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.DEVLooping.cruddemo.dao.UserDAO;
import com.DEVLooping.cruddemo.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO theUserDAO){
        userDAO=theUserDAO;

    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int theId) {
        return userDAO.findById(theId);
    }
    @Transactional
    @Override
    public User save(User theUserDAO) {
        return userDAO.save(theUserDAO);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        userDAO.deleteById(theId);

    }

}
