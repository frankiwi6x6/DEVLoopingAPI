package com.DEVLooping.challengesAPI.service;

import java.util.List;

import com.DEVLooping.challengesAPI.entity.Permission;

public interface PermissionService {

    List<Permission> findAll();

    Permission findById(int theId);

    Permission save(Permission thePermission);

    void deleteById(int theId);


}
