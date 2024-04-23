package com.DEVLooping.challengesAPI.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.DEVLooping.challengesAPI.dao.PermissionDAO;
import com.DEVLooping.challengesAPI.entity.Permission;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    private PermissionDAO permissionDAO;

    public PermissionServiceImpl(PermissionDAO thePermissionDAO){
        permissionDAO=thePermissionDAO;

    }

    @Override
    public List<Permission> findAll() {
        return permissionDAO.findAll();
    }

    @Override
    public Permission findById(int theId) {
        return permissionDAO.findById(theId);
    }
    @Transactional
    @Override
    public Permission save(Permission thePermissionDAO) {
        return permissionDAO.save(thePermissionDAO);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        permissionDAO.deleteById(theId);

    }

}
