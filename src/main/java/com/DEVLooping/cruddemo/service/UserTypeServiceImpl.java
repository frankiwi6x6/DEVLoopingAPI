package com.DEVLooping.cruddemo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.DEVLooping.cruddemo.dao.UserTypeDAO;
import com.DEVLooping.cruddemo.entity.UserType;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService{

    private UserTypeDAO userTypeDAO;

    public UserTypeServiceImpl(UserTypeDAO theUserTypeDAO){
        userTypeDAO=theUserTypeDAO;

    }

    @Override
    public List<UserType> findAll() {
        return userTypeDAO.findAll();
    }

    @Override
    public UserType findById(int theId) {
        return userTypeDAO.findById(theId);
    }
    @Transactional
    @Override
    public UserType save(UserType theUserDAO) {
        return userTypeDAO.save(theUserDAO);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        userTypeDAO.deleteById(theId);

    }

}
