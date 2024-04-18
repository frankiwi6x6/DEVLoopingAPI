package com.DEVLooping.cruddemo.dao;

import java.util.List;

import com.DEVLooping.cruddemo.entity.Permission;

public interface PermissionDAO {

    List<Permission> findAll();

    Permission findById(int theId);

    Permission save(Permission theUser);

    void deleteById(int theId);

}
