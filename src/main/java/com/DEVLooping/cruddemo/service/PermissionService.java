package com.DEVLooping.cruddemo.service;

import java.util.List;

import com.DEVLooping.cruddemo.entity.Permission;

public interface PermissionService {

    List<Permission> findAll();

    Permission findById(int theId);

    Permission save(Permission thePermission);

    void deleteById(int theId);


}
