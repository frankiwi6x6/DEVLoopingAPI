package com.DEVLooping.challengesAPI.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.DEVLooping.challengesAPI.entity.Permission;

import java.util.List;

@Repository
public class PermissionDAOJpaImpl implements PermissionDAO {

    // definir campo para entityManager

    private EntityManager entityManager;

    // asignar inyeccion de constructor

    public PermissionDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Permission> findAll() {

        // crear una consulta
        TypedQuery<Permission> theQuery = entityManager.createQuery("FROM Permission", Permission.class);

        // ejecutar la consulta y obtener resultados
        List<Permission> permissions = theQuery.getResultList();


        return permissions;
    }

    @Override
    public Permission findById(int theId) {

        Permission permission = entityManager.find(Permission.class, theId);
        return permission;
    }

    @Override
    public Permission save(Permission thePermission) {

        Permission dbPermission = entityManager.merge(thePermission);

        return dbPermission;
    }

    @Override
    public void deleteById(int theId) {

        Permission dbPermission = entityManager.find(Permission.class, theId);

        entityManager.remove(dbPermission);

    }
}
